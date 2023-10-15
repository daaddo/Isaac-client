package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.rooms.models.StarterRoom;
import org.example.EldenRing.isaac.RoomCoordinates;

import java.util.ArrayList;
import java.util.List;

public class RoomsFactory {
    public static final int MASSIMALE = 15 ;
    public static final int MAXROOMS = 25;

    private int numberOfRoomsByRow(int[] a){
        int count = 0;
        for (int i=0; i<a.length;i++) {
            if (a[i] == 1){
                count++;
            }
        }
        return count;
    }
    private  void cleanUp(int[][] toClean){
        for (int i = 0; i < toClean.length; i++){
            int a =(numberOfRoomsByRow(toClean[i]));
            while (a>4){
                int v = (int) (Math.random() * toClean.length);
                toClean[i][v] = 0;
                toClean[v][i] = 0;
                a =(numberOfRoomsByRow(toClean[i]));
            }
        }
    }

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
    public static List<Room> getNearRoomsClass(Room[][] matrix, RoomCoordinates target){
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
    }

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
        int center_row = MASSIMALE /2;
        int center_col = MASSIMALE /2;
        floor[center_row][center_col]=1;
        //setta tutte le celle adiacenti come occupate
        RoomCoordinates top = new RoomCoordinates(center_row-1,center_col);
        RoomCoordinates down = new RoomCoordinates(center_row+1,center_col);
        RoomCoordinates left = new RoomCoordinates(center_row,center_col-1);
        RoomCoordinates right = new RoomCoordinates(center_row,center_col+1);

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
                    System.out.println("re capì?");
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
        floor[center_row][center_col] = 2;
/*

        for (int i = 0; i < MASSIMALE; i++) {
            for (int j = 0; j<MASSIMALE; j++){

                int roomNumber = floor[i][j];
                System.out.print(roomNumber+"  ");
            }
            System.out.println();
        }*/

        return floor;
    }
    public void stampaMatrice(int[][] matrice){
        for (int i = 0; i < MASSIMALE; i++) {
            for (int j = 0; j<MASSIMALE; j++){

                int roomNumber = matrice[i][j];
                System.out.print(roomNumber+"  ");
            }
            System.out.println();
        }
    }
    public static int count(int[][] matrix){
        int count = 0;
        for (int i = 0; i < MASSIMALE; i++) {
            for (int j = 0; j < MASSIMALE; j++) {
                if(matrix[i][j] ==1){
                    count++;
                }
            }
        }
        return count;
    }
    /*public static Room[][] subsitute(int[][] matrix){
        Room[][] matrixOfRooms = new Room[MASSIMALE][MASSIMALE];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]==1){
                    double random = Math.random();
                    if (random<0.35) {
                        matrixOfRooms[i][j] = new NormalPrizeRoomFactory().createRoom(new RoomCoordinates(i,j));
                    }
                    if (random >=0.35 ) {
                        matrixOfRooms[i][j] = new FightingRoomFactory().createRoom(new RoomCoordinates(i,j));
                    }

                }
                else{
                    matrixOfRooms[i][j] = null;
                }
                if(matrix[i][j]==2){
                    matrixOfRooms[i][j] = new StarterRoomFactory().createRoom(new RoomCoordinates(i,j));
                }
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
        for (int j = 0; j < MASSIMALE; j++) {
            for (int k = 0; k < MASSIMALE; k++) {
                if (matrixOfRooms[j][k] !=null ){
                    matrixOfRooms[j][k].addNearRooms();
                }
            }
        }
        System.out.println("\n");
        return matrixOfRooms;
    }*/
    public static void toStringMatrix(Room[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null){
                    System.out.print(0+"  ");
                }
                if (matrix[i][j] != null && !(matrix[i][j] instanceof StarterRoom)) {

                    System.out.print(1+"  ");
                }
                if(matrix[i][j] instanceof StarterRoom){
                    System.out.print(2+"  ");
                }
            }
            System.out.println();
        }
    }
}
