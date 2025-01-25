package com.example.luziano.services;

import com.example.luziano.domain.TransacaoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransacaoService {

    private List<TransacaoDTO> listaTransacoes = new ArrayList<>();

    public List<TransacaoDTO> listaTransacoes() {
        log.info("Listando transações...");
        log.info("Lista de transações: {}", listaTransacoes);
        return listaTransacoes;
    }

    public void realizarTransacao(TransacaoDTO transacaoDTO) {
        transacaoDTO.setDataHora(OffsetDateTime.now());
        log.info("Horário transação - {}", transacaoDTO.getDataHora());

        if(validaTransacao(transacaoDTO)) {
            log.info("Realizando transação...");
            listaTransacoes.add(transacaoDTO);
            log.info("Transação realizada!");
            return;
        }

        log.warn("Valor da transação inválido.");
    }

    public void deletarTransacoes() {
        listaTransacoes.clear();
        log.info("Lista de transações: {}", listaTransacoes.toString());
        log.info("Transações excluídas com sucesso.");
    }

    private boolean validaTransacao(TransacaoDTO transacaoDTO) {
        return transacaoDTO.getValor() != null && transacaoDTO.getValor() >= 0;
    }
}
