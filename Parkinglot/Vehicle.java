package Parkinglot;

public abstract class  Vehicle {
    private String licensePlate;
    private String vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType.name();
    }
}
