package ParkingLot.ParkingSpot;

import ParkingLot.Vehicle.*;

public class BikeSpot extends ParkingSpot{
    protected double baseCharge = 20;
    protected double chargePerHour = 15;

    public BikeSpot(int floorId, int spotId){
        super(VehicleType.BIKE, floorId, spotId);
    }

    public double getBaseCharge() {
        return this.baseCharge;
    }

    public void setBaseCharge(double baseCharge) {
        this.baseCharge = baseCharge;
    }

    public double getChargePerHour() {
        return this.chargePerHour;
    }

    public void setHourlyCharge(double chargePerHour) {
        this.chargePerHour = chargePerHour;
    }
}
