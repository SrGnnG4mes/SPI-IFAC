package com.example.AtividadeAvaliativaFinal.mapeador;

import com.example.AtividadeAvaliativaFinal.DTO.*;
import com.example.AtividadeAvaliativaFinal.modelo.Agendamento;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface AgendamentoMapeador {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "prestador.id", source = "prestadorId")
    @Mapping(target = "cliente.id", source = "clienteId")
    Agendamento paraEntidade(AgendamentoRequisicaoDTO dto);

    @Mapping(target = "nomePrestador", source = "prestador.nome")
    @Mapping(target = "nomeCliente", source = "cliente.nome")
    @Mapping(target = "telefoneCliente", source = "cliente.telefone")
    AgendamentoRespostaDTO paraDto(Agendamento entidade);

}
