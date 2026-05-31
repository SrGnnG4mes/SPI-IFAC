package com.example.AtividadeAvaliativaFinal.controlador;

import com.example.AtividadeAvaliativaFinal.DTO.ClienteRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.ClienteRespostaDTO;
import com.example.AtividadeAvaliativaFinal.servico.ClienteServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServico servico;

    @PostMapping
    public ResponseEntity<ClienteRespostaDTO> criar(@RequestBody @Valid ClienteRequisicaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.salvar(dto));
    }

}
