package com.example.luziano.controllers;

import com.example.luziano.domain.TransacaoDTO;
import com.example.luziano.domain.base.TransacaoNegativaException;
import com.example.luziano.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<?> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) throws Exception {
        try {
            transacaoService.realizarTransacao(transacaoDTO);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (TransacaoNegativaException tne) {
            return ResponseEntity.unprocessableEntity().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletarTransacoes() {
        try {
            transacaoService.deletarTransacoes();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
