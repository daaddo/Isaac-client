package org.example.EldenRing.isaac.piano;

import org.example.EldenRing.isaac.factory.NormalPrizeRoomFactory;
import org.example.EldenRing.isaac.rooms.Factory.RoomFactory;
import org.example.EldenRing.isaac.rooms.models.StarterRoom;
import org.example.EldenRing.other.RoomCoordinates;

public class Piano {
    private StarterRoom starterRoom;
    private static int numero;
    private  int[][] roomMap;

    public Piano(StarterRoom starterRoom, int[][] roomMap) {
        numero++;
        this.starterRoom = starterRoom;
        this.roomMap = roomMap;
    }
    public RoomFactory getRoomFactory(RoomCoordinates coords){
        //TODO ci devo mettere tutta la logica per capire quale factory restituire
        return new NormalPrizeRoomFactory();
    }

    /**
     * <b>isRoomExisting at</b> is an <font color = red>important</font> method
     * <img src="https://essereuomo.it/wp-content/uploads/2021/10/sdsdsd.jpg">
     * @param coords
     * @return  <p style="color: blue; font-size: 16px; font-family: Arial; font-weight: 900;"> Asdrubale</p>
     */
    public boolean isRoomExistingAt(RoomCoordinates coords){
        return roomMap[coords.row()][coords.column()] == 1;
    }

    public static int getNumero() {
        return numero;
    }

    public  int[][] getRoomMap() {
        return this.roomMap;
    }

    public StarterRoom getStarterRoom() {
        return starterRoom;
    }

    /**
     * @throws IllegalArgumentException when a starter room is not surrounded by rooms to all sides
     */

}
