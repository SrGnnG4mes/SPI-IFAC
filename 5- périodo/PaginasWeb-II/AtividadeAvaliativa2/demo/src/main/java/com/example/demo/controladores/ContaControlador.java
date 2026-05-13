package com.example.demo.controladores;

import com.example.demo.dto.ContaRequestDTO;
import com.example.demo.dto.ContaResponseDTO;
import com.example.demo.dto.OperacaoDTO;
import com.example.demo.dto.TransferenciaDTO;
import com.example.demo.servicos.ContaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServico contaServico;

    // POST /contas
    @PostMapping
    public ResponseEntity<ContaResponseDTO> criarConta(@Valid @RequestBody ContaRequestDTO dto) {
        ContaResponseDTO response = contaServico.criarConta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /contas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ContaResponseDTO> buscarPorId(@PathVariable Long id) {
        ContaResponseDTO response = contaServico.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    // GET /contas/numero/{numeroConta}
    @GetMapping("/numero/{numeroConta}")
    public ResponseEntity<ContaResponseDTO> buscarPorNumero(@PathVariable String numeroConta) {
        ContaResponseDTO response = contaServico.buscarPorNumero(numeroConta);
        return ResponseEntity.ok(response);
    }

    // POST /contas/{numeroConta}/depositar
    @PostMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResponseDTO> depositar(@PathVariable String numeroConta,
                                                      @Valid @RequestBody OperacaoDTO dto) {
        ContaResponseDTO response = contaServico.depositar(numeroConta, dto);
        return ResponseEntity.ok(response);
    }

    // POST /contas/{numeroConta}/sacar
    @PostMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResponseDTO> sacar(@PathVariable String numeroConta,
                                                  @Valid @RequestBody OperacaoDTO dto) {
        ContaResponseDTO response = contaServico.sacar(numeroConta, dto);
        return ResponseEntity.ok(response);
    }

    // POST /contas/transferir
    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(@Valid @RequestBody TransferenciaDTO dto) {
        contaServico.transferir(dto);
        return ResponseEntity.ok("Transferência realizada com sucesso");
    }
}
