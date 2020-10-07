package com.rsanchos.clientmanagement.clients.controllers.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.rsanchos.clientmanagement.clients.controllers.ClientController;
import com.rsanchos.clientmanagement.clients.mappers.ClientMapper;
import com.rsanchos.clientmanagement.clients.models.entities.Client;
import com.rsanchos.clientmanagement.clients.models.requestObject.ClientRequest;
import com.rsanchos.clientmanagement.clients.models.responseObject.ClientResponse;
import com.rsanchos.clientmanagement.clients.servicies.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientControllerImpl implements ClientController{
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClientResponse>> getAllClient() {
        try {
            return ResponseEntity.ok().body(clientService.findAll().stream()
                    .map(client -> clientMapper.from(client)).collect(Collectors.toList()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Client> createClient(@RequestBody @Valid ClientRequest clientRequest) {

        try {

            Client client = clientService.save(clientMapper.from(clientRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(client);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> removeClient(@RequestBody ClientRequest clientRequest) {

        try {

            clientService.remove(clientMapper.from(clientRequest));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Override
    @GetMapping("/email/{email}")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResponse> getClientsByEmail(@PathVariable String email) {

        try {
            return ResponseEntity.ok().body(clientMapper.from(clientService.findByEmail(email)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Override
    @GetMapping("/birthDate")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClientResponse>> getClientsByBirthDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime firstDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate) {
    
        try {
            return ResponseEntity.ok().body(clientService.findByClientBetweenBirthDates(firstDate, finalDate).stream()
                    .map(client -> clientMapper.from(client)).collect(Collectors.toList()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
