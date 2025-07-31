package dev.cadastrodecomputador.mapper;

import dev.cadastrodecomputador.controller.request.ComputerRequest;
import dev.cadastrodecomputador.controller.response.ClientResponse;
import dev.cadastrodecomputador.controller.response.ComputerResponse;
import dev.cadastrodecomputador.entity.Client;
import dev.cadastrodecomputador.entity.Computer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComputerMapper {

    public static Computer toComputer(ComputerRequest request) {

        Client client = Client.builder()
                .id(request.client())
                .build();

        return Computer.builder()
                .brand(request.brand())
                .client(client)
                .build();
    }

    public static ComputerResponse toComputerResponse(Computer computer) {

        ClientResponse client = ClientMapper.toClientResponse(computer.getClient());

        return ComputerResponse.builder()
                .id(computer.getId())
                .Brand(computer.getBrand())
                .client(client)
                .registrationDate(computer.getRegistrationDate())
                .build();
    }

}
