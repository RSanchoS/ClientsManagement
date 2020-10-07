package com.rsanchos.clientmanagement.clients.mappers.impl;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import com.rsanchos.clientmanagement.clients.mappers.ClientMapper;
import com.rsanchos.clientmanagement.clients.models.entities.Client;
import com.rsanchos.clientmanagement.clients.models.requestObject.ClientRequest;
import com.rsanchos.clientmanagement.clients.models.responseObject.ClientResponse;

import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientResponse from(Client client) {

        return ClientResponse.builder().id(client.getId()).email(client.getEmail()).name(client.getName())
                .surname(client.getSurname())
                .birthDate(client.getBirthDate() != null
                        ? OffsetDateTime.ofInstant(Instant.ofEpochMilli(client.getBirthDate()), ZoneId.systemDefault())
                        : null)
                .build();
    }

    @Override
    public Client from(ClientResponse clientResponse) {

        Client client = new Client();

        client.setId(clientResponse.getId());
        client.setEmail(clientResponse.getEmail());
        client.setName(clientResponse.getName());
        client.setSurname(clientResponse.getSurname());
        client.setBirthDate(
                clientResponse.getBirthDate() != null ? clientResponse.getBirthDate().toInstant().toEpochMilli()
                        : null);

        return client;
    }

    @Override
    public Client from(ClientRequest clientRequest) {

        Client client = new Client();

        client.setId(clientRequest.getId());
        client.setEmail(clientRequest.getEmail());
        client.setName(clientRequest.getName());
        client.setSurname(clientRequest.getSurname());
        client.setBirthDate(
            clientRequest.getBirthDate() != null ? clientRequest.getBirthDate().toInstant().toEpochMilli()
                        : null);

        return client;
    }
    
}
