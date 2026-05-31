package com.example.AtividadeAvaliativaFinal.servico;

import com.example.AtividadeAvaliativaFinal.DTO.ClienteRequisicaoDTO;
import com.example.AtividadeAvaliativaFinal.DTO.ClienteRespostaDTO;
import com.example.AtividadeAvaliativaFinal.mapeador.ClienteMapeador;
import com.example.AtividadeAvaliativaFinal.modelo.Cliente;
import com.example.AtividadeAvaliativaFinal.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;

    @Autowired
    private ClienteMapeador mapeador;

    public ClienteRespostaDTO salvar(ClienteRequisicaoDTO dto){
        Cliente entidade = mapeador.paraEntedidade(dto);
        Cliente Salvo = repositorio.save(entidade);
        return mapeador.paraDto(Salvo);
    }
}
