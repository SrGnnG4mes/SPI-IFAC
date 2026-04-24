package com.example.demo.repositorios;

import com.example.demo.modelos.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumeroConta(String numeroConta);

    boolean existsByNumeroConta(String numeroConta);

}
