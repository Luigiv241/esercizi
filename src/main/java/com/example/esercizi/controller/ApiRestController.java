package com.example.esercizi.controller;

import com.example.esercizi.dto.PersonaDTO;
import com.example.esercizi.service.CodiceFiscaleService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/codice-fiscale")
public class ApiRestController {

    @Autowired
    private CodiceFiscaleService service;
    @GetMapping("/{codiceFiscale}")
    public PersonaDTO getInfo(
            @PathVariable String codiceFiscale) {
        return service.estraiDatiDaCodiceFiscale(codiceFiscale);
    }
}
