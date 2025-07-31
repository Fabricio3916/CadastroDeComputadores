package dev.cadastrodecomputador.controller.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ComputerResponse(Long id,
                               String Brand,
                               ClientResponse client,
                               LocalDate registrationDate) {
}
