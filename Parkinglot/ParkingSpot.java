package Parkinglot;

public class ParkingSpot {
    private int spotId;
    private String spotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;
    public boolean isAvailable() {
        return isAvailable;
    }
    public boolean canfitVehicle(Vehicle vehicle) {
        return true;
    }
    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }
    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }
}
