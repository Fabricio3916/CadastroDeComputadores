package dev.cadastrodecomputador.controller.response;

import lombok.Builder;

@Builder
public record ClientResponse(Long id,
                             String name,
                             String email,
                             String cellphone) {
}
