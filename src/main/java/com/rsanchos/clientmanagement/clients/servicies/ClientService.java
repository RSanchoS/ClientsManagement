package com.rsanchos.clientmanagement.clients.servicies;

import java.time.LocalDateTime;
import java.util.List;

import com.rsanchos.clientmanagement.clients.models.entities.Client;

public interface ClientService {

    public List<Client> findAll();

    public Client save(Client userData);

    public void remove(Client userData);

    public Client findByEmail(String email);

    public List<Client> findByClientBetweenBirthDates(LocalDateTime firstDate, LocalDateTime finalDate );
    
}
