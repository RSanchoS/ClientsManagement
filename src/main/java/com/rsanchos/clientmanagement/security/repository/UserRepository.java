package com.rsanchos.clientmanagement.security.repository;

import java.util.List;
import java.util.Optional;

import com.rsanchos.clientmanagement.security.models.entities.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByName(String name);

	Optional<User> findById(long id);

	List<User> findAll();
}
