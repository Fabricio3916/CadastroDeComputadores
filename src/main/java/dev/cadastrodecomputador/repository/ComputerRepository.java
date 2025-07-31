package dev.cadastrodecomputador.repository;

import dev.cadastrodecomputador.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
