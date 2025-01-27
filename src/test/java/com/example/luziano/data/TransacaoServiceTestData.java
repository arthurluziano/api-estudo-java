package com.example.luziano.data;

import com.example.luziano.domain.TransacaoDTO;

public class TransacaoServiceTestData {

    public static TransacaoDTO transacaoNormal() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setValor(5.99);

        return transacaoDTO;
    }

    public static TransacaoDTO transacaoValorNulo() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setValor(null);

        return transacaoDTO;
    }

    public static TransacaoDTO transacaoMenorQueZero() {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setValor(-2.99);

        return transacaoDTO;
    }
}
