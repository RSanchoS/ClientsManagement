package com.rsanchos.clientmanagement.security.utils;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static com.rsanchos.clientmanagement.security.utils.Constants.*;

public class TokenProvider {

	private TokenProvider() {
	}

	public static String generateToken(Authentication authentication) {

		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		return Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setIssuer(ISSUER_TOKEN)
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
				.compact();
	}

	public static UsernamePasswordAuthenticationToken getAuthentication( String token,
			 UserDetails userDetails) {

		 JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);

		 Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

		 Claims claims = claimsJws.getBody();

		 Collection<SimpleGrantedAuthority> authorities =
				Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	public static String getUserName( String token) {
		 JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);

		 Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

		return claimsJws.getBody().getSubject();
	}

}
