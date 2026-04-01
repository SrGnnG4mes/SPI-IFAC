package com.example.demo.controladores;

import com.example.demo.modelos.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;
import com.example.demo.servicos.AlunoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class AlunoControlador {

    @Autowired
    AlunoServico alunoServico;

    @PostMapping("/aluno/salvar")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){

        alunoServico.salvar(aluno);


        //aluno.setId(1L);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

        //return "Oi " + aluno.getNome() + "\n" + aluno.getTelefone() + "\n" + aluno.getIdade();
    }

}
