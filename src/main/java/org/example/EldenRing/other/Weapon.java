package org.example.EldenRing.other;

public class Weapon {
    private Rarita rarita;
    private float damage;
    private int durability;
    private String nome;

    public float getDamage() {
        return damage;
    }

    private void setDamage(float damage) {
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Rarita getRarita() {
        return rarita;
    }

    public Weapon(float damage, int durability, String nome, Rarita rarita) {
        setDamage(damage);
        this.durability = durability;
        this.nome = nome;
        this.rarita = rarita;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", durability=" + durability +
                ", nome='" + nome + '\'' +
                '}';
    }
}
