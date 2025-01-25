package com.example.luziano.services;

import com.example.luziano.domain.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaService {

    private List<TransacaoDTO> listaTransacoes;

    public EstatisticaService(List<TransacaoDTO> listaTransacoes) {
        this.listaTransacoes = listaTransacoes;
    }
}
