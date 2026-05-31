package com.example.AtividadeAvaliativaFinal.DTO;

import jakarta.validation.constraints.NotBlank;

public record PrestadorRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A especialidade é obrigatória")
        String especialidade
) {
}
