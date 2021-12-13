package lld.rental.booking;

import lld.rental.Branch;
import lld.rental.Vehicle;
import lld.rental.VehicleType;
import java.util.List;

public interface BookingService {


    boolean bookVehicle(int startTime, int endTime, Vehicle vehicle);

    void addBranch(Branch branch);

    List<Vehicle> getAvailableVehicles(int startTime, int endTime, VehicleType type);

    List<Vehicle> getAllAvailableVehicles(int startTime, int endTime);
}
