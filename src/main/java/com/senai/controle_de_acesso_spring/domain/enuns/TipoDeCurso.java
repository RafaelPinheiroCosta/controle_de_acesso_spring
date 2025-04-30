package com.senai.controle_de_acesso_spring.domain.enuns;

public enum TipoDeCurso {
    CAI(20), TECNICO(15);

    private final int intervaloMinutos;

    TipoDeCurso(int intervaloMinutos) {
        this.intervaloMinutos = intervaloMinutos;
    }

    public int getIntervaloMinutos() {
        return intervaloMinutos;
    }
}
