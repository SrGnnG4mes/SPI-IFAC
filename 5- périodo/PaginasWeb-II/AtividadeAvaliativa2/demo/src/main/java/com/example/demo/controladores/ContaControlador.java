package com.example.demo.controladores;

import com.example.demo.modelos.Conta;
import com.example.demo.servicos.ContaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaControlador {

    @Autowired
    private ContaServico contaServico;

    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
        Conta nova = contaServico.criarConta(conta);
        return ResponseEntity.ok(conta);
    }
}
