package lld.rental.booking.strategy;

import lld.rental.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BookingStrategyCache {
    BookingStrategy bookingStrategy = new LowestPriceBookingStrategy();

    private PriorityQueue<Vehicle> vehiclesPriorityQueue = new PriorityQueue<Vehicle>(100,bookingStrategy.getComparator());

    public List<Vehicle> sortVehicleBasedOnStrategy(BookingStrategy bookingStrategy, List<Vehicle> vehicles) {
        return new ArrayList(vehiclesPriorityQueue);
    }
}
