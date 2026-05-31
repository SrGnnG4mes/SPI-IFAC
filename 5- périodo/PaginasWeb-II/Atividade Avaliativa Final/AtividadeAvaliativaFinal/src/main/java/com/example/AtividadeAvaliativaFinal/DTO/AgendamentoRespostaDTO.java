package com.example.AtividadeAvaliativaFinal.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRespostaDTO(
        UUID id,
        LocalDateTime dataHora,
        String nomePrestador,
        String nomeCliente,
        String telefoneCliente,
        String status
) {
}
