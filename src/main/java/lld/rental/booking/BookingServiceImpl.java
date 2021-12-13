package lld.rental.booking;

import lld.rental.Branch;
import lld.rental.Vehicle;
import lld.rental.VehicleType;
import java.util.*;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private Map<Integer, Map<Integer, Set<Vehicle>>> bookedVehicleMap = new HashMap<Integer, Map<Integer, Set<Vehicle>>>();

    private List<Branch> branches = new ArrayList<>();

    public boolean bookVehicle(int startTime, int endTime, Vehicle vehicle) {
        Set<Vehicle> bookedVehicles = new HashSet<>();
        int currentTime = startTime;

        while (currentTime < endTime) {
            if (bookedVehicleMap.get(vehicle.getBranchId()).get(currentTime).contains(vehicle)) {
                return false;
            }
            currentTime++;
        }
        currentTime = startTime;
        while (currentTime < endTime) {
            bookedVehicleMap.get(vehicle.getBranchId()).get(currentTime).add(vehicle);
            currentTime++;
        }
        return true;
    }

    public List<Vehicle> getAvailableVehicles(int startTime, int endTime, VehicleType type) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Branch branch : branches) {
            List<Vehicle> vehicleList = branch.getVehicles().stream().filter(vehicle -> vehicle.getType() == type).collect(Collectors.toList());

            Set<Vehicle> bookedVehicles = new HashSet<>();
            int currentTime = startTime;
            while (currentTime < endTime) {
                bookedVehicles.addAll(bookedVehicleMap.get(branch.getId()).get(currentTime));
                currentTime++;
            }
            availableVehicles.addAll(vehicleList.stream().filter(vehicle -> !bookedVehicles.contains(vehicle)).collect(Collectors.toList()));
        }
        return availableVehicles;
    }

    @Override
    public List<Vehicle> getAllAvailableVehicles(int startTime, int endTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Branch branch : branches) {
            List<Vehicle> vehicleList = branch.getVehicles();
            Set<Vehicle> bookedVehicles = new HashSet<>();
            int currentTime = startTime;
            while (currentTime < endTime) {
                bookedVehicles.addAll(bookedVehicleMap.get(branch.getId()).get(currentTime));
                currentTime++;
            }
            availableVehicles.addAll(vehicleList.stream().filter(vehicle -> !bookedVehicles.contains(vehicle)).collect(Collectors.toList()));
        }
        return availableVehicles;
    }


    @Override
    public void addBranch(Branch branch) {
        bookedVehicleMap.put(branch.getId(), getTimeDistributionVehicleMap());
        branches.add(branch);
    }

    private HashMap<Integer, Set<Vehicle>> getTimeDistributionVehicleMap() {
        HashMap<Integer, Set<Vehicle>> timeDistributionVehicleMap = new HashMap<Integer, Set<Vehicle>>();
        timeDistributionVehicleMap.put(0, new HashSet<>());
        timeDistributionVehicleMap.put(1, new HashSet<>());
        timeDistributionVehicleMap.put(2, new HashSet<>());
        timeDistributionVehicleMap.put(3, new HashSet<>());
        timeDistributionVehicleMap.put(4, new HashSet<>());
        timeDistributionVehicleMap.put(5, new HashSet<>());
        timeDistributionVehicleMap.put(6, new HashSet<>());
        timeDistributionVehicleMap.put(7, new HashSet<>());
        timeDistributionVehicleMap.put(8, new HashSet<>());
        timeDistributionVehicleMap.put(9, new HashSet<>());
        timeDistributionVehicleMap.put(10, new HashSet<>());
        timeDistributionVehicleMap.put(11, new HashSet<>());
        timeDistributionVehicleMap.put(12, new HashSet<>());
        timeDistributionVehicleMap.put(13, new HashSet<>());
        timeDistributionVehicleMap.put(14, new HashSet<>());
        timeDistributionVehicleMap.put(15, new HashSet<>());
        timeDistributionVehicleMap.put(16, new HashSet<>());
        timeDistributionVehicleMap.put(17, new HashSet<>());
        timeDistributionVehicleMap.put(18, new HashSet<>());
        timeDistributionVehicleMap.put(19, new HashSet<>());
        timeDistributionVehicleMap.put(20, new HashSet<>());
        timeDistributionVehicleMap.put(21, new HashSet<>());
        timeDistributionVehicleMap.put(22, new HashSet<>());
        timeDistributionVehicleMap.put(23, new HashSet<>());
        return timeDistributionVehicleMap;
    }
}
