package org.example.EldenRing.isaac.piano;

import org.example.isaac.piano.Piano;
import org.example.isaac.rooms.models.StarterRoom;
import org.example.isaac.RoomCoordinates;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//annotation to enable non static setup methods
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Disabled
class PianoTest {


    private int[][] roomMap;


    @BeforeAll
    void setUpClass(){
        this.roomMap = new int[][]{
                {0,0,1,1},
                {0,0,1,1},
                {0,1,2,1},
                {0,0,1,1}
        };
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRoomFactory() {
    }

    @Test
    void isRoomExistingAt() {
        StarterRoom sr = new StarterRoom(1, new RoomCoordinates(2,2));
        Piano piano = new Piano(sr, roomMap);
        boolean roomExistingAt = piano.isRoomExistingAt(new RoomCoordinates(3,3));
        assertTrue(roomExistingAt, "In realtà la stanza esiste");

        boolean roomNotExistingAt = piano.isRoomExistingAt(new RoomCoordinates(0,0));
        assertTrue(roomNotExistingAt, "In realtà la stanza NON esiste");

        boolean result1 = piano.isRoomExistingAt(new RoomCoordinates(-1,-1));
        assertFalse(result1);
        assertDoesNotThrow(() -> piano.isRoomExistingAt(new RoomCoordinates(-1,-1)));

        boolean result2 = piano.isRoomExistingAt(new RoomCoordinates(3,7));
        assertTrue(result2);

        boolean result3 = piano.isRoomExistingAt(new RoomCoordinates(7,3));
        assertTrue(result3);



    }



    @Test
    void getNumero() {
    }

    @Test
    void getRoomMap() {
    }

    @Test
    void getStarterRoom() {
    }
}