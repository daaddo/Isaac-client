package org.example.EldenRing.isaac.models.bosses;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.other.Rarita;
import org.example.EldenRing.other.Weapon;

public class Godrick extends Boss{


    public Godrick(Piano piano) {
        super("Godrick", 100, 100, new FightingBehaviour() {
            @Override
            public void fight(int piano) {

            }
        });
        weapon = new Weapon(15,200,"ArkJhuorg", Rarita.EPICO);
        prepare(piano);
    }

    @Override
    protected void prepare(Piano piano) {
        this.maxHealth = this.maxHealth+(this.maxHealth*(piano.getNumero()/3));
        this.weapon = new Weapon(this.weapon.getDamage()+(this.weapon.getDamage()*(piano.getNumero()/3)),
                this.weapon.getDurability(),
                this.weapon.getNome(),
                this.weapon.getRarita());
        this.actualHealth = this.maxHealth;
    }


    @Override
    public int getValue() {
        return 0;
    }
}
