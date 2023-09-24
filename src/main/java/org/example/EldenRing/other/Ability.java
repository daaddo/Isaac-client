package org.example.EldenRing.other;
public class Ability {
    private int countdown;
    private int damage;
    private String nome;
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getCountdown(){
        return countdown;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Ability(int damage, String nome, int countdown) {
        this.damage = damage;
        this.nome = nome;
        this.countdown = countdown;
    }

    @Override
    public String toString() {
        return "Ability =[" +
                " nome: " + nome+
                ", damage= " + damage+" ]";
    }
}
