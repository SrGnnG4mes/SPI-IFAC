package com.example.demo.controladores;

import com.example.demo.DTOs.request.AlunoRequestDTO;
import com.example.demo.DTOs.response.AlunoResponseDTO;
import com.example.demo.modelos.Aluno;
import com.example.demo.servicos.AlunoServico;
import com.example.demo.utils.AlunoConversor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoControlador {

    @Autowired
    AlunoServico alunoServico;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@Valid  @RequestBody AlunoRequestDTO alunoDTO){
        //uma linha e o aluno será salvo
        try {
            AlunoResponseDTO alunoResponseDTO =  alunoServico.salvar(alunoDTO);
            return new ResponseEntity<AlunoResponseDTO>(alunoResponseDTO, HttpStatus.CREATED);
        }catch(DataIntegrityViolationException erro){
            return new ResponseEntity<String>("Telefone já cadastrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<AlunoResponseDTO>> buscar(){
        List<AlunoResponseDTO> alunos = alunoServico.buscarTodos();
        return new ResponseEntity<List<AlunoResponseDTO>>(alunos,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity buscarPeloId(@PathVariable Long id){
        try {
            AlunoResponseDTO aluno = alunoServico.buscarPeloId(id);
            return new ResponseEntity<AlunoResponseDTO>(aluno,HttpStatus.OK);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<String>(erro.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/telefone/{telefone}")
    public ResponseEntity buscarPeloTelefone(@PathVariable String telefone){
        try{
            AlunoResponseDTO aluno = alunoServico.buscarPeloTelefone(telefone);
            return new ResponseEntity<AlunoResponseDTO>(aluno,HttpStatus.OK);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<String>(erro.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        try{
            alunoServico.excluir(id);
        }catch (IllegalArgumentException erro){
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("")
    public ResponseEntity<AlunoResponseDTO> editar(@RequestBody AlunoRequestDTO alunoDTO){
        AlunoResponseDTO alunoResponseDTO = alunoServico.editar(alunoDTO);
        return new ResponseEntity<AlunoResponseDTO>(alunoResponseDTO,HttpStatus.OK);
    }




}

