package com.rsanchos.clientmanagement.security.service;


import com.rsanchos.clientmanagement.security.models.entities.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User getUser(long id);

	User save(User user);
}
