package com.example.AtividadeAvaliativaFinal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LogradouroDTO(
        @NotBlank(message = "O nome da rua é obrigatório.")
        String rua,

        @NotBlank(message = "O número é obrigatório.")
        String numero,

        @NotBlank(message = "O CEP é obrigatório.")
        @Pattern(regexp = "\\d{5}-\\d{3}|\\d{8}", message = "Formato de CEP inválido (Ex: 12345-678 ou 12345678)")
        String cep
) {}
