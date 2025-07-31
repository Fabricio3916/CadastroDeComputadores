package dev.cadastrodecomputador.controller;

import dev.cadastrodecomputador.controller.request.ComputerRequest;
import dev.cadastrodecomputador.controller.response.ComputerResponse;
import dev.cadastrodecomputador.entity.Computer;
import dev.cadastrodecomputador.mapper.ComputerMapper;
import dev.cadastrodecomputador.service.ComputerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/computer")
public class ComputerController {


    private final ComputerService service;

    public ComputerController(ComputerService computerService) {
        this.service = computerService;
    }

    @PostMapping
    public ResponseEntity<ComputerResponse> createComputer(@RequestBody ComputerRequest request) {
        Computer savedComputer = service.registerComputer(ComputerMapper.toComputer(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(ComputerMapper.toComputerResponse(savedComputer));
    }

    @GetMapping
    public ResponseEntity<List<ComputerResponse>> getAllComputer(){
        List<ComputerResponse> list = service.getAllComputers().stream()
                .map(ComputerMapper::toComputerResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerResponse> getComputerById(@PathVariable Long id){
        return ResponseEntity.ok(ComputerMapper.toComputerResponse(service.getComputerById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComputerResponse> deleteComputerById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
