package com.example.AtividadeAvaliativaFinal.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClienteRequisicaoDTO(
        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        LogradouroDTO logradouro
) {}
