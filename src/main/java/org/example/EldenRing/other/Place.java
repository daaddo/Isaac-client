package org.example.EldenRing.other;

public enum Place {
    VALLE_INIZIALE(1),
    TORRE_DEI_MAGHI(1.3),
    OSCURA_PREFETTURA(1.85),
    PALAZZO_DEL_RE(2.3);
    private final double difficolta;
    public double getDifficolta() {
        return difficolta;
    }
    Place(double difficolta) {
        this.difficolta = difficolta;

    }
}
