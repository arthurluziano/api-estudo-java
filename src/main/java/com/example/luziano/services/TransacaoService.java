package com.example.luziano.services;

import com.example.luziano.domain.TransacaoDTO;
import com.example.luziano.domain.base.TransacaoNegativaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class TransacaoService {

    private List<TransacaoDTO> listaTransacoes = new ArrayList<>();
    private final AtomicInteger idTransacao = new AtomicInteger(0);

    public void realizarTransacao(TransacaoDTO transacaoDTO) throws Exception {
        if(validaTransacao(transacaoDTO)) {
            log.info("Realizando transação...");
            transacaoDTO.setDataHora(OffsetDateTime.now());
            transacaoDTO.setIdTransacao(idTransacao.getAndIncrement());

            listaTransacoes.add(transacaoDTO);
            log.info("Transação realizada!");
        }
    }

    public void deletarTransacoes() {
        listaTransacoes.clear();
        log.info("Transações excluídas com sucesso.");
    }

    private boolean validaTransacao(TransacaoDTO transacaoDTO) throws Exception {
        if(transacaoDTO.getValor() == null) {
            log.error("O valor da transação não pode ser nulo.");
            throw new Exception();
        }

        if(transacaoDTO.getValor() < 0) {
            log.error("O valor da transação deve ser maior do que zero.");
            throw new TransacaoNegativaException(422);
        }

        return true;
    }

    public List<TransacaoDTO> getListaDeTransacoes() {
        return listaTransacoes;
    }
}
