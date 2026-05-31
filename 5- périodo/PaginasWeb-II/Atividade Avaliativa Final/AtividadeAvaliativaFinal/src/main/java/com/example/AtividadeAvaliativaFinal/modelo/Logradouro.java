package com.example.AtividadeAvaliativaFinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "tb_logradouros")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String rua;

    @NotBlank
    @Column(nullable = false)
    private String numero;

    @NotBlank
    @Column(nullable = false, length = 9)
    private String cep;
}
