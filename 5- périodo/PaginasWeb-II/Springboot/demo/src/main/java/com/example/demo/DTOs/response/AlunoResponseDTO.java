package com.example.demo.DTOs.response;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String telefone,
        int idade
) {
}
