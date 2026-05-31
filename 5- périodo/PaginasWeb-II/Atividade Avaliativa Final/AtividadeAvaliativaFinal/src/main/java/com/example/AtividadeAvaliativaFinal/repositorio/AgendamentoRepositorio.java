package com.example.AtividadeAvaliativaFinal.repositorio;

import com.example.AtividadeAvaliativaFinal.modelo.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AgendamentoRepositorio extends JpaRepository<Agendamento, UUID> {

    @Query("SELECT COUNT(a) > 0 FROM Agendamento a WHERE a.prestador.id = :prestadorId AND a.dataHora = :dataHora AND a.status = 'AGENDADO'")
    boolean existeHorarioConflitante(@Param("prestadorId") UUID prestadorId, @Param("dataHora") LocalDateTime dataHora);

}
