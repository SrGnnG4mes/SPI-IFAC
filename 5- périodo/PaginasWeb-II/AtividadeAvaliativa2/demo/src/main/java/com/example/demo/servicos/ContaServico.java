package com.example.demo.servicos;

import com.example.demo.dto.ContaRequestDTO;
import com.example.demo.dto.ContaResponseDTO;
import com.example.demo.dto.OperacaoDTO;
import com.example.demo.dto.TransferenciaDTO;
import com.example.demo.exception.ContaJaExisteException;
import com.example.demo.exception.ContaNaoEncontradaException;
import com.example.demo.exception.SaldoInsuficienteException;
import com.example.demo.modelos.Conta;
import com.example.demo.repositorios.ContaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ContaServico {

    @Autowired
    private ContaRepositorio contaRepositorio;

    // ----------------------------------------
    // CRIAR CONTA
    // ----------------------------------------

    public ContaResponseDTO criarConta(ContaRequestDTO dto) {
        if (contaRepositorio.existsByNumeroConta(dto.getNumeroConta())) {
            throw new ContaJaExisteException("Já existe uma conta com o número: " + dto.getNumeroConta());
        }

        Conta conta = new Conta(dto.getNomeTitular(), dto.getNumeroConta(), dto.getSaldoInicial());
        contaRepositorio.save(conta);

        return new ContaResponseDTO(conta);
    }

    // ----------------------------------------
    // BUSCAR POR ID
    // ----------------------------------------

    public ContaResponseDTO buscarPorId(Long id) {
        Optional<Conta> conta = contaRepositorio.findById(id);

        if (conta.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta não encontrada com id: " + id);
        }

        return new ContaResponseDTO(conta.get());
    }

    // ----------------------------------------
    // BUSCAR POR NÚMERO DA CONTA
    // ----------------------------------------

    public ContaResponseDTO buscarPorNumero(String numeroConta) {
        Optional<Conta> conta = contaRepositorio.findByNumeroConta(numeroConta);

        if (conta.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta não encontrada: " + numeroConta);
        }

        return new ContaResponseDTO(conta.get());
    }

    // ----------------------------------------
    // DEPÓSITO
    // ----------------------------------------

    public ContaResponseDTO depositar(String numeroConta, OperacaoDTO dto) {
        Optional<Conta> optional = contaRepositorio.findByNumeroConta(numeroConta);

        if (optional.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta não encontrada: " + numeroConta);
        }

        Conta conta = optional.get();
        conta.setSaldo(conta.getSaldo() + dto.getValor());
        contaRepositorio.save(conta);

        return new ContaResponseDTO(conta);
    }

    // ----------------------------------------
    // SAQUE
    // ----------------------------------------

    public ContaResponseDTO sacar(String numeroConta, OperacaoDTO dto) {
        Optional<Conta> optional = contaRepositorio.findByNumeroConta(numeroConta);

        if (optional.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta não encontrada: " + numeroConta);
        }

        Conta conta = optional.get();

        if (conta.getSaldo() < dto.getValor()) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + conta.getSaldo());
        }

        conta.setSaldo(conta.getSaldo() - dto.getValor());
        contaRepositorio.save(conta);

        return new ContaResponseDTO(conta);
    }

    // ----------------------------------------
    // TRANSFERÊNCIA (atômica com @Transactional)
    // ----------------------------------------

    @Transactional
    public void transferir(TransferenciaDTO dto) {
        if (dto.getNumeroContaOrigem().equals(dto.getNumeroContaDestino())) {
            throw new IllegalArgumentException("Conta de origem e destino não podem ser iguais");
        }

        Optional<Conta> optOrigem = contaRepositorio.findByNumeroConta(dto.getNumeroContaOrigem());
        if (optOrigem.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta de origem não encontrada: " + dto.getNumeroContaOrigem());
        }

        Optional<Conta> optDestino = contaRepositorio.findByNumeroConta(dto.getNumeroContaDestino());
        if (optDestino.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta de destino não encontrada: " + dto.getNumeroContaDestino());
        }

        Conta origem  = optOrigem.get();
        Conta destino = optDestino.get();

        if (origem.getSaldo() < dto.getValor()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência. Saldo atual: " + origem.getSaldo());
        }

        // Débito na origem
        origem.setSaldo(origem.getSaldo() - dto.getValor());

        // Crédito no destino
        // O @Transactional garante que se qualquer erro ocorrer aqui,
        // o débito acima também será desfeito (rollback automático)
        destino.setSaldo(destino.getSaldo() + dto.getValor());

        contaRepositorio.save(origem);
        contaRepositorio.save(destino);
    }
}

