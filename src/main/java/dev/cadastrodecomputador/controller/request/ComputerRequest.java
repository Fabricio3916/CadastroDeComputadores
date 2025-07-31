package dev.cadastrodecomputador.controller.request;

import dev.cadastrodecomputador.entity.Client;

public record ComputerRequest(String brand,
                              Long client) {
}
