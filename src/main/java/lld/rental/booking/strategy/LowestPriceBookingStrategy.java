package lld.rental.booking.strategy;

import lld.rental.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LowestPriceBookingStrategy implements BookingStrategy{
    @Override
    public List<Vehicle> sortVehicleBasedOnStrategy(List<Vehicle> vehicles) {
        return vehicles.stream()
                .sorted(Comparator.comparingInt(vehicle -> vehicle.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Comparator getComparator() {
        class VehicleComparator implements Comparator<Vehicle>{

            // Overriding compare()method of Comparator
            // for acs order of price
            public int compare(Vehicle s1, Vehicle s2) {
                if (s1.getPrice() > s2.getPrice())
                    return 1;
                else if (s1.getPrice() < s2.getPrice())
                    return -1;
                return 0;
            }
        }
        return new VehicleComparator();
    }


}
