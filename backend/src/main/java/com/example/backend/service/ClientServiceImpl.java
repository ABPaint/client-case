package com.example.backend.service;

import com.example.backend.model.Client;
import com.example.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public List<Client> getAllClients() {
        return ClientRepository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return ClientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Client", "Id", id));

    }

    @Override
    public Client updateClient(Client Client, long id) {

        // we need to check whether Client with given id is exist in DB or not
        Client existingClient = ClientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Client", "Id", id));

        existingClient.setName(Client.getName());
        existingClient.setProjects(Client.getProjects());
        existingClient.setAgreements(Client.getAgreements());
        // save existing Client to DB
        ClientRepository.save(existingClient);
        return existingClient;
    }

    @Override
    public void deleteClient(long id) {

        // check whether a Client exist in a DB or not
        ClientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Client", "Id", id));
        ClientRepository.deleteById(id);
    }
}