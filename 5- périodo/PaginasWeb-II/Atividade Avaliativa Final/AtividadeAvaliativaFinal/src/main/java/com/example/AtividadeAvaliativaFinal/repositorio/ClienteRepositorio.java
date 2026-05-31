package com.example.AtividadeAvaliativaFinal.repositorio;

import com.example.AtividadeAvaliativaFinal.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {
}
