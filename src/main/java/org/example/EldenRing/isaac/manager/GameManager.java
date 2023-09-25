package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.RoomNotValidExc;
import org.example.EldenRing.isaac.events.GameEventListner;
import org.example.EldenRing.isaac.Directions;
import org.example.EldenRing.isaac.Game;
import org.example.EldenRing.isaac.models.characters.MainCharacterPeppe;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.other.RoomCoordinates;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private RoomCoordinates pointerRoom;
    private Game gioco;

    private static GameManager instance = null;
    private GameManager() {
    }

    private List<GameEventListner> gameEventListners = new ArrayList<>();
    private List<GameEventListner> roomGameListners = new ArrayList<>();

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
        this.gioco = new Game(new MainCharacterPeppe("Peppe"));
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

}
