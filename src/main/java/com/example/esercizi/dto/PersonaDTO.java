package com.example.esercizi.dto;

import java.time.LocalDate;

public class PersonaDTO {
    private LocalDate dataNascita;
    private int eta;

    public PersonaDTO(LocalDate dataNascita, int eta) {
        this.dataNascita = dataNascita;
        this.eta = eta;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public int getEta() {
        return eta;
    }
}