package com.example.AtividadeAvaliativaFinal.controlador;

import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRespostaDTO;
import com.example.AtividadeAvaliativaFinal.servico.AgendamentoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoControlador {

    @Autowired
    private AgendamentoServico servico;

    @PostMapping
    public ResponseEntity<AgendamentoRespostaDTO> criarAgendamento(@RequestBody @Valid AgendamentoRequisicaoDTO dto){
        AgendamentoRespostaDTO resposta = servico.agendar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
