package com.projeto.system.controllers;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.TaskType;
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

    @CrossOrigin
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveClient(@Valid @RequestBody ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
        return "Cliente Cadastrado Com Sucesso!";
    }

    @CrossOrigin
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateClient(@Valid @RequestBody ClientDTO clientDTO, @RequestParam Long clientId){
        clientService.updateClient(clientDTO, clientId);
        return "Cliente Atualizado!";
    }

    @CrossOrigin
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@RequestParam Long clientId) throws Exception {
        clientService.deleteClient(clientId);
        return "Cliente Excluído";
    }

    @CrossOrigin
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @CrossOrigin
    @GetMapping(params = "clientId")
    @ResponseStatus(HttpStatus.OK)
    public Client getTaskTypeById(@RequestParam Long clientId) {
        return clientService.getClientById(clientId);
    }


}
