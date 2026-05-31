package com.example.AtividadeAvaliativaFinal.mapeador;

import com.example.AtividadeAvaliativaFinal.DTO.ClienteRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.ClienteRespostaDTO;
import com.example.AtividadeAvaliativaFinal.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapeador {

    @Mapping(target = "id", ignore = true)
    Cliente paraEntedidade(ClienteRequisicaoDTO dto);

    ClienteRespostaDTO paraDto(Cliente entidade);
}
