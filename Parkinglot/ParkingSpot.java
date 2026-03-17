package Parkinglot;

public class ParkingSpot {
    private int spotId;
    private string spotType;
    private boolean isAvailable;
    private vehicle parkedVehicle;
    public isavailable() {
        return isAvailable;
    }
    public canfitVehicle(Vehicle vehicle) {
        return boolean;
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
