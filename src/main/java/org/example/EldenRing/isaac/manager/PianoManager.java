package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.exceptions.Nullexp;
import org.example.EldenRing.isaac.factory.RoomsFactory;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.rooms.prizeBehaviour.ShopRoom;
import org.example.EldenRing.other.RoomCoordinates;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.List;

public class PianoManager {
    private static PianoManager instance = null;
    private Piano currentpiano;

    private List<Room> planimetria = new ArrayList<>();

    private PianoManager() {
    }

    public static PianoManager getInstance() {
        if (instance == null) {
            instance = new PianoManager();
        }
        return instance;
    }

    public void loadPiano(Piano piano) {
        this.currentpiano = piano;
        int[][] roomMap = this.currentpiano.getRoomMap();
        for (int i = 0; i < RoomsFactory.MASSIMALE; i++) {
            for (int j = 0; j < RoomsFactory.MASSIMALE; j++) {
                if (roomMap[i][j] == 1) {
                    double random = Math.random();
                }
            }
        }
    }

    public List<Room> getAllRooms() {
        throw new UnsupportedOperationException();
        //pianonotloaded exception se loadPiano NON è stato chiamato
    }

    public Room getBossRoom() {
        throw new UnsupportedOperationException();

    }

    public Room getShopRoom() throws Nullexp {
        for (Room allSavedRooms : planimetria) {
            if (allSavedRooms instanceof ShopRoom) {
                return allSavedRooms;
            }
        }
        throw new Nullexp();
    }
    public List<Room> getNextRooms(Room room) {
        throw new UnsupportedOperationException();
    }

    public Room getRoomAt(RoomCoordinates coords) throws KeyException {
        if (!this.currentpiano.isRoomExistingAt(coords)) {
            throw new KeyException();
        }
        for (Room room : planimetria) {
            if (room.getCoords().row() == coords.row() && room.getCoords().column() == coords.column()) {
                return room;
            }
        }
        Room room = this.currentpiano.getRoomFactory(coords).createRoom(coords);
        this.planimetria.add(room);
        return room;
    }
    public void getRoomMethod(RoomCoordinates coords) throws KeyException {
        Room roomAt = getRoomAt(coords);

    }

}

