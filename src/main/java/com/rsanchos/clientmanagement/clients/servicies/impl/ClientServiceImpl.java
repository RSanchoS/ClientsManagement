package com.rsanchos.clientmanagement.clients.servicies.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.rsanchos.clientmanagement.clients.models.entities.Client;
import com.rsanchos.clientmanagement.clients.repositories.ClientRepository;
import com.rsanchos.clientmanagement.clients.servicies.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {

        List<Client> clients = new ArrayList<>();

        clientRepository.findAll().forEach(client -> clients.add(client));;

        return clients;
    }

    @Override
    public Client save(Client client) {

        clientRepository.save(client);

        return client;
    }

    @Override
    public void remove(Client client) {

        clientRepository.delete(client);

    }

    @Override
    public Client findByEmail(String email) {

        return clientRepository.findByEmail(email).isPresent() ? clientRepository.findByEmail(email).get() : null;

    }

    @Override
    public List<Client> findByClientBetweenBirthDates(LocalDateTime firstDate, LocalDateTime finalDate) {

        List<Client> clients = new ArrayList<>();
        
        clientRepository
                .findByClientBetweenBirthDates(firstDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), finalDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
                .forEach(client -> clients.add(client));
        ;

        return clients;
    }
    
}
