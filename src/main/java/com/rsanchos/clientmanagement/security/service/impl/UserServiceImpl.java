package com.rsanchos.clientmanagement.security.service.impl;


import java.util.HashSet;
import java.util.Set;

import com.rsanchos.clientmanagement.security.mapper.UserDetailsMapper;
import com.rsanchos.clientmanagement.security.models.entities.Role;
import com.rsanchos.clientmanagement.security.models.entities.User;
import com.rsanchos.clientmanagement.security.repository.RoleRepository;
import com.rsanchos.clientmanagement.security.repository.UserRepository;
import com.rsanchos.clientmanagement.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User retrievedUser = userRepository.findByName(userName).get();
		if (retrievedUser == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return UserDetailsMapper.build(retrievedUser);
	}

	@Override
	public User getUser(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		
		Role userRole = roleRepository.findByName("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);

		User userToSave = User.builder().name(user.getName()).password(user.getPassword()).roles(roles).build();

		return userRepository.save(userToSave);
	}
}
