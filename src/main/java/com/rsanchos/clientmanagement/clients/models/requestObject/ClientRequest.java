package com.rsanchos.clientmanagement.clients.models.requestObject;

import java.time.OffsetDateTime;

import javax.validation.constraints.Pattern;

import com.rsanchos.clientmanagement.clients.validators.GreatherThan14;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequest {

    private Integer id;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
    private String email;

    @Pattern(regexp = "[A-Za-z]+")
    private String name;

    @Pattern(regexp = "[A-Za-z]+")
    private String surname;

    @GreatherThan14
    private OffsetDateTime birthDate;
}
