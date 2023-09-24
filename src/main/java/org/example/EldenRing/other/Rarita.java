package org.example.EldenRing.other;

public enum Rarita {
        COMUNE(1.5F),
        RARO(2),
        EPICO(2.5F),
        LEGGENDARIO(3);
        private final float moltiplicatore;

        public float getMoltiplicatore() {
                return moltiplicatore;
        }


        Rarita(float moltiplicatore ){
                this.moltiplicatore = moltiplicatore;
        }

}
