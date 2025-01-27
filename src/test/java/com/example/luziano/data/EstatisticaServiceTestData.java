package com.example.luziano.data;

import com.example.luziano.domain.EstatisticaDTO;
import com.example.luziano.domain.TransacaoDTO;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstatisticaServiceTestData {

    public static EstatisticaDTO estatisticaPreenchida() {
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        estatisticaDTO.setCount(5);
        estatisticaDTO.setMin(1.99);
        estatisticaDTO.setMax(7.59);
        estatisticaDTO.setSum(9.58);
        estatisticaDTO.setAvg(4.79);

        return estatisticaDTO;
    }

    public static EstatisticaDTO estatisticaVazia() {
        return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
    }

    public static List<TransacaoDTO> listaTransacoes() {
        List<TransacaoDTO> listaTransacoes = new ArrayList<>();

        listaTransacoes.add(new TransacaoDTO(1, 1.99, OffsetDateTime.now()));
        listaTransacoes.add(new TransacaoDTO(2, 7.59, OffsetDateTime.now()));

        return listaTransacoes;
    }
}
