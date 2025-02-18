package com.example.luziano.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {

    private Integer idTransacao;
    private Double valor;
    private OffsetDateTime dataHora;
}
