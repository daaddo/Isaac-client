package org.example.EldenRing.other;

public enum Tipo {
    ARMA(1),
    ARMATURA(1),
    POZIONE_CURATIVA(3),
    POZIONE_BUFF(2),
    POZIONE_DANNO(4);

    private final int moltiplicatore;

    public int getMoltiplicatore() {
        return moltiplicatore;
    }

    Tipo(int moltiplicatore) {
        this.moltiplicatore = moltiplicatore;
    }

}
