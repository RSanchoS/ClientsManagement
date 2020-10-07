package com.rsanchos.clientmanagement.clients.repositories;

import java.util.List;
import java.util.Optional;

import com.rsanchos.clientmanagement.clients.models.entities.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    public Optional<Client> findByEmail(String email);
 
    @Query(value = "SELECT * FROM clients WHERE birth_date >= :firstDate AND birth_date <= :finalDate", nativeQuery = true)
    public List<Client> findByClientBetweenBirthDates(Long firstDate, Long finalDate);
}
