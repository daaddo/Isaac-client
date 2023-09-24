package org.example.EldenRing.other;



import org.example.EldenRing.Characters.Guerriero.Guerriero;
import org.example.EldenRing.Characters.Guerriero.HardGuerrieroItemSelector;
import org.example.EldenRing.Characters.Guerriero.NormalGuerrieroItemSelector;
import org.example.EldenRing.Characters.Person;
import org.example.EldenRing.Characters.Samurai.HardSamuraiItemSelector;
import org.example.EldenRing.Characters.Samurai.NormalSamuraiItemSelector;
import org.example.EldenRing.Characters.Samurai.Samurai;
import org.example.EldenRing.exceptions.DeadException;
import org.example.EldenRing.exceptions.Nullexp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TODO mappa sequenziale in cui ogni 3 o n passi vi è
// un falò dove si possono ricaricare il numero di pozioni di cura e potenziarsi, ad esempio aumentando la vita massima e ricaricando la vita effettiva
public class Main {
    public static void main(String[] args){
        int counter;
        ListItems.getInstance();
        Scanner scanner = new Scanner(System.in);
        Person a;
        while(true) {
            System.out.println("che personaggio vuoi essere? \na-> SamuraiHard :" + Samurai.toStringStatic(new HardSamuraiItemSelector())
                    + "\nor SamuraiNormal :" + Samurai.toStringStatic(new NormalSamuraiItemSelector())
                    +"\nb-> GuerrieroHard :" + Guerriero.toStringStatic(new HardGuerrieroItemSelector())+
                    "\nor GuerrieroNormal :" + Guerriero.toStringStatic(new NormalGuerrieroItemSelector()));
            String input = scanner.nextLine();
            if (input.equals("a")) {
                System.out.println("che difficolta vuoi giocare? hard o normal?");
                input = scanner.nextLine();

                if(input.equals("normal")) {
                    a = new Samurai("",new NormalSamuraiItemSelector());
                    break;
                }
                if(input.equals("hard")) {
                    a = new Samurai("",new HardSamuraiItemSelector());
                    break;
                }
            }
            if (input.equals("b")) {
                System.out.println("che difficolta vuoi giocare? hard o normal?");
                input = scanner.nextLine();

                if(input.equals("normal")) {
                    a = new Guerriero("",new NormalGuerrieroItemSelector());
                    break;
                }
                if(input.equals("hard")) {
                    a = new Guerriero("",new HardGuerrieroItemSelector());
                    break;
                }
            }
            else{
                System.out.println("personaggio non valido");
                continue;
            }
        }
        while(true) {
            System.out.println("come vuoi chiamare il tuo personaggio? ");
            String input = scanner.nextLine();

            try{
                a.setName(input);
            } catch (Nullexp e) {
                System.out.println("nome invalido");
                continue;
            }
            break;
        }
        while (a.isAlive()){
            try {
                while (a.isAlive()) {
                    System.out.print("le tue monete:"+a.getMoney()+"\na-> esplora\nb-> potenziati\nc-> accedi all' inventario\nd-> curati: ");
                    String inputString = scanner.nextLine();
                    if (inputString == null || !inputString.matches("[a-d]")) {
                        System.out.println("hai inserito una opzione non valida");
                        continue;
                    }
                    if(inputString.equals("a")){
                        a.explore();
                    }
                    if(inputString.equals("b")){
                        if (a.getOggetti().isEmpty()){
                            System.out.println("non hai oggetti...");
                            continue;
                        }
                        System.out.println("con che oggetto vuoi potenziare l'arma?");
                        a.toStringOggetti();
                        inputString = scanner.nextLine();
                        Item upgrade = new Item();
                        for (Item item : a.getOggetti()) {
                            if (item.getNome().equals(inputString)){
                                upgrade=item;
                                break;
                            }
                        }
                        a.upgrade(upgrade);
                    }
                    if(inputString.equals("c")){
                        while (true) {
                            System.out.println("cosa vuoi fare?\na-> cambia arma\nb-> cambia abilità\nc-> visualizza oggetti\ne-> torna indietro\n");
                            inputString= scanner.nextLine();
                            if (inputString.matches("a|A")){
                                System.out.println(a.getNomiArmi());
                                System.out.println("con che arma la vuoi cambiare? ");
                                inputString= scanner.nextLine();
                                counter =0;
                                for (Weapon arma : a.getArmi()) {
                                    if (arma.getNome().equals(inputString)){
                                        if (counter ==0){
                                            System.out.println("hai già inserito quest arma come primaria\n");
                                            break;
                                        }
                                         a.setPrimaryWeapon(counter);
                                        break;
                                    }
                                    counter++;
                                }
                            }
                            if (inputString.matches("b|B")){
                                System.out.println(a.getNomiAbilita());
                                System.out.println("con che abilità la vuoi cambiare? ");
                                inputString= scanner.nextLine();
                                counter =0;
                                for (Ability ability : a.getAbilita()) {
                                    if (ability.getNome().equals(inputString)){
                                        if (counter ==0){
                                            System.out.println("hai già inserito quest abilita come primaria\n");
                                            break;
                                        }
                                         a.setPrimaryAbility(counter);
                                        break;
                                    }
                                    counter++;
                                }
                            }
                            if (inputString.matches("c|C")){
                                System.out.println("vuoi ordinare gli oggetti secondo qualche parametro? si no");
                                inputString = scanner.nextLine();
                                if (inputString.matches("si")){
                                    System.out.println("secondo quale parametro vuoi ordinarla nome ->a rarità->b tipo ->c");
                                    inputString = scanner.nextLine();
                                    if (inputString.matches("a")){
                                        a.sortByName();
                                    }
                                    if (inputString.matches("b")){
                                        a.sortByRarity();
                                    }
                                    if (inputString.matches("c")){
                                        a.sortByType();
                                    }
                                }
                                System.out.println(a.getOggetti().toString());
                                break;
                            }

                            if (inputString.matches("e|E")){
                                break;
                            }
                            System.out.println("scelta non valida");
                        }
                    }
                    if(inputString.equals("d")) {
                        List<Item> lista = new LinkedList<>();
                        for (Item item : a.getOggetti()) {
                            if (item.getTipo() == Tipo.POZIONE_CURATIVA) {
                                lista.add(item);
                            }
                        }
                        System.out.println(lista);
                        System.out.println("con quale rarita vuoi curarti?");
                        inputString = scanner.nextLine();
                        a.usaPozioneCura(inputString);
                        System.out.println("adesso hai "+a.getHealth());
                    }
                }
            } catch (DeadException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
