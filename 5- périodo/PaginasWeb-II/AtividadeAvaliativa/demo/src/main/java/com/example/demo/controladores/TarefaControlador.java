package com.example.demo.controladores;

import com.example.demo.modelo.Tarefa;
import com.example.demo.servicos.TarefaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaControlador {
    @Autowired
    private TarefaServico tarefaServico;

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa){
        try {
            Tarefa tarefaSalva = tarefaServico.Salvar(tarefa);
            return ResponseEntity.ok(tarefaSalva);
        }catch (Exception erro){
            return ResponseEntity.badRequest().build();
        }
    }
}
