package com.example.demo.repositorios;

import com.example.demo.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa,Long> {

}
