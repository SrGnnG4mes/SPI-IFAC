package com.example.demo.repositorios;

import com.example.demo.modelos.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepositorio extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumeroConta(String numeroConta);

    boolean existsByNumeroConta(String numeroConta);
}
