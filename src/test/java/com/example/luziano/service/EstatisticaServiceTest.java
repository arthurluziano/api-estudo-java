package com.example.luziano.service;

import com.example.luziano.data.EstatisticaServiceTestData;
import com.example.luziano.domain.EstatisticaDTO;
import com.example.luziano.services.EstatisticaService;
import com.example.luziano.services.TransacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EstatisticaServiceTest {

    @Mock
    private TransacaoService transacaoService;

    @InjectMocks
    private EstatisticaService estatisticaService;

    @Test
    void DADO_lista_transacoes_DEVE_retornar_estatisticas_preenchidas_QUANDO_transacoes_feitas_ha_no_maximo_60_segundos() {
        when(transacaoService.getListaDeTransacoes()).thenReturn(EstatisticaServiceTestData.listaTransacoes());

        EstatisticaDTO result = estatisticaService.retornaEstatisticasTransacoes();

        assertNotNull(result);
    }

    @Test
    void DADO_lista_transacoes_DEVE_retornar_estatisticas_vazias_QUANDO_transacoes_feitas_apos_60_segundos() {
        when(transacaoService.getListaDeTransacoes()).thenReturn(new ArrayList<>());

        EstatisticaDTO result = estatisticaService.retornaEstatisticasTransacoes();

        assertEquals(0, result.getCount());
        assertEquals(0.0, result.getSum());
        assertEquals(0.0, result.getAvg());
        assertEquals(0.0, result.getMin());
        assertEquals(0.0, result.getMax());
    }
}
