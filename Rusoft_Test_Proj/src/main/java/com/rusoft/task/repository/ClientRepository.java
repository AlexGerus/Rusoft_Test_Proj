package com.rusoft.task.repository;

import com.rusoft.task.module.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT client FROM Client client WHERE client.clientName = :clientName ")
    Client getClientByClientName(@Param("clientName") String clientName);
}