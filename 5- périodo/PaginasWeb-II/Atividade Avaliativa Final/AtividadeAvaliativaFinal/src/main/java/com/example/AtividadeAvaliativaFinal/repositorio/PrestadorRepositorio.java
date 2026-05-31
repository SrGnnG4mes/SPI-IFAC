package com.example.AtividadeAvaliativaFinal.repositorio;

import com.example.AtividadeAvaliativaFinal.modelo.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrestadorRepositorio extends JpaRepository<Prestador, UUID> {
}
