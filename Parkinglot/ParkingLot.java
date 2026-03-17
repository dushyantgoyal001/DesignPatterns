package Parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels = new ArrayList<>();
    public addLevel(Level level) {
        levels.add(level);
    }
    public findSpot(VehicleType vechicleType) {
        return ParkingSpot;
    }
    public parkVehicle(Vehicle vehicle){
        return Ticket;
    }
    public freeSpot(Ticket ticket) {

    }
}
