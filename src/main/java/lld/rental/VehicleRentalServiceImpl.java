package lld.rental;

import lld.rental.booking.BookingService;
import lld.rental.booking.BookingServiceImpl;
import lld.rental.booking.strategy.BookingStrategy;
import lld.rental.booking.strategy.BookingStrategyCache;
import lld.rental.booking.strategy.LowestPriceBookingStrategy;


import java.util.List;


public class VehicleRentalServiceImpl implements VehicleRentalService {

    private BookingService bookingService = new BookingServiceImpl();
    private BookingStrategy bookingStrategy = new LowestPriceBookingStrategy();

    private BookingStrategyCache bookingStrategyCache = new BookingStrategyCache();

    public Vehicle rentVehicle(int startTime, int endTime, VehicleType type) {
        List<Vehicle> availableVehicles = bookingService.getAvailableVehicles(startTime, endTime, type);

        // Enable Cache
        //List<Vehicle> sortedVehiclesBasedOnStrategy = bookingStrategyCache.sortVehicleBasedOnStrategy(bookingStrategy, availableVehicles);

        List<Vehicle> sortedVehiclesBasedOnStrategy = bookingStrategy.sortVehicleBasedOnStrategy(availableVehicles);
        for (Vehicle vehicle : sortedVehiclesBasedOnStrategy) {
            boolean status = bookingService.bookVehicle(startTime, endTime, vehicle);
            if (status) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> displayAllVehicleInBranch(Branch branch) {
        return branch.displayVehicle();
    }

    public void addBranch(Branch branch) {
        bookingService.addBranch(branch);
    }

    public List<Vehicle> viewInventory(int startTime, int endTime) {
        return bookingService.getAllAvailableVehicles(startTime, endTime);
    }

}
