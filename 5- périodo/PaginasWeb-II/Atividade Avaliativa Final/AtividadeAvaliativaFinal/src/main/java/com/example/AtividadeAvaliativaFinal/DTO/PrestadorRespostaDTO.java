package com.example.AtividadeAvaliativaFinal.DTO;

import java.util.UUID;

public record PrestadorRespostaDTO(
        UUID id,
        String nome,
        String especialidade
) {
}
