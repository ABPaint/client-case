package com.example.backend.service;

import com.example.backend.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getAllClients();
    Client getClientById(long id);
    Client updateClient(Client Client, long id);
    void deleteClient(long id);
}
