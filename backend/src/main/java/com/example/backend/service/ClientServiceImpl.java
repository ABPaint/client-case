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
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return  null; //clientRepository.findById(id).orElseThrow(() ->
                //new ResourceNotFoundException("Client", "Id", id));

    }

    @Override
    public Client updateClient(Client Client, long id) {
        //Client existingClient = clientRepository.findById(id).orElseThrow(
        //        () -> new ResourceNotFoundException("Client", "Id", id));
        //existingClient.setName(Client.getName());
        //existingClient.setProjects(Client.getProjects());
        //existingClient.setAgreements(Client.getAgreements());
        //clientRepository.save(existingClient);
        return null;//existingClient;
    }

    @Override
    public void deleteClient(long id) {
        //clientRepository.findById(id).orElseThrow(() ->
        //        new ResourceNotFoundException("Client", "Id", id));
        //clientRepository.deleteById(id);
    }
}
