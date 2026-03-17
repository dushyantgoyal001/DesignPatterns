package Parkinglot;

public class ParkingSpot {
    private int spotId;
    private String spotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;
    public isavailable() {
        return isAvailable;
    }
    public boolean canfitVehicle(Vehicle vehicle) {
        return true;
    }
    public assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }
    public removeVehicle() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }
}
