package com.example.demo.dto;

import com.example.demo.modelos.Conta;

public class ContaResponseDTO {

    private Long id;
    private String nomeTitular;
    private String numeroConta;
    private double saldo;

    public ContaResponseDTO() {}

    public ContaResponseDTO(Conta conta) {
        this.id = conta.getId();
        this.nomeTitular = conta.getNomeTitular();
        this.numeroConta = conta.getNumeroConta();
        this.saldo = conta.getSaldo();
    }

    public Long getId() { return id; }

    public String getNomeTitular() { return nomeTitular; }

    public String getNumeroConta() { return numeroConta; }

    public double getSaldo() { return saldo; }
}
