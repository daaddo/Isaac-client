package org.example.isaac.manager;

import org.example.isaac.events.FightEventListner;
import org.example.isaac.events.GameEventListner;
import org.example.isaac.Game;
import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.type.MainUnit;
import org.example.isaac.RoomCoordinates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameManager <T extends Unit> {
    private List<MainUnit> characters = new LinkedList<>();
    private RoomCoordinates pointerRoom;
    private Game gioco;
    private static GameManager instance = null;
    private boolean isFighting = false;
    private List<GameEventListner> gameEventListners = new ArrayList<>();
    private List<GameEventListner> roomGameListners = new ArrayList<>();
    private List<FightEventListner<? extends Unit>> fightEventListners = new ArrayList<>();

    private GameManager() {
    }

    public List<MainUnit> getCharacter() {
        return this.characters;
    }

    public void setCharacter(List<MainUnit> character) {
        this.characters = character;
    }



    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void insertCharacter(List<MainUnit> character){
        for (GameEventListner gameEventListner : gameEventListners) {
            gameEventListner.selectCharacter(character);
        }
    }
    public synchronized void startGame(){
        this.gioco = new Game(this.characters);
        System.out.println(gioco.getPiano().getStarterRoom().getCoords());
        this.pointerRoom = gioco.getPiano().getStarterRoom().getCoords();
        PianoManager.getInstance().loadPiano(gioco.getPiano());
        for (GameEventListner gameEventListner : gameEventListners) {
            gameEventListner.newGame(gioco.getPiano());
        }
    }
    public void addCharacter(MainUnit character){
        this.characters.add(character);
}
    public void teleport(RoomCoordinates coordinates){
        for (GameEventListner gameEventListner : roomGameListners) {
                gameEventListner.move(coordinates);
                this.pointerRoom=coordinates;
        }
    }


    public boolean isMoveValid(RoomCoordinates roomCoordinates){
        if (roomCoordinates.row()==this.pointerRoom.row()-1 &&roomCoordinates.column()==this.pointerRoom.column()) {
            return true;
        }
        if (roomCoordinates.row()==this.pointerRoom.row()+1 &&roomCoordinates.column()==this.pointerRoom.column()) {
            return true;
        }
        if (roomCoordinates.row()==this.pointerRoom.row() &&roomCoordinates.column()==this.pointerRoom.column()-1) {
            return true;
        }
        if (roomCoordinates.row()==this.pointerRoom.row() &&roomCoordinates.column()==this.pointerRoom.column()+1) {
            return true;
        }
        return false;

    }


    public void subscribeGameListner(GameEventListner gameListner){
        this.gameEventListners.add(gameListner);
    }

    public void subscribe4Rooms(GameEventListner gameListner){
        this.roomGameListners.add(gameListner);
    }

    public void unsubscribeGameListner(GameEventListner gameListner){
        this.gameEventListners.remove(gameListner);
    }
    public void subscribeFightListner(FightEventListner fightEventListner){
        this.fightEventListners.add(fightEventListner);
    }
    public boolean isFighting() {
        return isFighting;
    }
    public void setFighting(boolean bool){
        this.isFighting = bool;
    }

    public void giveTurn(T character, Boolean isAlly) {
        for (FightEventListner fightEventListner : fightEventListners) {
            fightEventListner.getNextTurns(character, isAlly);
        }
    }

}
