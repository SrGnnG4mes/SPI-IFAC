package com.example.demo.servicos;

import com.example.demo.DTOs.request.AlunoRequestDTO;
import com.example.demo.DTOs.response.AlunoResponseDTO;
import com.example.demo.modelos.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;
import com.example.demo.utils.AlunoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServico {

    @Autowired
    AlunoRepositorio alunoRepositorio;
    @Autowired
    AlunoConversor alunoConversor;

    public AlunoResponseDTO salvar(AlunoRequestDTO alunoDTO) throws DataIntegrityViolationException {
        Aluno aluno = alunoConversor.converterDTO(alunoDTO);
        alunoRepositorio.save(aluno);
        return alunoConversor.converterAluno(aluno);
    }

    public List<AlunoResponseDTO> buscarTodos(){
        List<Aluno> alunos = alunoRepositorio.findAll();
        List<AlunoResponseDTO> alunoResponseDTOS = new ArrayList<>();
        for (Aluno aluno : alunos) {
            AlunoResponseDTO alunoResponseDTO =
                    alunoConversor.converterAluno(aluno);
            alunoResponseDTOS.add(alunoResponseDTO);
        }

        return alunoResponseDTOS;
    }

    public AlunoResponseDTO buscarPeloId(Long id){

        Optional<Aluno> optionalAluno = alunoRepositorio.findById(id);
        if(optionalAluno.isEmpty()){
            throw new IllegalArgumentException("O aluno não foi encontrado");
        }
        Aluno aluno = optionalAluno.get();
        AlunoResponseDTO alunoResponseDTO =
                alunoConversor.converterAluno(aluno);
        return alunoResponseDTO;
    }

    public AlunoResponseDTO buscarPeloTelefone(String telefone){
        Optional<Aluno> optional = alunoRepositorio.findByTelefone(telefone);
        if(optional.isEmpty()){
            throw new IllegalArgumentException("O aluno não foi encontrado");
        }
        AlunoResponseDTO alunoResponseDTO =
                alunoConversor.converterAluno(optional.get());
        return alunoResponseDTO;
    }

    public void excluir(Long id){

        Optional<Aluno> optionalAluno =
                alunoRepositorio.findById(id);

        if(optionalAluno.isEmpty()){
            throw new IllegalArgumentException("O aluno não foi encontrado");
        }else{
            alunoRepositorio.deleteById(id);
        }
    }

    public AlunoResponseDTO editar(AlunoRequestDTO alunoDTO){
        Aluno aluno = alunoConversor.converterDTO(alunoDTO);
        alunoRepositorio.save(aluno);
        return alunoConversor.converterAluno(aluno);
    }


}
