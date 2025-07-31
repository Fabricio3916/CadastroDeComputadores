package dev.cadastrodecomputador.mapper;

import dev.cadastrodecomputador.controller.request.ClientRequest;
import dev.cadastrodecomputador.controller.response.ClientResponse;
import dev.cadastrodecomputador.entity.Client;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientMapper {

    public static Client toClient(ClientRequest request){
        return Client.builder()
                .name(request.name())
                .email(request.email())
                .cellphone(request.cellphone())
                .build();
    }

    public static ClientResponse toClientResponse(Client client){
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .cellphone(client.getCellphone())
                .build();
    }

}
