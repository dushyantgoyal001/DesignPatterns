package Parkinglot;

public class ParkingSpot {
    private int spotId;
    private String spotType;
    private boolean isAvailable;

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    private Vehicle parkedVehicle;
    public boolean canfitVehicle(Vehicle vehicle) {
        if(!isAvailable) {
            return false;
        }
        if(spotType.equals("COMPACT") && vehicle.getVehicleType() == VehicleType.CAR) {
            return true;
        }        if(spotType.equals("LARGE") && (vehicle.getVehicleType() == VehicleType.TRUCK || vehicle.getVehicleType() == VehicleType.TRUCK)) {
            return true;
        }        if(spotType.equals("MOTORCYCLE") && vehicle.getVehicleType() == VehicleType.MOTORCYCLE) {
            return true;
        }
        return true;
    }

    public ParkingSpot(int spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
        parkedVehicle = null;
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
