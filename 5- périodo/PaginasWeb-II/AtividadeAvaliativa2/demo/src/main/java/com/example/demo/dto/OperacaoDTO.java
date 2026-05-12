package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class OperacaoDTO {

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private Double valor;

    public OperacaoDTO(){}

    public Double getValor(){ return valor;}
    public void setValor(Double valor){ this.valor = valor;}
}
