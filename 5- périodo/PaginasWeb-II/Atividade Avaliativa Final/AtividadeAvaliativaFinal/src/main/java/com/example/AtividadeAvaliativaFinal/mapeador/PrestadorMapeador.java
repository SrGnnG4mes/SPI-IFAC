package com.example.AtividadeAvaliativaFinal.mapeador;


import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRespostaDTO;
import com.example.AtividadeAvaliativaFinal.modelo.Prestador;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PrestadorMapeador {

    @Mapping(target = "id", ignore = true)
    Prestador paraEntidade(PrestadorRequisicaoDTO dto);

    PrestadorRespostaDTO paraDto(Prestador entidade);
}
