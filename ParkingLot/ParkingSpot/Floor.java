package ParkingLot.ParkingSpot;

import java.util.ArrayList;
import ParkingLot.Vehicle.*;

public class Floor {
    protected int floorNumber;
    protected ArrayList<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, int bikeSpots, int carSpots, int truckSpots){
        this.floorNumber = floorNumber;
        int count = 0;
        this.parkingSpots = new ArrayList<ParkingSpot>(bikeSpots + carSpots + truckSpots);
        for(int i=0; i<bikeSpots; i++){
            this.parkingSpots.add(new BikeSpot(floorNumber, count++));
        }
        for(int  i=0; i<carSpots; i++){
            this.parkingSpots.add(new CarSpot(floorNumber, count++));
        }
        for(int i=0; i<truckSpots; i++){
            this.parkingSpots.add(new TruckSpot(floorNumber, count++));
        }
    }

    public Boolean checkAvailability(VehicleType vehicleType){
        for(int i=0;i<this.parkingSpots.size();i++){
            if(this.parkingSpots.get(i).getVehicleType() == vehicleType && this.parkingSpots.get(i).getStatus() == Status.EMPTY){
                return true;
            }
        }
        return false;
    }

    public String allocateEmptySpot(VehicleType vehicleType) {
        if(this.checkAvailability(vehicleType) == false)return "false";
        int spot = 0;
        for(int i=0;i<this.parkingSpots.size();i++){
            if(this.parkingSpots.get(i).getVehicleType() == vehicleType && this.parkingSpots.get(i).getStatus() == Status.EMPTY){
                spot = i;
                this.parkingSpots.get(i).setStatus(Status.OCCUPIED);
                break;
            }
        }
        return "Floor: "+ this.floorNumber + " Spot: "+ spot;
    }

    public String availabilityOfFloor() {
        String output = "Floor: " + this.floorNumber;
        for(int i=0;i<this.parkingSpots.size();i++){
            output+=(i + " ");
        }
        return output;
    }

    public String deallocateSpot(int spotNumber) {
        if(this.parkingSpots.size() > spotNumber && spotNumber >= 0){
            if(parkingSpots.get(spotNumber).getStatus() ==  Status.OCCUPIED){
                parkingSpots.get(spotNumber).setStatus(Status.EMPTY);
                double charge = parkingSpots.get(spotNumber).calculateParkingCharge();
                parkingSpots.get(spotNumber).resetCheckInTime();
                return "The spot is deallocated and Your charge is: Rs." + charge;
            }
        }
        return "Spot is already empty";
    }

}