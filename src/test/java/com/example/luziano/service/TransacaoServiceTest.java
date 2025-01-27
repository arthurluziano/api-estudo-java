package com.example.luziano.service;

import com.example.luziano.data.TransacaoServiceTestData;
import com.example.luziano.domain.TransacaoDTO;
import com.example.luziano.domain.base.TransacaoNegativaException;
import com.example.luziano.services.TransacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Test
    void DADO_transacao_dto_DEVE_realizar_transacao_QUANDO_valor_transacao_valido() {
        TransacaoDTO transacaoDTO = TransacaoServiceTestData.transacaoNormal();

        assertDoesNotThrow(() -> transacaoService.realizarTransacao(transacaoDTO));
    }

    @Test
    void DADO_transacao_dto_DEVE_retornar_Exception_QUANDO_valor_transacao_nulo() {
        TransacaoDTO transacaoDTO = TransacaoServiceTestData.transacaoValorNulo();

        assertThrows(Exception.class, () -> transacaoService.realizarTransacao(transacaoDTO));
    }

    @Test
    void DADO_transacao_dto_DEVE_retornar_Exception_QUANDO_valor_transacao_menor_que_zero() {
        TransacaoDTO transacaoDTO = TransacaoServiceTestData.transacaoMenorQueZero();

        assertThrows(TransacaoNegativaException.class, () -> transacaoService.realizarTransacao(transacaoDTO));
    }

    @Test
    void DEVE_deletar_transacoes_QUANDO_chamado() {
        assertDoesNotThrow(() -> transacaoService.deletarTransacoes());
    }

    @Test
    void DEVE_retornar_lista_transacoes_QUANDO_chamado() {
        List<TransacaoDTO> result = transacaoService.getListaDeTransacoes();

        assertNotNull(result);
    }
}
