package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransferenciaDTO {

    @NotBlank(message = "O número da conta de origem é obrigatório")
    private String numeroContaOrigem;

    @NotBlank(message = "O número da conta de destino é obrigatório")
    private String numeroContaDestino;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor dever ser maior que zero")
    private Double valor;

    public TransferenciaDTO (){}

    public String getNumeroContaOrigem() { return numeroContaOrigem; }
    public void setNumeroContaOrigem(String numeroContaOrigem) { this.numeroContaOrigem = numeroContaOrigem; }

    public String getNumeroContaDestino() { return numeroContaDestino; }
    public void setNumeroContaDestino(String numeroContaDestino) { this.numeroContaDestino = numeroContaDestino; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

}
