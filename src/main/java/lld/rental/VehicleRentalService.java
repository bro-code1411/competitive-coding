package lld.rental;

import java.util.List;

public interface VehicleRentalService {

    List<Vehicle> displayAllVehicleInBranch(Branch branch);

    void addBranch(Branch branch);

    List<Vehicle> viewInventory(int startTime, int endTime);

    Vehicle rentVehicle(int startTime, int endTime, VehicleType type);


}
