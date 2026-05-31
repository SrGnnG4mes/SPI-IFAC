package com.example.AtividadeAvaliativaFinal.servico;

import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.PrestadorRespostaDTO;
import com.example.AtividadeAvaliativaFinal.mapeador.PrestadorMapeador;
import com.example.AtividadeAvaliativaFinal.modelo.Prestador;
import com.example.AtividadeAvaliativaFinal.repositorio.PrestadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestadorServico {

    @Autowired
    private PrestadorRepositorio repositorio;

    @Autowired
    private PrestadorMapeador mapeador;

    public PrestadorRespostaDTO salvar(PrestadorRequisicaoDTO dto){
        Prestador entidade = mapeador.paraEntidade(dto);
        Prestador salvo = repositorio.save(entidade);
        return mapeador.paraDto(salvo);
    }
}
