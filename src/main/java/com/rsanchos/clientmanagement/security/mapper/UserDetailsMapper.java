package com.rsanchos.clientmanagement.security.mapper;


import java.util.HashSet;
import java.util.Set;

import com.rsanchos.clientmanagement.security.models.entities.Role;
import com.rsanchos.clientmanagement.security.models.entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsMapper {

	public static UserDetails build(User user) {
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthorities(user));
	}

	private static Set<? extends GrantedAuthority> getAuthorities(User retrievedUser) {
		Set<Role> roles = retrievedUser.getRoles();

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));

		return authorities;
	}
}
