package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelaxTourBuilder implements TourBuilder {
    List<String> standartRelaxTour = new ArrayList<>();

    public RelaxTourBuilder() {
        standartRelaxTour.add("transportType");
        standartRelaxTour.add("nutritionType");
        standartRelaxTour.add("duration");
        standartRelaxTour.add("price");
        standartRelaxTour.add("country");
        standartRelaxTour.add("hotCountry");
        standartRelaxTour.add("haveSea");
        standartRelaxTour.add("hotelStarsType");
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        RelaxTour relaxTour = new RelaxTour();
        for (String standartField : standartRelaxTour) {
            switch (standartField) {
                case "transportType":
                    relaxTour.setTransportType(TransportType.valueOf(validateMap.get(standartField)));
                    break;
                case "nutritionType":
                    relaxTour.setNutritionType(NutritionType.valueOf(validateMap.get(standartField)));
                    break;
                case "duration":
                    relaxTour.setDuration(Integer.parseInt(validateMap.get(standartField)));
                    break;
                case "price":
                    relaxTour.setPrice(Double.parseDouble(validateMap.get(standartField)));
                    break;
                case "country":
                    relaxTour.setCountry(validateMap.get(standartField));
                    break;
                case "hotCountry":
                    relaxTour.setHotCountry(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
                case "haveSea":
                    relaxTour.setHaveSea(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
                case "hotelStarsType":
                    relaxTour.setHotelStarsType(HotelStarsType.valueOf(validateMap.get(standartField)));
                    break;
            }
        }
        return relaxTour;
    }
}

