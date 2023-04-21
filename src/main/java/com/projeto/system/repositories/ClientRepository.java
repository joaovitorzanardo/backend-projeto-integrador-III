package com.projeto.system.repositories;

import com.projeto.system.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByClientId(Long clientId);

}
