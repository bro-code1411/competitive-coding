package lld.rental;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Runner {

    public static void main(String[]args){
        Vehicle v1 = new Vehicle(1,"swiftS", "UP14ABC1234", VehicleType.HATCHBACK,10);
        Vehicle v2 = new Vehicle(2,"swiftM", "UP14ABC1234", VehicleType.SEDAN,100);
        Vehicle v3 = new Vehicle(3,"swiftL", "UP14ABC1234", VehicleType.SUV,1000);
        Vehicle v4 = new Vehicle(4,"lambo", "UP14ABC1234", VehicleType.SEDAN,10000);
        Vehicle v5 = new Vehicle(5,"maruti", "UP14ABC1234", VehicleType.HATCHBACK,1);
        Vehicle v6 = new Vehicle(6,"tolo", "UP14A2C1234", VehicleType.HATCHBACK);
        HashMap<VehicleType, Integer> r1= new HashMap<>();
        r1.put(VehicleType.HATCHBACK, 200);
        r1.put(VehicleType.SEDAN,3000);
        r1.put(VehicleType.SUV,4000);
        RateCard rateCard1 = new RateCard(r1);
        HashMap<VehicleType, Integer> r2= new HashMap<>();
        r2.put(VehicleType.HATCHBACK, 200);
        r2.put(VehicleType.SEDAN,3000);
        r2.put(VehicleType.SUV,4000);
        RateCard rateCard2 = new RateCard(r1);
        Branch b1 = new Branch(1,"address1", rateCard1);


        VehicleRentalServiceImpl vehicleRentalService = new VehicleRentalServiceImpl();
        b1.addVehiclesList(Arrays.asList(v1,v2,v3,v4,v5));
        vehicleRentalService.addBranch(b1);

        Branch b2 = new Branch(1,"address2", rateCard2);
        b2.addVehiclesList(Arrays.asList(v6));
        vehicleRentalService.addBranch(b1);


        List<Vehicle> vehicleList = vehicleRentalService.displayAllVehicleInBranch(b1);
        System.out.println("All vehicles: "+vehicleList);

        Vehicle vv = vehicleRentalService.rentVehicle(0,3, VehicleType.SEDAN);
        System.out.println("Booked:"+ vv.toString());
        //Trying to book a sedan again should return a different vehicle
        Vehicle vv2 = vehicleRentalService.rentVehicle(1,2, VehicleType.SEDAN);
        System.out.println("Booked:"+vv2.toString());
        Vehicle vv3 = vehicleRentalService.rentVehicle(2,3, VehicleType.SEDAN);
        System.out.println("Booked:"+vv3.toString());

        vehicleRentalService.viewInventory(0, 1);

    }
}
