package dev.cadastrodecomputador.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tb_computer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @CreationTimestamp
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}
