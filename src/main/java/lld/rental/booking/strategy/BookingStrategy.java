package lld.rental.booking.strategy;

import lld.rental.Vehicle;

import java.util.Comparator;
import java.util.List;

public interface BookingStrategy {
    List<Vehicle> sortVehicleBasedOnStrategy(List<Vehicle> vehicles);

    Comparator getComparator();
}
