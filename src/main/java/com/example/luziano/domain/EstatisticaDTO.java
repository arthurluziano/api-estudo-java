package com.example.luziano.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstatisticaDTO {
    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
