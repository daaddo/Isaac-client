package org.example.isaac.manager;

import org.example.isaac.events.CharactersEventListner;
import org.example.isaac.events.FightEventListner;
import org.example.isaac.gui.BattleFrame;
import org.example.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.type.Enemy;
import org.example.isaac.models.characters.type.Fightable;
import org.example.isaac.models.characters.type.MainUnit;
import org.example.isaac.models.characters.Target;

import java.util.*;

public class FightManager {

    private static FightManager instance = null;

    private FightManager() {
    }

    private Unit clickedUnit;
    private Unit currentUnit;
    private Map<MainUnit, Integer> allyAgilityMap = new HashMap();
    private Map<Enemy, Integer> enemyAgilityMap = new HashMap<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<MainUnit> allies = new ArrayList<>();
    private List<FightEventListner> fightEventListners = new ArrayList<>();
    private List<CharactersEventListner> charactersEventListners = new ArrayList<>();

    public static FightManager getInstance() {
        if (instance == null) {
            instance = new FightManager();
        }
        return instance;
    }

    public void reset() {
        for (MainUnit mainCharacter : allyAgilityMap.keySet()) {
            for (FightEventListner fightEventListner : fightEventListners) {
                fightEventListner.resetTarget(new Target(mainCharacter));
            }
        }
        for (Enemy enemy : enemyAgilityMap.keySet()) {
            for (FightEventListner fightEventListner : fightEventListners) {
                fightEventListner.resetTarget(new Target(enemy));
            }
        }
    }

    public void subscribeFightListner(FightEventListner fightEventListner) {
        this.fightEventListners.add(fightEventListner);
    }

    public <T extends Unit> Optional<Skill<T>> getCurrentSkillActive() {
        Optional<Skill<T>> interaction = Optional.empty();
        for (FightEventListner<T> fightEventListner : fightEventListners) {
            if (fightEventListner.isInteractionActive()) {
                interaction = fightEventListner.getActiveInteraction();
            }
        }
        return interaction;
    }

    public void unsubscribeFightListner(FightEventListner fightEventListner) {
        this.fightEventListners.remove(fightEventListner);
    }

    public void addEnemy(Enemy enemy) {
        this.enemyAgilityMap.put(enemy, enemy.getAgility());
        this.enemies.add(enemy);
    }

    public void addAlly(MainUnit ally) {
        this.allyAgilityMap.put(ally, ally.getAgility());
        this.allies.add(ally);
    }

    public void setClickedUnit(Unit unit) {
        this.clickedUnit = unit;
    }

    public Unit getClickedUnit() {
        return clickedUnit;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    public List<MainUnit> getAllies() {
        return allies;
    }

    public void highLightTarget(Skill.TargetType type) {
        switch (type) {
            case SELF -> {
                for (FightEventListner fightEventListner : fightEventListners) {
                    fightEventListner.setTarget(new Target(this.currentUnit));
                }
            }
            case ENEMY -> {
                for (Enemy enemy : enemyAgilityMap.keySet()) {
                    for (FightEventListner fightEventListner : fightEventListners) {
                        fightEventListner.setTarget(new Target(enemy));
                    }
                }
            }
            case DEAD -> {
            }
            case ALLYTEAM -> {
                for (MainUnit mainCharacter : allyAgilityMap.keySet()) {
                    for (FightEventListner fightEventListner : fightEventListners) {
                        fightEventListner.setTarget(new Target(mainCharacter));
                    }
                }
            }
            case ENEMYTEAM -> {
                for (FightEventListner fightEventListner : fightEventListners) {
                    for (Enemy enemy : enemyAgilityMap.keySet()) {
                        fightEventListner.setTarget(new Target(enemy));
                    }
                }
            }
            case ALL -> {
                for (MainUnit mainCharacter : allyAgilityMap.keySet()) {
                    for (FightEventListner fightEventListner : fightEventListners) {
                        fightEventListner.setTarget(new Target(mainCharacter));
                    }
                }
                for (FightEventListner fightEventListner : fightEventListners) {
                    for (Enemy enemy : enemyAgilityMap.keySet()) {
                        fightEventListner.setTarget(new Target(enemy));
                    }
                }
            }
        }

    }

    public void initializedMaps() {
        if (allyAgilityMap.isEmpty() || enemyAgilityMap.isEmpty()) {
            throw new NullPointerException("Maps are not initialized");
        }
    }

    public void setCurrentCharacter(Unit currentUnit) {
        this.currentUnit = currentUnit;
    }

    public Unit getCurrentCharacter() {
        return currentUnit;
    }

    public void giveTurn(Unit unit, Boolean isAlly) {
        for (FightEventListner fightEventListner : fightEventListners) {
            fightEventListner.getNextTurns(unit, isAlly);
        }
    }

    public HashMap<Unit, Boolean> getNextTurnCharacters() {
        initializedMaps();
        HashMap<Unit, Boolean> agilityOver100AndIsAllyMap = new HashMap<>();
        while (agilityOver100AndIsAllyMap.isEmpty()) {
            allyAgilityMap.forEach((key, value) -> {
                if (value >= 100) {
                    agilityOver100AndIsAllyMap.put(key, true);
                    allyAgilityMap.replace(key, value - 100);
                } else {
                    allyAgilityMap.replace(key, value + key.getAgility());
                }
            });
            enemyAgilityMap.forEach((key, value) -> {
                if (value >= 100) {
                    agilityOver100AndIsAllyMap.put(key, false);
                    enemyAgilityMap.replace(key, value - 100);
                } else {
                    enemyAgilityMap.replace(key, value + key.getAgility());
                }
            });
        }
        HashMap<Unit, Boolean> sortedMapByAgility = sortMap(agilityOver100AndIsAllyMap);
        sortedMapByAgility.forEach((key, value) -> System.out.println(key.getName() + "  " + value));
        return sortedMapByAgility;
    }

    public HashMap<Unit, Boolean> sortMap(HashMap<Unit, Boolean> toSort) {
        HashMap<Unit, Boolean> agilityOver100AndIsAllyMapAfterSort = new HashMap<>();
        for (Unit fightable : toSort.keySet()) {
            int max = 0;
            for (Unit fightable1 : toSort.keySet()) {
                if (fightable1.getAgility() > max) {
                    agilityOver100AndIsAllyMapAfterSort.put(fightable1, toSort.get(fightable1));
                }
            }
        }
        toSort = agilityOver100AndIsAllyMapAfterSort;
        return toSort;
    }


    public Boolean isAnyActive() {
        Boolean isAnyActive = false;
        for (FightEventListner fightEventListner : fightEventListners) {
            if (fightEventListner.isInteractionActive()) {
                isAnyActive = true;
            }
        }
        return isAnyActive;
    }

    public <T extends Unit> void callNextTurn() {
        List<FightEventListner> copy = new ArrayList<>();
        copy.addAll(fightEventListners);
        for (FightEventListner<T> fightEventListner : copy) {
            if (fightEventListner instanceof BattleFrame) {
                ((BattleFrame<T>) fightEventListner).goNextRound();
            }
        }
    }

    public void resetInteractions() {
        for (FightEventListner fightEventListner : fightEventListners) {
            if (fightEventListner instanceof BattleFrame battleFrame) {
                battleFrame.resetInteraction();
            }
        }
    }

    public void subscribePanelListner(CharactersEventListner characterPanel) {
        this.charactersEventListners.add(characterPanel);
    }

    public void setInteraction(Interaction<? extends Unit> interaction) {
        for (CharactersEventListner charactersEventListner : charactersEventListners) {
            charactersEventListner.setInteractionsCharacters(interaction);
        }
    }

    public <T extends Unit> void setInteractionToCharacter(Unit unit, Interaction<T> interaction) {
        if (!(interaction instanceof AttackInteraction<T>)) {
            List<? extends Unit> units = null;

            if (unit instanceof MainUnit) {
                units = allies;
            } else if (unit instanceof Enemy) {
                units = enemies;
            }

            if (units != null) {
                for (Iterator<? extends Unit> iterator = units.iterator(); iterator.hasNext();) {
                    Unit unitCurrent = iterator.next();
                    if (unitCurrent.equals(unit)) {
                        List<T> targets = new ArrayList<>();
                        targets.add((T) unitCurrent);
                        interaction.setTargets(targets);
                        unitCurrent.getActiveInteractions().add(interaction);
                        boolean use = interaction.use();
                        if (!use) {
                            iterator.remove();
                        }
                        break; // Assuming you only want to process one matching unit
                    }
                }
            }
        }
    }

    public <T extends Unit> void removeInteractionFromCharacter(T unit, Interaction<? extends Unit> activeInteraction) {
        List<? extends Unit> units = null;

        if (unit instanceof MainUnit) {
            units = allies;
        } else if (unit instanceof Enemy) {
            units = enemies;
        }

        if (units != null) {
            for (Iterator<? extends Unit> iterator = units.iterator(); iterator.hasNext();) {
                Unit currentUnit = iterator.next();
                if (currentUnit.equals(unit)) {
                    currentUnit.getActiveInteractions().remove(activeInteraction);
                    break; // Assuming you only want to process one matching unit
                }
            }
        }
    }
}
