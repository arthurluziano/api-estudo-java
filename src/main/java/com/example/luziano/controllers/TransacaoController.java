package com.example.luziano.controllers;

import com.example.luziano.domain.TransacaoDTO;
import com.example.luziano.domain.base.BaseResponse;
import com.example.luziano.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public BaseResponse listaTransacoes() {
        try {
            return new BaseResponse(HttpStatus.OK.value(), transacaoService.listaTransacoes());
        } catch (Exception e) {
            return new BaseResponse(HttpStatus.BAD_REQUEST.value(), "");
        }
    }

    @PostMapping
    public BaseResponse realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.realizarTransacao(transacaoDTO);
            return new BaseResponse(HttpStatus.CREATED.value(), "");
        } catch (Exception e) {
            return new BaseResponse(HttpStatus.BAD_REQUEST.value(), "");
        }
    }

    @DeleteMapping
    public BaseResponse deletarTransacoes() {
        transacaoService.deletarTransacoes();
        return new BaseResponse(HttpStatus.OK.value(), "");
    }
}
