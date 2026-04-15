package com.example.demo.repositorios;

import com.example.demo.modelos.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

    public Optional<Aluno> findByTelefone(String telefone);
}
