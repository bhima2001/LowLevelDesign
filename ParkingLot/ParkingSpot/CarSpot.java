package ParkingLot.ParkingSpot;

import ParkingLot.Vehicle.VehicleType;

public class CarSpot extends ParkingSpot{
    protected double baseCharge = 20;
    protected double chargePerHour = 15;

    public CarSpot(int floorId, int spotId){
        super(VehicleType.CAR, floorId, spotId);
    }

    public double getBaseCharge() {
        return this.baseCharge;
    }

    public void setBaseCharge(double baseCharge) {
        this.baseCharge = baseCharge;
    }

    public double getHourlyCharge() {
        return this.chargePerHour;
    }

    public void setHourlyCharge(double chargePerHour) {
        this.chargePerHour = chargePerHour;
    }
}
