package com.example.luziano.domain.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransacaoNegativaException extends Exception{

    private static final long serialVersionUID = 1149241039409861914L;

    private Integer status;
}
