package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.events.FightEventListner;
import org.example.EldenRing.isaac.events.GameEventListner;
import org.example.EldenRing.isaac.Game;
import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;
import org.example.EldenRing.other.RoomCoordinates;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Character character;
    private RoomCoordinates pointerRoom;
    private Game gioco;

    private static GameManager instance = null;
    private boolean isFighting = false;

    private GameManager() {
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    private List<GameEventListner> gameEventListners = new ArrayList<>();
    private List<GameEventListner> roomGameListners = new ArrayList<>();
    private List<FightEventListner> fightEventListners = new ArrayList<>();

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void insertCharacter(Character character){
        for (GameEventListner gameEventListner : gameEventListners) {
            gameEventListner.selectCharacter(character);
        }
    }
    public synchronized void startGame(){
        this.gioco = new Game(this.character);
        System.out.println(gioco.getPiano().getStarterRoom().getCoords());
        this.pointerRoom = gioco.getPiano().getStarterRoom().getCoords();
        PianoManager.getInstance().loadPiano(gioco.getPiano());
        for (GameEventListner gameEventListner : gameEventListners) {
            gameEventListner.newGame(gioco.getPiano());
        }
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

    public boolean isFighting() {
        return isFighting;
    }
    public void setFighting(boolean bool){
        this.isFighting = bool;
    }

    public void giveTurn(Fightable fightable, boolean b) {
        for (FightEventListner fightEventListner : fightEventListners) {
            
        }
    }
}
