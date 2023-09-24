package org.example.EldenRing.other;

public class Item {

    private Rarita rarita;
    private String nome;
    private Tipo tipo;
    private int price;
    public Tipo getTipo() {
        return tipo;
    }

    public Rarita getRarita() {
        return rarita;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Item(Rarita rarita, String nome, Tipo tipo) {
        if (rarita == null || nome == null){
            throw  new NullPointerException("rarita and nome cannot be null");
        }
        this.rarita = rarita;
        this.nome = nome;
        this.tipo = tipo;
        this.price = getPriceOfItem();
    }

    public int getPriceOfItem() {
        if(this.tipo == Tipo.POZIONE_CURATIVA||tipo == Tipo.POZIONE_BUFF||tipo == Tipo.POZIONE_DANNO){
            return (int) (20* this.rarita.getMoltiplicatore());
        }
        if(this.tipo == Tipo.ARMATURA){
            return (int) (55* this.rarita.getMoltiplicatore());
        }
        return (int) (80* rarita.getMoltiplicatore());
    }

    public Item(){
        this.nome = "INUTILIZZABILE";
    }
    @Override
    public String toString() {
        return "\n"+rarita + "  "+ nome +" " + tipo +" " +price+"\n";
    }
}
