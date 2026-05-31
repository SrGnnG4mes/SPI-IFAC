package com.example.AtividadeAvaliativaFinal.mapeador;

import com.example.AtividadeAvaliativaFinal.DTO.LogradouroDTO;
import com.example.AtividadeAvaliativaFinal.modelo.Logradouro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogradouroMapeador {
    Logradouro paraEntidade(LogradouroDTO dto);
    LogradouroDTO paraDto(Logradouro entidade);
}