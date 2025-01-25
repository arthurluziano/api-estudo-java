package com.example.luziano.controllers;

import com.example.luziano.domain.EstatisticaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @GetMapping
    public EstatisticaDTO calcularEstatisticas() {
        return new EstatisticaDTO();
    }
}
