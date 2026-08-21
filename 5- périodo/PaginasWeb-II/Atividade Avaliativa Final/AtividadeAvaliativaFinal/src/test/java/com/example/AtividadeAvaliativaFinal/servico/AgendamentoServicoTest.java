package com.example.AtividadeAvaliativaFinal.servico;

import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRespostaDTO;
import com.example.AtividadeAvaliativaFinal.excecao.HorarioOcupadoExcecao;
import com.example.AtividadeAvaliativaFinal.excecao.RecursoNaoEncontradoExcecao;
import com.example.AtividadeAvaliativaFinal.mapeador.AgendamentoMapeador;
import com.example.AtividadeAvaliativaFinal.modelo.Agendamento;
import com.example.AtividadeAvaliativaFinal.modelo.Cliente;
import com.example.AtividadeAvaliativaFinal.modelo.Prestador;
import com.example.AtividadeAvaliativaFinal.repositorio.AgendamentoRepositorio;
import com.example.AtividadeAvaliativaFinal.repositorio.ClienteRepositorio;
import com.example.AtividadeAvaliativaFinal.repositorio.PrestadorRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServicoTest {

    @Mock
    private AgendamentoRepositorio agendamentoRepositorio;

    @Mock
    private PrestadorRepositorio prestadorRepositorio;

    @Mock
    private ClienteRepositorio clienteRepositorio;

    @Mock
    private AgendamentoMapeador mapeador;

    @InjectMocks
    private AgendamentoServico agendamentoServico;

    @Test
    @DisplayName("Teste 1: Deve criar agendamento com sucesso usando Mocks")
    void deveAgendarComSucesso() {
        // Arrange (Preparação dos dados e dos Mocks)
        UUID prestadorId = UUID.randomUUID();
        UUID clienteId = UUID.randomUUID();
        LocalDateTime dataHora = LocalDateTime.now().plusDays(1);

        AgendamentoRequisicaoDTO requisicao = new AgendamentoRequisicaoDTO(dataHora, prestadorId, clienteId);

        Prestador prestador = new Prestador();
        prestador.setId(prestadorId);

        Cliente cliente = new Cliente();
        cliente.setId(clienteId);

        Agendamento agendamentoEntidade = new Agendamento();
        AgendamentoRespostaDTO respostaEsperada = new AgendamentoRespostaDTO(UUID.randomUUID(), dataHora, "Dr. Marcos", "João Silva", "999999999", "AGENDADO");

        // Configurando os Mocks: Quando o serviço pedir algo, o Mock devolve isso:
        when(prestadorRepositorio.findById(prestadorId)).thenReturn(Optional.of(prestador));
        when(clienteRepositorio.findById(clienteId)).thenReturn(Optional.of(cliente));
        when(agendamentoRepositorio.existeHorarioConflitante(prestadorId, dataHora)).thenReturn(false);
        when(mapeador.paraEntidade(requisicao)).thenReturn(agendamentoEntidade);
        when(agendamentoRepositorio.save(any(Agendamento.class))).thenReturn(agendamentoEntidade);
        when(mapeador.paraDto(agendamentoEntidade)).thenReturn(respostaEsperada);

        // Act (Ação: Executar o método de serviço)
        AgendamentoRespostaDTO resultado = agendamentoServico.agendar(requisicao);

        // Assert (Verificação)
        assertNotNull(resultado);
        assertEquals("Dr. Marcos", resultado.nomePrestador());
        // Garante que o Mock do repositório foi chamado exatamente 1 vez para salvar
        verify(agendamentoRepositorio, times(1)).save(any(Agendamento.class));
    }

    @Test
    @DisplayName("Teste 2: Deve lançar erro quando horário do prestador já estiver ocupado")
    void deveLancarExcecaoQuandoHorarioConflitante() {
        // Arrange
        UUID prestadorId = UUID.randomUUID();
        UUID clienteId = UUID.randomUUID();
        LocalDateTime dataHora = LocalDateTime.now().plusDays(1);

        AgendamentoRequisicaoDTO requisicao = new AgendamentoRequisicaoDTO(dataHora, prestadorId, clienteId);

        // Configurando Mocks: Prestador e Cliente existem, mas o HORÁRIO DÁ CONFLITO (Mock retorna true)
        when(prestadorRepositorio.findById(prestadorId)).thenReturn(Optional.of(new Prestador()));
        when(clienteRepositorio.findById(clienteId)).thenReturn(Optional.of(new Cliente()));
        when(agendamentoRepositorio.existeHorarioConflitante(prestadorId, dataHora)).thenReturn(true);

        // Act & Assert
        // Verifica se a exceção HorarioOcupadoExcecao é lançada
        assertThrows(HorarioOcupadoExcecao.class, () -> {
            agendamentoServico.agendar(requisicao);
        });

        // Garante que o Mock do save NUNCA foi chamado, pois deu erro antes
        verify(agendamentoRepositorio, never()).save(any(Agendamento.class));
    }

    @Test
    @DisplayName("Teste 3: Deve lançar erro quando o Prestador não for encontrado no banco")
    void deveLancarExcecaoQuandoPrestadorNaoExiste() {
        // Arrange
        UUID prestadorId = UUID.randomUUID();
        UUID clienteId = UUID.randomUUID();
        AgendamentoRequisicaoDTO requisicao = new AgendamentoRequisicaoDTO(LocalDateTime.now().plusDays(1), prestadorId, clienteId);

        // Configurando Mock: O banco procura o prestador e retorna vazio (Optional.empty)
        when(prestadorRepositorio.findById(prestadorId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecursoNaoEncontradoExcecao.class, () -> {
            agendamentoServico.agendar(requisicao);
        });

        // Como o prestador não existe, o sistema nem deve tentar buscar o cliente
        verify(clienteRepositorio, never()).findById(any());
        verify(agendamentoRepositorio, never()).save(any());
    }
}