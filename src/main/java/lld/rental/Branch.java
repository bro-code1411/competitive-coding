package lld.rental;
import java.util.*;

public class Branch {

    private static final Integer DEFAULT_CAPACITY = 100;
    private int id;
    private String address;
    private List<Vehicle> vehicles = new ArrayList<>();
    private int capacity = DEFAULT_CAPACITY;
    private RateCard rateCard;

    private Map<VehicleType, Set<Vehicle>> vehicleTypeSetMap = new HashMap<>();

    public Branch(int id, String address, RateCard rateCard) {
        this.id = id;
        this.address = address;
        this.rateCard = rateCard;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setBranchId(this.id);
        vehicles.add(vehicle);
    }

    public void addVehiclesList(List<Vehicle> vehicles) {
        this.vehicles.addAll(vehicles);
        this.vehicles.stream().forEach(v -> v.setBranchId(this.id));
        this.vehicles.stream().filter(vehicle -> vehicle.getPrice()== null).forEach(v -> v.setPrice(rateCard.getRate(v.getType())));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public List<Vehicle> displayVehicle() {
        return vehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
