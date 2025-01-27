package com.example.luziano.controllers;

import com.example.luziano.services.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<?> calcularEstatisticas() {
        try {
            return ResponseEntity.ok(estatisticaService.retornaEstatisticasTransacoes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
