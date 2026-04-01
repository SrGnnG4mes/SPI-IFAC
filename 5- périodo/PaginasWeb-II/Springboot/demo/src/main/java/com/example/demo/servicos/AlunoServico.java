package com.example.demo.servicos;

import com.example.demo.modelos.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServico {

    @Autowired
    AlunoRepositorio alunoRepositorio;

    public void salvar(Aluno aluno){
        alunoRepositorio.save(aluno);
    }
}
