package dev.cadastrodecomputador.service;

import dev.cadastrodecomputador.entity.Client;
import dev.cadastrodecomputador.entity.Computer;
import dev.cadastrodecomputador.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {


    private final ComputerRepository repository;
    private final ClientService clientService;

    public ComputerService(ComputerRepository repository, ClientService clientService) {
        this.repository = repository;
        this.clientService = clientService;
    }

    public List<Computer> getAllComputers() {
        return repository.findAll();
    }

    public Computer getComputerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Computer registerComputer(Computer computer) {
        Client clientFound = clientService.getClientById(computer.getClient().getId());
        computer.setClient(clientFound);
        return repository.save(computer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Computer updateComputer(Computer computer) {
        return repository.save(computer);
    }

}
