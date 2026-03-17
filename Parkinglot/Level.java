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

    public Level(int floor) {
        this.floor = floor;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
