package com.example.demo.servicos;

import com.example.demo.modelos.Conta;
import com.example.demo.repositorios.ContaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class ContaServico {

    @Autowired
    private ContaRepositorio contaRepositorio;

    public Conta criarConta(Conta conta){
        if (conta.getNomeTitular() == null || conta.getNomeTitular().isEmpty()) {
            throw new RuntimeException("O nome do titular é obrigatório");
        }

        if (contaRepositorio.existsByNumeroConta(conta.getNumeroConta())) {
            throw new RuntimeException("Já existe uma conta com esse número");
        }
        if (conta.getSaldo() < 0) {
            throw new RuntimeException("O saldo inicial não pode ser negativo");
        }
        return contaRepositorio.save(conta);
    }

    public Conta buscarPorId(Long id){
        Optional<Conta> conta = contaRepositorio.findById(id);

        if (conta.isEmpty()){
            throw new RuntimeException("Conta não encontrada" + id);
        }

        return conta.get();
    }

    public Conta buscarPorNumero(String numeroConta) {
        Optional<Conta> conta = contaRepositorio.findByNumeroConta(numeroConta);

        if (conta.isEmpty()) {
            throw new RuntimeException("Conta não encontrada: " + numeroConta);
        }

        return conta.get();
    }

    public Conta depositar(String numeroConta, double valor){
        if (valor <= 0) {
            throw new RuntimeException("O valor do déposito deve ser maior que zero");
        }

        Conta conta = buscarPorNumero(numeroConta);
        conta.setSaldo(conta.getSaldo() + valor);

        return contaRepositorio.save(conta);
    }

    public Conta sacar(String numeroConta, double valor){
        if (valor <= 0){
            throw new RuntimeException("O valor do saque deve ser maior que 0");
        }

        Conta conta = buscarPorNumero(numeroConta);

        if (conta.getSaldo() < valor){
            throw new RuntimeException("Saldo Insulficiente");
        }

        conta.setSaldo(conta.getSaldo() - valor);

        return contaRepositorio.save(conta);
    }
}
