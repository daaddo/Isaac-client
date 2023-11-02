package org.example.isaac.models.characters;

public enum Special {
    NORMAL (1),
    MINI(0.5),
    BIG(1.5),
    SUPER(2);
    private double multiplyier;

    Special(double multiplyier) {
        this.multiplyier=multiplyier;
    }

    public static Special getRandomSpecial() {
        double random = Math.random();
        if (random<0.4) {
            return NORMAL;
        }
        if (random<0.6) {
            return MINI;
        }
        if (random<0.8) {
            return BIG;
        }
        return SUPER;
    }

    public double getMultiplyier() {
        return multiplyier;
    }
}
