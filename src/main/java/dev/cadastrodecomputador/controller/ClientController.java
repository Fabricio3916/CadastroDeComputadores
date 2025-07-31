package dev.cadastrodecomputador.controller;

import dev.cadastrodecomputador.controller.request.ClientRequest;
import dev.cadastrodecomputador.controller.response.ClientResponse;
import dev.cadastrodecomputador.entity.Client;
import dev.cadastrodecomputador.mapper.ClientMapper;
import dev.cadastrodecomputador.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientService service;

    public ClientController(ClientService clientService) {
        this.service = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients(){
        List<ClientResponse> clients = service.getAllClients().stream().map(ClientMapper::toClientResponse).toList();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id){
        ClientResponse client = ClientMapper.toClientResponse(service.getClientById(id));
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest){
        Client newClient = service.register(ClientMapper.toClient(clientRequest));
        ClientResponse clientResponse = ClientMapper.toClientResponse(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClientById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
