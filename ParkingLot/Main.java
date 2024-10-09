package ParkingLot;
import ParkingLot.Vehicle.*;
/**
 * parkingLot
 */
public class  Main {
    public static void main(String[] args) {
        ParkingLot pl = ParkingLot.getInstance();
        pl.addFloor(10, 20, 10);

        for(int i=0;i<11;i++){
            String s = pl.bookSpot(VehicleType.BIKE);
            System.out.println(s);
        }

        System.out.println(pl.exitSpot(0, 0));
        System.out.println(pl.exitSpot(0, 1));

        System.out.println(pl.bookSpot(VehicleType.BIKE));
        System.out.println(pl.bookSpot(VehicleType.BIKE));
    }
}