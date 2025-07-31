package dev.cadastrodecomputador.service;

import dev.cadastrodecomputador.entity.Client;
import dev.cadastrodecomputador.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    private final ClientRepository repository;

    public ClientService(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    public List<Client> getAllClients(){
        return repository.findAll();
    }

    public Client getClientById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Client register(Client client){
        return repository.save(client);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Client update(Client client){
        return repository.save(client);
    }

}
