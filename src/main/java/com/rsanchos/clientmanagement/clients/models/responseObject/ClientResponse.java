package com.rsanchos.clientmanagement.clients.models.responseObject;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponse {

    private Integer id;

    private String email;

    private String name;

    private String surname;

    private OffsetDateTime birthDate;

    
}
