package com.azship.gerenciadordefrete.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cubagem;

    private Double peso;

    @Column(nullable = false)
    private Double distancia;

    @Column(nullable = false)
    private Long tempo;

}
