package com.example.AtividadeAvaliativaFinal.controlador;

import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRespostaDTO;
import com.example.AtividadeAvaliativaFinal.servico.PrestadorServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestadores")
public class PrestadorControlador {

    @Autowired
    private PrestadorServico servico;

    @PostMapping
    public ResponseEntity<PrestadorRespostaDTO> criar(@RequestBody @Valid PrestadorRequisicaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.salvar(dto));
    }
}
