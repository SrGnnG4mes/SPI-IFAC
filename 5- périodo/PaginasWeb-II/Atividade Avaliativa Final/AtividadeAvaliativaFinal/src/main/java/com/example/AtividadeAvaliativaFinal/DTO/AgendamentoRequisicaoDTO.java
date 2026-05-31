package com.example.AtividadeAvaliativaFinal.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequisicaoDTO(

        @NotNull(message = "A data e hora são obrigatórias.")
        @Future(message = "O agendamento precisa ser em uma data futura.")
        LocalDateTime dataHora,

        @NotNull(message = "O ID do prestador é obrigatório.")
        UUID prestadorId,

        @NotNull(message = "O ID do cliente é obrigatório.")
        UUID clienteId
) {
}
