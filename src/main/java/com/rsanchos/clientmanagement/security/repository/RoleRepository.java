package com.rsanchos.clientmanagement.security.repository;


import com.rsanchos.clientmanagement.security.models.entities.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role getRoleById(long id);

	Role findByName(String name);
}
