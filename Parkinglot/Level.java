package Parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    public List<ParkingSpot> getAvailableSpots() {
        return parkingSpots;
    }
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        return null;
    }
}
