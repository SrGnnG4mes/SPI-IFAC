package com.example.demo.DTOs.request;

import com.example.demo.modelos.Aluno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestDTO(
        Long id,
        @NotNull(message = "O nome não pode ser vazio")
        @NotNull(message = "")
        String nome,
        @Max(13)
        String telefone,
        int idade){

}


