package com.example.demo.servicos;

import com.example.demo.modelos.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;
import org.hibernate.boot.models.annotations.spi.AttributeMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServico {

    @Autowired
    AlunoRepositorio alunoRepositorio;

    public void salvar(Aluno aluno){
        alunoRepositorio.save(aluno);
    }
    public List<Aluno> buscarTodos(){
        return alunoRepositorio.findAll();
    }

    public Aluno buscarPeloId(@PathVariable Long id){

        Optional<Aluno> optionalAluno = alunoRepositorio.findById(id);

        if (optionalAluno.isEmpty()){
            throw new IllegalArgumentException("Aluno não foi encontrado");
        }else {
            return optionalAluno.get();
        }

    }

    public void excluir(Long id){

        Optional<Aluno> optionalAluno = alunoRepositorio.findById(id);

        if (optionalAluno.isEmpty()){
            throw new IllegalArgumentException("Aluno não foi encontrado");
        }else {
            alunoRepositorio.deleteById(id);
        }
    }

    public void editar(Aluno aluno){
        alunoRepositorio.save(aluno);
    }

    public Aluno buscarTelefone(String telefone){

        Optional<Aluno> optional = alunoRepositorio.findByTelefone(telefone);

        if (optional.isEmpty()){
            throw new IllegalArgumentException("Aluno não foi encontrado");
        }else {
            return optional.get();
        }

    }
}
