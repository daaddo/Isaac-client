package org.example.EldenRing.Characters;


import org.example.EldenRing.Characters.Mercante.MercanteItemSelector;
import org.example.EldenRing.Characters.Npc.NpcItemSelector;
import org.example.EldenRing.exceptions.DeadException;
import org.example.EldenRing.exceptions.NotEnoughMoneyExc;
import org.example.EldenRing.exceptions.Nullexp;
import org.example.EldenRing.Characters.Npc.Npc;
import org.example.EldenRing.Characters.Mercante.Mercante;
import org.example.EldenRing.other.*;


import java.util.*;

public abstract class Person implements PersonMethods{
    private ItemSelector itemSelector;
    protected float maxHealth;
    protected int money;
    protected boolean npc;
    protected int experience;
    protected Place place;
    protected List<Item> oggetti;
    protected int agility;
    protected float health;
    private String name;
    protected List<Ability> abilita = new LinkedList<>();
    protected List<Weapon> armi = new LinkedList<>();
    private boolean alive;
    public int getAgility() {
        return agility;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return
                "oggetti= " + oggetti;
    }
    public void sortByName(){
        Comparator<Item> comparator= new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };
        oggetti.sort(comparator);
    }
    public void sortByType(){
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getTipo().compareTo(o2.getTipo()) == 0){
                    return o1.getRarita().compareTo(o2.getRarita());
                }
                return o1.getTipo().compareTo(o2.getTipo());
            }
        };
        oggetti.sort(comparator);
    }
    public void sortByRarity(){
        Comparator<Item> comparatorAge = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getRarita().compareTo(o2.getRarita())== 0){
                    return o1.getNome().compareTo(o2.getNome());
                }
                return o1.getRarita().compareTo(o2.getRarita());
            }
        };
        oggetti.sort(comparatorAge);
    }
    public List<Item> getOggetti() {
        return Collections.unmodifiableList(this.oggetti);
    }
    public float getHealth() {
        return health;
    }

    protected void setHealth(float health) throws DeadException, FullHealtExp {
        if (health <=0){
            this.alive = false;
            throw new DeadException();
        }
        if (health >= maxHealth){
            this.health = this.maxHealth;
            System.out.println("hai raggiunto la vita massima");
        }
        else {
            this.health = health;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws Nullexp {
        if (name == null || name.isEmpty() || name.isBlank() || !name.matches("[a-zA-Z]{3,}")){
            throw new Nullexp();
        }
        this.name = name;
    }

    public List<Ability> getAbilita() {
        return abilita;
    }
    public List<Weapon> getArmi() {
        return armi;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public List<String> getNomiArmi(){
        List<String> arma = new ArrayList<>();
        for (Weapon a : armi) {
            arma.add(a.getNome()+" dmg= "+a.getDamage());
        }
        return arma;
    }
    public List<String> getNomiAbilita(){
        List<String> ability = new ArrayList<>();
        for (Ability a : abilita) {
            ability.add(a.getNome()+" dmg= "+a.getDamage());
        }
        return ability;
    }

    public Person(String name, ItemSelector itemSelector) {
        this.name = name;
        this.place = Place.VALLE_INIZIALE;
        this.experience = 0;
        this.alive=true;
        this.oggetti=new LinkedList<>();
        this.money = 400;
        this.itemSelector = itemSelector;
    }
    public void toStringOggetti(){
        for (Item item : oggetti) {
            System.out.println(item);
        }
    }

    private void setnpc(){
        this.npc = true;
    }
    public int getLevell(){
        double a =0;
        int x = 1;
        while (true){
            a=this.experience-779-(((Math.pow(0.02*x,3))+(Math.pow(3.06*x,2))+(105.6*x))-895);
            x++;
            if(a<1){
                break;
            }
            a=0;
        }
        return x-2;
    }
    private void refillHealt(){
        this.health=this.maxHealth;
    }
    public void usaPozioneCura(String nome)  {
        for (Item item : oggetti) {
            if (item.getNome().equals(nome)){
                try {
                    if (this.health==this.maxHealth){
                        System.out.println("sei full vita è inutile che ti curi");
                        throw new FullHealtExp();
                    }
                    else {
                        if (item.getRarita()==Rarita.COMUNE) {
                            this.setHealth((float) (this.health + getMaxHealth()*0.2 * this.getLevell()));
                        }
                        if (item.getRarita()==Rarita.RARO) {
                            this.setHealth((float) (this.health + getMaxHealth()*0.4 * this.getLevell()));
                        }
                        if (item.getRarita()==Rarita.EPICO) {
                            this.setHealth((float) (this.health + getMaxHealth()*0.7 * this.getLevell()));
                        }
                    }
                } catch (DeadException e) {
                    System.out.println("non dovrebbe succedere ma è successo, ti sei levato vita con una cura uau");
                } catch (FullHealtExp e) {
                    return;
                }
                oggetti.remove(item);
                break;
            }
        }
    }
    public Weapon getPrimaryWeapon(){
        return armi.get(0);
    }
    public void setPrimaryWeapon(int indexNum){
        Weapon arma = armi.get(indexNum);
        armi.add(0,arma);
        armi.remove((indexNum+1));
    }
    public Ability getPrimaryAbility(){
        return abilita.get(0);
    }
    public void setPrimaryAbility(int indexNum){
        Ability ability = abilita.get(indexNum);
        abilita.add(0,ability);
        abilita.remove((indexNum+1));
    }
    @Override
    public boolean attack(Person attaccato, int count) throws DeadException {
        if (this.npc){
            double random = Math.random()*100;
            if (random <75){
                try {
                    attaccato.setHealth(((float) (attaccato.getHealth() - this.getPrimaryWeapon().getDamage() * attaccato.getPlace().getDifficolta())));
                } catch (FullHealtExp e) {
                    System.out.println("non dovrebbe succedere ma fullHealthExp su attacco");
                }
                System.out.println(this.getName()+"ti ha attaccato! e ti ha levato "+this.getPrimaryWeapon().getDamage()+" adesso hai "+attaccato.getHealth());
                return false;
            }
            try {
                attaccato.setHealth((float) (attaccato.getHealth() - this.getPrimaryAbility().getDamage() * attaccato.getPlace().getDifficolta()));
            } catch (FullHealtExp e) {
                System.out.println("non dovrebbe succedere ma fullHealthExp su abilità");
            }
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
                try {
                    attaccato.setHealth(attaccato.getHealth() - this.getPrimaryWeapon().getDamage());
                } catch (FullHealtExp e) {
                    System.out.println("non dovrebbe succedere ma sei riuscito a curare il nemico");
                }
                break;
            }
            if (inputString.equals("c")){
                if(count >= this.getPrimaryAbility().getCountdown()){
                    try {

                        attaccato.setHealth((float) (attaccato.getHealth() - this.getPrimaryAbility().getDamage() * attaccato.getPlace().getDifficolta()));
                        return true;
                    } catch (FullHealtExp e) {
                        System.out.println("non dovrebbe succedere ma hai curato il nemico con l abilità");
                    }
                }
                System.out.println("devi aspettare che il countdown della tua abilità finisca, mancano altri "+(this.getPrimaryAbility().getCountdown()-count)+" turni");
            }
        }
        if (attaccato.getHealth() <= 0) {
            attaccato.setAlive(false);
            throw new DeadException();
        }
        return false;
    }

    public int getExperience() {
        return experience;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public int getMoney() {
        return money;
    }

    private void addOggetto(Item oggetto) {
        this.oggetti.add(oggetto);
    }
    //metodo che serve per un combattimento,
    //spostare nella classe wrapper
    public void combattimento(Person b) throws IoDeadException {
        int aCount = 0;
        int bCount = 0;
        int bhealt = (int) b.getHealth();
        int counter = 2;
        int agilita1 = this.getAgility();
        int agilita2 = b.getAgility();
        while(this.isAlive() && b.isAlive()){
            // INSERIRE UN UNICA ECCEZIONE
            if (agilita1==counter){
                try {
                    boolean usedAbility = this.attack(b, aCount);
                    if (usedAbility){
                        aCount=0;
                    }
                    else{
                        aCount++;
                    }
                    agilita1 += this.getAgility();
                } catch (DeadException e) {
                    int a = this.getLevell();
                    double exp =this.experience+bhealt*getPlace().getDifficolta();
                    this.experience = (int) exp;
                    this.money = this.money+b.getMoney();

                    System.out.println("hai vinto e hai ricevuto "+exp+" punti exp e "+b.getMoney()+" monete");
                    if(a<this.getLevell()){
                        System.out.println("sei salito di livello ora sei livello "+ this.getLevell());
                    }
                    break;
                }
            }
            if (agilita2==counter){
                try {
                    boolean usedAbility = b.attack(this, bCount);
                    if (usedAbility){
                        bCount=0;
                    }
                    else{
                        bCount++;
                    }
                    agilita2 += b.getAgility();
                } catch (DeadException e) {
                    System.out.println("hai perso");
                    throw new IoDeadException();

                }
            }
            counter++;

        }
    }
    //metodo per potenziare l'arma, potrebbe servire l implementazione per potenziare altri oggetti tipo le pozioni curative
    public void upgrade(Item a){
        if (a.getTipo() == Tipo.ARMA) {
            try {
                for (Item item : oggetti) {
                    if (item == a) {
                        this.armi.set(0, new Weapon((this.getPrimaryWeapon().getDamage() * a.getRarita().getMoltiplicatore()),
                                this.getPrimaryWeapon().getDurability(), this.getPrimaryWeapon().getNome(), this.getPrimaryWeapon().getRarita()));
                        oggetti.remove(a);
                        return;
                    }
                }
                throw new NullPointerException();
            } catch (NullPointerException ex) {
                System.out.println("L' item selezionato non esiste oppure non lo possiedi");
            }
        }
        else{
            System.out.println("l item inserito non può upgradare l arma");
        }
    }
    private void pay(int amount) throws NotEnoughMoneyExc {
        if(this.money-amount <0){
            throw new NotEnoughMoneyExc();
        }
        this.money=this.money-amount;
    }
    //metodo explore, fa iterazioni casuali
    //aggiungere nuove interazioni ad esempio trovare un oggetto, miniboss, mercante -> implica l implementazione di una valuta di gioco
    //mettere un livello randomico ai npc in base al posto in cui si trovano
    public  void explore() throws DeadException {
        float seed = (float) Math.random()*100;
        if(!this.isAlive()){
            System.out.println("il tuo personaggio è morto non puoi esplorare");
            throw new DeadException();
        }
        else {
            if (seed < 35) {
                int a = (int) seed;
                if(a==0){
                    a=10;
                }if(a<7){
                    a=a+6;
                }
                List<Weapon> npcWeapons= new LinkedList<>();
                npcWeapons.add(new Weapon(a/2,55,"Arma del Babbuino", Rarita.COMUNE));
                Npc b = new Npc("Babbuino Finocchio",a,a/2,a*2,new Ability(a/2,"SpEcIaL",1),npcWeapons,a*2, new NpcItemSelector());
                System.out.println(b.getName());
                System.out.println("Hai incontrato "+b.getName()+" e ha "+b.getHealth()+" di vita, lo devi combattere");
                    try {
                        this.combattimento(b);
                        float seme = (float) Math.random() * 100;
                        while (seme > 50) {
                            if (seme<60){
                                this.armi.add(ItemManager.getInstance().getRandoMWeapon());
                            }
                           this.oggetti.add(ItemManager.getInstance().randomItem());

                            seme = (float) Math.random() * 100;
                        }
                    }catch (IoDeadException c) {
                        System.out.println("sei morto");
                    }
            }
            if (seed > 35 && seed <36){
                System.out.println("hai trovato mammt muort e patt impiccato");
            }
            if (seed > 36 && seed <60){
                    Scanner scanner = new Scanner(System.in);
                    String inputString = null;
                    Mercante mercante = new Mercante("Mercante", this.getLevell(), new MercanteItemSelector());
                    System.out.println("hai trovato un mercante! ");
                    System.out.println("questo mercante possiede questi oggetti: " + mercante.getOggetti());
                while(inputString == null ||!mercante.getOggetti().isEmpty()&& !inputString.equals("exit") ) {
                    System.out.println("cosa vuoi comprare? scrivi exit per uscire\n");
                    inputString = scanner.nextLine();
                    for (Item item : mercante.getOggetti()) {
                        if (inputString.equals(item.getNome())) {
                            try {
                                this.pay(item.getPriceOfItem());
                                this.oggetti.add(item);
                                mercante.oggetti.remove(item);
                                System.out.println("hai aggiunto al tuo inventario: "+ item +" per: "+item.getPriceOfItem());
                                System.out.println("questo mercante possiede questi oggetti: " + mercante.getOggetti());
                                break;
                            } catch (NotEnoughMoneyExc e) {
                                System.out.println("non hai abbastanza soldi per quest item");
                            }
                        }
                    }

                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Float.compare(getMaxHealth(), person.getMaxHealth()) == 0 && getMoney() == person.getMoney() && npc == person.npc && getExperience() == person.getExperience() && getAgility() == person.getAgility() && Float.compare(getHealth(), person.getHealth()) == 0 && isAlive() == person.isAlive() && Objects.equals(itemSelector, person.itemSelector) && getPlace() == person.getPlace() && Objects.equals(getOggetti(), person.getOggetti()) && Objects.equals(getName(), person.getName()) && Objects.equals(getAbilita(), person.getAbilita()) && Objects.equals(getArmi(), person.getArmi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemSelector, getMaxHealth(), getMoney(), npc, getExperience(), getPlace(), getOggetti(), getAgility(), getHealth(), getName(), getAbilita(), getArmi(), isAlive());
    }
}
