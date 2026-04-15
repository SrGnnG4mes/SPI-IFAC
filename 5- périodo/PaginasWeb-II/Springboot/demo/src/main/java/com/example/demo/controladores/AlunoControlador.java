package com.example.demo.controladores;

import com.example.demo.modelos.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;
import com.example.demo.servicos.AlunoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoControlador {

    @Autowired
    AlunoServico alunoServico;

    @PostMapping("/salvar")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){

        alunoServico.salvar(aluno);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

        //aluno.setId(1L);
        //return "Oi " + aluno.getNome() + "\n" + aluno.getTelefone() + "\n" + aluno.getIdade();
    }

    @GetMapping("")
    public ResponseEntity<List<Aluno>> buscar(){
        List<Aluno> alunos = alunoServico.buscarTodos();
        return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPeloId(@PathVariable Long id){

        try {
            Aluno aluno = alunoServico.buscarPeloId(id);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<String>(erro.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> excluir(@PathVariable Long id){
        try {
            alunoServico.excluir(id);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Aluno>(HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Aluno> editar(@RequestBody Aluno aluno){
        alunoServico.editar(aluno);
        return new ResponseEntity<Aluno>(HttpStatus.OK);
    }

    @GetMapping("/telefone/{telefone}")
    public ResponseEntity buscarTelefone(@PathVariable String telefone){

        try {
            Aluno aluno = alunoServico.buscarTelefone(telefone);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<String>(erro.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
