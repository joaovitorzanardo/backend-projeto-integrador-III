package com.projeto.system.services.client;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Address;
import com.projeto.system.entities.Client;
import com.projeto.system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client saveClient(ClientDTO clientDTO) {
        Address address = Address.builder()
                .uf(clientDTO.getAddressDTO().getUf())
                .city(clientDTO.getAddressDTO().getCity())
                .cep(clientDTO.getAddressDTO().getCep())
                .street(clientDTO.getAddressDTO().getStreet())
                .district(clientDTO.getAddressDTO().getDistrict())
                .number(clientDTO.getAddressDTO().getNumber())
                .reference(clientDTO.getAddressDTO().getReference()).build();
        Client client = Client.builder()
                .first_name(clientDTO.getFirstName())
                .last_name(clientDTO.getLastName())
                .cpf(clientDTO.getCpf())
                .phone_number(clientDTO.getPhoneNumber())
                .address(address)
                .build();
        return clientRepository.save(client);
    }
    
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
