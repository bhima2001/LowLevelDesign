package ParkingLot.Vehicle;

 public abstract class Vehicle {
    protected String vehicleNumber;
    protected VehicleType vehicleType;

    protected Vehicle(String vehicleNumber, VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
