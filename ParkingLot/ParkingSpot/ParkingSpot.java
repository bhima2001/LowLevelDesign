package ParkingLot.ParkingSpot;
import java.time.Duration;
import java.time.LocalTime;

import ParkingLot.Vehicle.*;
import ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    protected Status spotStatus;
    protected VehicleType vehicleType;
    protected int floorId;
    protected int spotId;
    protected Vehicle currentVehicle;
    protected double baseCharge;
    protected double chargePerHour;
    protected LocalTime checkInTime;

    public ParkingSpot(VehicleType vehicleType, int floorId, int spotId) {
        this.vehicleType = vehicleType;
        this.floorId = floorId;
        this.spotId = spotId;
        this.spotStatus = Status.EMPTY;
        this.checkInTime = LocalTime.now();
    }

    public Status getStatus() {
        return spotStatus;
    }

    public void setStatus(Status spotStatus){
        this.spotStatus = spotStatus;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public int getFloorId() {
        return this.floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSpotId() {
        return this.spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public void resetCheckInTime() {
        this.checkInTime = LocalTime.now();
    }

    public double getBaseCharge() {
        return this.baseCharge;
    }

    public double getChargePerHour() {
        return this.chargePerHour;
    }

    public double calculateParkingCharge() {
        Duration totalTimeSpent = Duration.between(LocalTime.of(12, 50), this.checkInTime);
        long hours = totalTimeSpent.toHours();
        double baseCharge = getBaseCharge(), chargePerHour = getChargePerHour();
        if(hours < 1)return baseCharge;
        System.out.println(baseCharge);
        return baseCharge + (hours - 1) * chargePerHour;
    }
}
