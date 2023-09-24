package org.example.EldenRing.Characters.Samurai;



import org.example.EldenRing.Characters.Person;
import org.example.EldenRing.exceptions.DeadException;
import org.example.EldenRing.other.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Samurai extends Person {



    public static String toStringStatic(SamuraiItemSelector selector){
        Samurai a = new Samurai("",selector);
        List<String> nomiArmi = a.getNomiArmi();
        return "agility= " + a.agility + " health= " + a.health + " armi= " + nomiArmi+" abilita= " + a.abilita.toString();
    }

    public Samurai(String name, SamuraiItemSelector samuraiSelector){
        super(name, samuraiSelector);
        this.npc=false;
        this.abilita.add(new Ability(10,"falangegge",3));
        this.agility=samuraiSelector.getAgility();
        this.armi.add(ItemManager.getInstance().getSamuraiWeapon());
        this.health= samuraiSelector.getHealth();
        this.maxHealth = this.health;
        this.experience=0;
        this.oggetti= ListItems.getInstance().getSamuraiItems();
    }

    @Override
    public String toString() {
        return "agility= " + agility +
                "\n health= " + health +
                "\n abilita= " + abilita +
                "\n armi= " + armi;
    }
    @Override
    public boolean attack(Person attaccato, int count) throws DeadException {
        if (this.npc){
            double random = Math.random()*100;
            if (random <75){
                /*try {
                    attaccato.setHealth(((float) (attaccato.getHealth() - this.getPrimaryWeapon().getDamage() * attaccato.getPlace().getDifficolta())));
                } catch (FullHealtExp e) {
                    System.out.println("non dovrebbe succedere ma fullHealthExp su attacco");
                }*/
                System.out.println(this.getName()+"ti ha attaccato! e ti ha levato "+this.getPrimaryWeapon().getDamage()+" adesso hai "+attaccato.getHealth());
                return false;
            }
            /*try {
                attaccato.setHealth((float) (attaccato.getHealth() - this.getPrimaryAbility().getDamage() * attaccato.getPlace().getDifficolta()));
            } catch (FullHealtExp e) {
                System.out.println("non dovrebbe succedere ma fullHealthExp su abilità");
            }*/
            System.out.println(this.getName()+"ti ha attaccato con la sua abilità! e ti ha levato "+this.getPrimaryAbility().getDamage()+" adesso hai "+attaccato.getHealth());
            return true;
        }
        Scanner scanner = new Scanner(System.in);
        //implementare countdown dell abilità
        //implementare uso degli oggetti
        //implementare l uso delle pozioni buff -> quando vengono usate il danno aumenta per un tot di attacchi
        //implementare l uso delle pozioni danno
        System.out.println("la tua vita: "+this.getHealth()+"\n vita del nemico: "+attaccato.getHealth());
        while(true) {
            System.out.print("Come vuoi attaccare? a-> usa un oggetto b-> attacca con l'arma c-> usa abilità");
            String inputString = scanner.nextLine();
            if (inputString.equals("a")) {
                List<Item> utilizzabili = new LinkedList<>();
                for (Item item : this.getOggetti()) {
                    if (item.getTipo()== Tipo.POZIONE_BUFF||item.getTipo()== Tipo.POZIONE_CURATIVA||item.getTipo()== Tipo.POZIONE_DANNO){
                        utilizzabili.add(item);
                    }
                }
                if (utilizzabili.isEmpty()){
                    System.out.println("non hai items da usare");
                    continue;
                }
                System.out.println("che oggetto vuoi usare? \n" + utilizzabili);
                inputString = scanner.nextLine();
                for (Item item : utilizzabili) {
                    if (item.getNome().equals(inputString)){
                        Item used = new Item();
                        used=item;
                        if (used.getNome().equals("INUTILIZZABILE")){
                            System.out.println("item non esistente");
                            continue;
                        }
                        if (used.getTipo()== Tipo.POZIONE_CURATIVA){
                            String rarita;
                            System.out.println("vita iniziale = "+this.getHealth());
                            usaPozioneCura(used.getNome());
                            this.oggetti.remove(used);
                            System.out.println("vita finale = "+this.getHealth());
                        }
                        break;
                    }
                }
            }
            if (inputString.equals("b")) {
               /* try {
                    attaccato.setHealth(attaccato.getHealth() - this.getPrimaryWeapon().getDamage());
                } catch (FullHealtExp e) {
                    System.out.println("non dovrebbe succedere ma sei riuscito a curare il nemico");
                }
                break;*/
            }
            if (inputString.equals("c")){
                if(count >= this.getPrimaryAbility().getCountdown()){
                   /* try {

                        attaccato.setHealth((float) (attaccato.getHealth() - this.getPrimaryAbility().getDamage() * attaccato.getPlace().getDifficolta()));
                        return true;
                    } catch (FullHealtExp e) {
                        System.out.println("non dovrebbe succedere ma hai curato il nemico con l abilità");
                    }*/
                }
                System.out.println("devi aspettare che il countdown della tua abilità finisca, mancano altri "+(this.getPrimaryAbility().getCountdown()-count)+" turni");
            }
        }
        /*if (attaccato.getHealth() <= 0) {
            attaccato.setAlive(false);
            throw new DeadException();
        }
        return false;*/
    }

}