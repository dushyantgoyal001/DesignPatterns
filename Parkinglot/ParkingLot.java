package Parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels = new ArrayList<>();
    public void addLevel(Level level) {
        levels.add(level);
    }
    public ParkingSpot findSpot(VehicleType vehicleType) {
        return null;
    }
    public Ticket parkVehicle(Vehicle vehicle) {
        return null;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void freeSpot(Ticket ticket) {

    }
}
