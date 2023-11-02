package org.example.isaac.factory;

import org.example.isaac.rooms.models.Room;
import org.example.isaac.rooms.models.StarterRoom;
import org.example.isaac.RoomCoordinates;

import java.util.ArrayList;
import java.util.List;

public class RoomsFactory {
    public static final int MASSIMALE = 15 ;
    public static final int MAXROOMS = 25;




    private boolean isRoomSpotFree(int [][] matrix, int i, int j){
        try {
            return matrix[i][j] == 0;
        }catch (ArrayIndexOutOfBoundsException e){
            // System.out.println(" out of bounds");
            return false;
        }

    }

    
    public List<RoomCoordinates> getNearRooms(int[][] matrix, RoomCoordinates target){
        List<RoomCoordinates> rooms= new ArrayList<>();

        if(target.column() < MASSIMALE && isRoomSpotFree(matrix, target.row(), target.column()+1)){
            //non sono attaccato al bordo destro
            rooms.add(new RoomCoordinates(target.row(), target.column()+1));
        }
        if(target.row()<MASSIMALE && isRoomSpotFree(matrix, target.row()+1, target.column())) {
            //non sono schiacciato in fondo
            rooms.add(new RoomCoordinates(target.row() + 1, target.column()));
        }
        if(target.row()-1>=0 && isRoomSpotFree(matrix, target.row()-1, target.column())) {
            //non sono schiacciato al bordo sinistro
            rooms.add(new RoomCoordinates(target.row() - 1, target.column()));
        }
        if(target.column()-1>=0 && isRoomSpotFree(matrix, target.row(), target.column()-1)) {
            //non sono schiacciato sopra
            rooms.add(new RoomCoordinates(target.row() , target.column()- 1));
        }
        if (rooms.isEmpty()) {
            System.out.println("log");
        }
        return rooms;
    }
    public static boolean isRoomSpotFreeClass(Room[][] matrix, int row, int column){
        try {
            return matrix[row][column] != null;
        }catch (ArrayIndexOutOfBoundsException e){
            // System.out.println(" out of bounds");
            return false;
        }
    }
    /*public static List<Room> getNearRoomsClass(Room[][] matrix, RoomCoordinates target){
        List<Room> rooms = new ArrayList<>();
        if(matrix[target.row()-1][target.column() ] == null && !(isRoomSpotFreeClass(matrix, target.row()-1, target.column()))){
            rooms.add(null);
        }
        else{
            rooms.add(matrix[target.row()-1][target.column()] );
        }

        if(matrix[target.row()][target.column()+1] == null && !(isRoomSpotFreeClass(matrix, target.row(), target.column()+1))){
            rooms.add(null);
        }
        else{
            rooms.add(matrix[target.row()][target.column()+1]);
        }

        if(matrix[target.row()+1][target.column()] == null && !(isRoomSpotFreeClass(matrix, target.row()+1, target.column()))){
            rooms.add(null);
        }
        else{
            rooms.add(matrix[target.row()+1][target.column()]);
        }

        if(matrix[target.row()][target.column()-1] == null && !(isRoomSpotFreeClass(matrix, target.row(), target.column()-1))){
            rooms.add(null);
        }
        else{
            rooms.add(matrix[target.row()][target.column()-1]);
        }
        return rooms;
    }*/

    public List<RoomCoordinates> getAllRooms(int[][] rooms){
        List<RoomCoordinates> allCoords = new ArrayList<>();
        for (int i = 0; i < MASSIMALE; i++) {
            for (int j = 0; j < MASSIMALE; j++) {
                if(rooms[i][j] ==1){
                    allCoords.add(new RoomCoordinates(i,j));
                }
            }
        }
        return allCoords;
    }
    public boolean occupy(int [][] matrix, RoomCoordinates roomCoordinates){
        boolean wasfree = isRoomSpotFree(matrix,roomCoordinates.row(),roomCoordinates.column());
        matrix[roomCoordinates.row()][roomCoordinates.column()] = 1;
        return wasfree;
    }
    public RoomCoordinates getRandomRoom(int [][] matrix){
        List<RoomCoordinates> allRooms = getAllRooms(matrix);
        RoomCoordinates roomCoordinates = allRooms.stream()
                .skip((int) (allRooms.size() * Math.random()))
                .findFirst().get();
        System.out.println(roomCoordinates);
        return roomCoordinates;
    }
    public int[][] matrixOfRooms() {
        int randomRoomsNumber = MASSIMALE;
        System.out.println(randomRoomsNumber);
        int[][] floor = new int[randomRoomsNumber][randomRoomsNumber];
        int centerRow = MASSIMALE /2;
        int centerCol = MASSIMALE /2;
        floor[centerRow][centerCol]=1;

        // questa parte setta tutte le celle adiacenti come occupate
        RoomCoordinates top = new RoomCoordinates(centerRow-1,centerCol);
        RoomCoordinates down = new RoomCoordinates(centerRow+1,centerCol);
        RoomCoordinates left = new RoomCoordinates(centerRow,centerCol-1);
        RoomCoordinates right = new RoomCoordinates(centerRow,centerCol+1);

        List<RoomCoordinates> nextRooms = new ArrayList<>();
        nextRooms.add(top);
        nextRooms.add(down);
        nextRooms.add(left);
        nextRooms.add(right);

        for (RoomCoordinates nextRoom : nextRooms) {
            occupy(floor,nextRoom);
        }

        List<RoomCoordinates> adjacentRooms = new ArrayList<>();

        int totalRoom = 5;
        boolean running = true;
        while(running) {

            for (RoomCoordinates nextRoom : nextRooms) {
                if (!running){
                    break;
                }
                List<RoomCoordinates> nearRooms = getNearRooms(floor, nextRoom);
                if (nearRooms.isEmpty()){
                    RoomCoordinates randomRoom = getRandomRoom(floor);
                    nearRooms.addAll(getNearRooms(floor, randomRoom));
                }
                for (RoomCoordinates adjacentRoom : nearRooms) {
                    int random = (int) (Math.random() * 5 + 1);
                    if (Math.random() < (double) random /10) {
                        boolean wasFree = occupy(floor, adjacentRoom);
                        if(wasFree){
                            adjacentRooms.add(adjacentRoom);
                            totalRoom++;
                            if (totalRoom>=MAXROOMS){
                                running =false;
                                break;
                            }
                        }
                    }
                }
            }
            if(!adjacentRooms.isEmpty()){
                nextRooms.clear();
                nextRooms.addAll(adjacentRooms);
                adjacentRooms.clear();
            }
        }

        //END

        //set starter room to 2
        floor[centerRow][centerCol] = 2;

        return floor;
    }
}
