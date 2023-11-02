package org.example.isaac;

import org.example.isaac.factory.OutOfMatrixException;
import org.example.isaac.factory.RoomsFactory;

public record RoomCoordinates(int row, int column) {


    public RoomCoordinates up() throws OutOfMatrixException {
        if (this.row ==0) {
            throw new OutOfMatrixException("up exception");
        }
        return new RoomCoordinates(this.row-1,this.column);
    }
    public RoomCoordinates right() throws OutOfMatrixException {
        if (this.column == RoomsFactory.MASSIMALE) {
            throw new OutOfMatrixException("right exception");
        }
        return new RoomCoordinates(this.row,this.column+1);
    }
    public RoomCoordinates down() throws OutOfMatrixException {
        if (this.row == RoomsFactory.MASSIMALE) {
            throw new OutOfMatrixException("down exception");
        }
        return new RoomCoordinates(this.row+1,this.column);
    }
    public RoomCoordinates left() throws OutOfMatrixException {
        if (this.column ==0) {
            throw new OutOfMatrixException("left exception");
        }
        return new RoomCoordinates(this.row,this.column-1);
    }
}
