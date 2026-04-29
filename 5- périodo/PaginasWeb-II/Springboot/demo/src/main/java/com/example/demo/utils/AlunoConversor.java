package com.example.demo.utils;

import com.example.demo.DTOs.request.AlunoRequestDTO;
import com.example.demo.DTOs.response.AlunoResponseDTO;
import com.example.demo.modelos.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoConversor {

    public AlunoResponseDTO converterAluno(Aluno aluno){
        AlunoResponseDTO alunoResponseDTOS = new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getTelefone(),
                aluno.getIdade()
        );
        return alunoResponseDTOS;
    }

    public Aluno converterDTO(AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = new Aluno();
        aluno.setId(alunoRequestDTO.id());
        aluno.setNome(alunoRequestDTO.nome());
        aluno.setTelefone(alunoRequestDTO.telefone());
        aluno.setIdade(alunoRequestDTO.idade());
        return aluno;
    }

}
