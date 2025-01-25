package com.example.luziano.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @PostMapping
    public void realizarTransacao() {

    }

    @DeleteMapping
    public void deletarTransacoes() {

    }
}
