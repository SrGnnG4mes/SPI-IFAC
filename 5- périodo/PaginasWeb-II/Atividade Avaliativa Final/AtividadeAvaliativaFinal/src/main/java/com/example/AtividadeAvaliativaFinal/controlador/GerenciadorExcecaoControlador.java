package com.example.AtividadeAvaliativaFinal.controlador;

import com.example.AtividadeAvaliativaFinal.excecao.HorarioOcupadoExcecao;
import com.example.AtividadeAvaliativaFinal.excecao.RecursoNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GerenciadorExcecaoControlador {

    @ExceptionHandler(RecursoNaoEncontradoExcecao.class)
    public ResponseEntity<Map<String, Object>> tratarNaoEncontrado(RecursoNaoEncontradoExcecao ex) {
        return criarEstruturaErro(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(HorarioOcupadoExcecao.class)
    public ResponseEntity<Map<String, Object>> tratarConflitoHorario(HorarioOcupadoExcecao ex) {
        return criarEstruturaErro(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacoes(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(campo, mensagem);
        });

        Map<String, Object> corpo = new HashMap<>();
        corpo.put("timestamp", LocalDateTime.now());
        corpo.put("status", HttpStatus.BAD_REQUEST.value());
        corpo.put("erros", erros);

        return ResponseEntity.badRequest().body(corpo);
    }

    private ResponseEntity<Map<String, Object>> criarEstruturaErro(HttpStatus status, String mensagem) {
        Map<String, Object> corpo = new HashMap<>();
        corpo.put("timestamp", LocalDateTime.now());
        corpo.put("status", status.value());
        corpo.put("erros", mensagem);
        return ResponseEntity.status(status).body(corpo);
    }

}
