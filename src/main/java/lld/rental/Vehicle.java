package lld.rental;

import java.util.Objects;

public class Vehicle {

    private int id;
    private String name;
    private String plateNumber;
    private VehicleType type;
    private Integer price;
    private int branchId ;

    public Vehicle(int id, String name, String plateNumber, VehicleType type, int price) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.type = type;
        this.price = price;
    }
    public Vehicle(int id, String name, String plateNumber, VehicleType type) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id &&
                price == vehicle.price &&
                Objects.equals(name, vehicle.name) &&
                Objects.equals(plateNumber, vehicle.plateNumber) &&
                type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, plateNumber, type, price);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", branchId=" + branchId +
                '}';
    }
}
