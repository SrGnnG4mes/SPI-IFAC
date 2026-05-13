package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContaRequestDTO {

    @NotBlank(message = "O nome do titular é obrigatório")
    private String nomeTitular;

    @NotBlank(message = "O número da conta é obrigatório")
    private String numeroConta;

    @NotNull(message = "O saldo inicial é obrigatório")
    @Min(value = 0, message = "O saldo inicial não pode ser negativo")
    private Double saldoInicial;

    public ContaRequestDTO() {}

    public String getNomeTitular() { return nomeTitular; }
    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }

    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public Double getSaldoInicial() { return saldoInicial; }
    public void setSaldoInicial(Double saldoInicial) { this.saldoInicial = saldoInicial; }
}