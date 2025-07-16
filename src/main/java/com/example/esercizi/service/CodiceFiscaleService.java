package com.example.esercizi.service;

import com.example.esercizi.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class CodiceFiscaleService {

    public PersonaDTO estraiDatiDaCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() < 16) {
            throw new IllegalArgumentException("Codice fiscale non valido.");
        }

        // Estrazione anno
        int anno = Integer.parseInt(codiceFiscale.substring(6, 8));
        anno += (anno >= 0 && anno <= LocalDate.now().getYear() % 100) ? 2000 : 1900;

        // Estrazione mese
        char meseChar = codiceFiscale.charAt(8);
        int mese = "ABCDEHLMPRST".indexOf(meseChar) + 1;

        // Estrazione giorno e sesso
        int giorno = Integer.parseInt(codiceFiscale.substring(9, 11));
        if (giorno > 40) giorno -= 40; // donna

        LocalDate dataNascita = LocalDate.of(anno, mese, giorno);
        int eta = Period.between(dataNascita, LocalDate.now()).getYears();

        return new PersonaDTO(dataNascita, eta);
    }
}
