package com.rsanchos.clientmanagement.clients.mappers;

import com.rsanchos.clientmanagement.clients.models.entities.Client;
import com.rsanchos.clientmanagement.clients.models.requestObject.ClientRequest;
import com.rsanchos.clientmanagement.clients.models.responseObject.ClientResponse;

public interface ClientMapper {
    
    public ClientResponse from(Client client);
    public Client from(ClientResponse clientResponse);
    public Client from(ClientRequest clientRequest);

}
