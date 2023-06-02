package com.projeto.system.services;

import com.projeto.system.dto.ClientDTO;
import com.projeto.system.entities.Address;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.repositories.ClientRepository;
import com.projeto.system.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public void saveClient(ClientDTO clientDTO) {
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
        clientRepository.save(client);
    }

    public void updateClient(ClientDTO clientDTO, Long clientId) {
        Client client = clientRepository.findClientByClientId(clientId);
        client.setCpf(clientDTO.getCpf());
        client.setFirst_name(clientDTO.getFirstName());
        client.setLast_name(clientDTO.getLastName());
        client.setPhone_number(clientDTO.getPhoneNumber());
        Address address = client.getAddress();
        address.setUf(clientDTO.getAddressDTO().getUf());
        address.setCep(clientDTO.getAddressDTO().getCep());
        address.setCity(clientDTO.getAddressDTO().getCity());
        address.setDistrict(clientDTO.getAddressDTO().getDistrict());
        address.setStreet(clientDTO.getAddressDTO().getStreet());
        address.setNumber(clientDTO.getAddressDTO().getNumber());
        address.setReference(clientDTO.getAddressDTO().getReference());
        client.setAddress(address);
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) throws Exception {
        Client client = clientRepository.findClientByClientId(clientId);
        Product product = productRepository.findProductByClient(client);
        if (product != null) {
            throw new Exception("Esse cliente está vinculado a um produto. Não é possível fazer a exclusão!");
        }
        clientRepository.delete(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
