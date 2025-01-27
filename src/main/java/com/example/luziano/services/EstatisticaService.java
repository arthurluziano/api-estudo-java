package com.example.luziano.services;

import com.example.luziano.domain.EstatisticaDTO;
import com.example.luziano.domain.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EstatisticaService {

    @Autowired
    private TransacaoService transacaoService;

    public EstatisticaDTO retornaEstatisticasTransacoes() {
        List<TransacaoDTO> listaTransacoes = transacaoService.getListaDeTransacoes();

        return criaEstatisticaDTO(listaTransacoes);
    }

    private EstatisticaDTO criaEstatisticaDTO(List<TransacaoDTO> listaTransacoes) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicReference<Double> sum = new AtomicReference<>();
        AtomicReference<Double> avg = new AtomicReference<>();
        AtomicReference<Double> min = new AtomicReference<>();
        AtomicReference<Double> max = new AtomicReference<>();

        List<TransacaoDTO> novaLista = new ArrayList<>();

        listaTransacoes.forEach(transacao -> {
            if(transacao.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60))) {
                novaLista.add(transacao);
            }
        });

        if(!novaLista.isEmpty()) {
            count.set(novaLista.size());

            AtomicReference<Double> media = new AtomicReference<>(0.0);
            sum.set(0.0);
            avg.set(0.0);
            min.set(novaLista.get(0).getValor());
            max.set(novaLista.get(0).getValor());

            novaLista.forEach(transacao -> {
                sum.set(transacao.getValor() + Double.parseDouble(String.valueOf(sum)));
                min.set(transacao.getValor() > Double.parseDouble(String.valueOf(min)) ? min.updateAndGet(minimun -> transacao.getValor()) : transacao.getValor());
                max.set(transacao.getValor() < Double.parseDouble(String.valueOf(max)) ? Double.parseDouble(String.valueOf(max)) : max.updateAndGet(maximun -> transacao.getValor()));

                media.updateAndGet(v -> v + transacao.getValor());
                avg.set(Double.parseDouble(String.valueOf(media)) / novaLista.size());
            });

            EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
            estatisticaDTO.setCount(Integer.parseInt(String.valueOf(count)));
            estatisticaDTO.setSum(Double.parseDouble(String.valueOf(sum)));
            estatisticaDTO.setAvg(Double.parseDouble(String.valueOf(avg)));
            estatisticaDTO.setMin(Double.parseDouble(String.valueOf(min)));
            estatisticaDTO.setMax(Double.parseDouble(String.valueOf(max)));

            return estatisticaDTO;
        }

        return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
    }
}
