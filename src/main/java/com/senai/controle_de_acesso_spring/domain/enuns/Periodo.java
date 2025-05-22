package com.senai.controle_de_acesso_spring.domain.enuns;


public enum Periodo {
    MANHA("M"),
    TARDE("T"),
    NOITE("N"),
    INTEGRAL("I");

    Periodo(String sigla) {
        this.sigla = sigla;
    }

    private final String sigla;

    public String getSigla() {
        return sigla;
    }
}
