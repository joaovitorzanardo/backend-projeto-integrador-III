package com.projeto.system.services.client;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Client;

import java.util.List;

public interface ClientService {

    public Client saveClient(ClientDTO clientDTO);

    public List<Client> getAllClients();

}
