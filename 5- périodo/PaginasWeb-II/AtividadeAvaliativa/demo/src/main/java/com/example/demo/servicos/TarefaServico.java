package com.example.demo.servicos;

import com.example.demo.modelo.Tarefa;
import com.example.demo.repositorios.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaServico {
    @Autowired
    private TarefaRepositorio tarefaRepositorio;
    LocalDate hoje = LocalDate.now();

    public Tarefa Salvar(Tarefa tarefa) {
        if (tarefa.getDataTarefa().isBefore(hoje)){
            throw new IllegalArgumentException("Data Inválida: A tarefa deve para hoje ou futuro");
        }
        return tarefaRepositorio.save(tarefa);
    }

    public List<Tarefa> listarTodas(){
        return tarefaRepositorio.findAll();
    }

}

