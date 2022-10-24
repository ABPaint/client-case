package com.example.backend.controller;


import com.example.backend.model.Client;
import com.example.backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Client> getAllClients(){
        return ClientService.getAllClients();
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long ClientId){
        return new ResponseEntity<Client>(ClientService.getClientById(ClientId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id
            ,@RequestBody Client Client){
        return new ResponseEntity<Client>(ClientService.updateClient(Client, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") long id){
        ClientService.deleteClient(id);
        return new ResponseEntity<String>("Client deleted successfully!.", HttpStatus.OK);
    }

}

