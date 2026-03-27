package com.example.demo.controladores;

import com.example.demo.modelos.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class AlunoControlador {
    @PostMapping("/aluno/salvar")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){

        aluno.setId(1L);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

        //return "Oi " + aluno.getNome() + "\n" + aluno.getTelefone() + "\n" + aluno.getIdade();
    }

}
