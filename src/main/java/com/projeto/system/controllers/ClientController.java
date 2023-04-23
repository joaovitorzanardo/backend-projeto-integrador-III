package com.projeto.system.controllers;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveClient(@Valid @RequestBody ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
        return "Cliente Cadastrado Com Sucesso!";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateClient(@Valid @RequestBody ClientDTO clientDTO, @RequestParam Long clientId){
        clientService.updateClient(clientDTO, clientId);
        return "Cliente Atualizado!";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@RequestParam Long clientId) throws Exception {
        clientService.deleteClient(clientId);
        return "Cliente Excluído";
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }


}
