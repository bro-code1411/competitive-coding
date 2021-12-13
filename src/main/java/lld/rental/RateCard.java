package lld.rental;

import java.util.HashMap;

public class RateCard {
    private HashMap<VehicleType,Integer> rateMap = new HashMap<>();

    public RateCard(HashMap<VehicleType, Integer> rateMap) {
        this.rateMap = rateMap;
    }
    public int getRate(VehicleType vehicleType){
        return rateMap.get(vehicleType);
    }

}
