package com.rsanchos.clientmanagement.clients.controllers;

import java.time.LocalDateTime;
import java.util.List;

import com.rsanchos.clientmanagement.clients.models.entities.Client;
import com.rsanchos.clientmanagement.clients.models.requestObject.ClientRequest;
import com.rsanchos.clientmanagement.clients.models.responseObject.ClientResponse;

import org.springframework.http.ResponseEntity;

public interface ClientController {
    
    public ResponseEntity<List<ClientResponse>> getAllClient();

    public ResponseEntity<Client> createClient(ClientRequest clientResponse);
    
    public ResponseEntity<?> removeClient(ClientRequest clientResponse);

    public ResponseEntity<ClientResponse> getClientsByEmail(String Email);

    public ResponseEntity<List<ClientResponse>> getClientsByBirthDate(LocalDateTime firstDate, LocalDateTime finalDate);
}
