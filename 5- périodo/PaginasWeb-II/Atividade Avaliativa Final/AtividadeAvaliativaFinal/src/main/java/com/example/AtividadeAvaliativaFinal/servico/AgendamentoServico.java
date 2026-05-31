package com.example.AtividadeAvaliativaFinal.servico;

import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.AgendamentoRespostaDTO;
import com.example.AtividadeAvaliativaFinal.excecao.HorarioOcupadoExcecao;
import com.example.AtividadeAvaliativaFinal.excecao.RecursoNaoEncontradoExcecao;
import com.example.AtividadeAvaliativaFinal.mapeador.AgendamentoMapeador;
import com.example.AtividadeAvaliativaFinal.modelo.Agendamento;
import com.example.AtividadeAvaliativaFinal.repositorio.AgendamentoRepositorio;
import com.example.AtividadeAvaliativaFinal.repositorio.ClienteRepositorio;
import com.example.AtividadeAvaliativaFinal.repositorio.PrestadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendamentoServico {

    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;

    @Autowired
    private PrestadorRepositorio prestadorRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private AgendamentoMapeador mapeador;

    @Transactional
    public AgendamentoRespostaDTO agendar(AgendamentoRequisicaoDTO dto){
        var prestador = prestadorRepositorio.findById(dto.prestadorId())
                .orElseThrow(() -> new RecursoNaoEncontradoExcecao("Prestador não encontrado."));

        var cliente = clienteRepositorio.findById(dto.clienteId())
                .orElseThrow(()-> new RecursoNaoEncontradoExcecao("Cliente não encontrado."));

        if (agendamentoRepositorio.existeHorarioConflitante(dto.prestadorId(), dto.dataHora())){
            throw new HorarioOcupadoExcecao("Este prestador já possui um agendamento marcado neste horário.");
        }

        Agendamento agendamento = mapeador.paraEntidade(dto);
        agendamento.setPrestador(prestador);
        agendamento.setCliente(cliente);

        return mapeador.paraDto(agendamentoRepositorio.save(agendamento));
    }
}