package ParkingLot;
import java.util.ArrayList;
import ParkingLot.Vehicle.*;
import ParkingLot.ParkingSpot.Floor;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private final ArrayList<Floor> floors;

    private ParkingLot(){
        floors = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if(parkingLot == null){
            parkingLot= new ParkingLot();
        }
        return parkingLot;
    }

    public void addFloor(int bikeCount, int carCount, int truckCount) {
        floors.add(new Floor(floors.size(), bikeCount, carCount, truckCount));
    }

    public Boolean checkParkingLotAvailability(VehicleType vehicleType) {
        for(int i=0;i<floors.size();i++){
            if(floors.get(i).checkAvailability(vehicleType)){
                return true;
            }
        }
        return false;
    }

    public String bookSpot(VehicleType vehicleType) {
        for(int i=0; i<this.floors.size(); i++){
            String status = floors.get(i).allocateEmptySpot(vehicleType);
            if(status != "false"){
                return status;
            }
        }
        return "No "+ vehicleType +" Spot Avaliable";
    }

    public String exitSpot(int floorId, int spotId) {
        return this.floors.get(floorId).deallocateSpot(spotId);
    }

    // public double getTicketCharge() {

    // }
}