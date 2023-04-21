package com.projeto.system.controllers;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.services.client.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Client> saveClient(@Valid @RequestBody ClientDTO clientDTO) {
        Client newClient = clientService.saveClient(clientDTO);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }


}
