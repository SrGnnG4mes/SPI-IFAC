package com.example.AtividadeAvaliativaFinal.DTO;

import java.util.UUID;

public record ClienteRespostaDTO(
        UUID id,
        String nome,
        String email
) {
}
