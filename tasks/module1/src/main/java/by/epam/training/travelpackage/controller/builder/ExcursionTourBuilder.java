package by.epam.training.travelpackage.controller.builder;

import by.epam.training.travelpackage.entity.ExcursionTour;
import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcursionTourBuilder implements TourBuilder {
    List<String> standartExcursionTour = new ArrayList<>();


    public ExcursionTourBuilder() {
        standartExcursionTour.add("transportType");
        standartExcursionTour.add("nutritionType");
        standartExcursionTour.add("duration");
        standartExcursionTour.add("price");
        standartExcursionTour.add("countCountry");
        standartExcursionTour.add("localGuide");
        standartExcursionTour.add("nightMoving");
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        ExcursionTour excursionTour = new ExcursionTour();
        for (String standartField : standartExcursionTour) {
            switch (standartField) {
                case "transportType":
                    excursionTour.setTransportType(TransportType.valueOf(validateMap.get(standartField)));
                    break;
                case "nutritionType":
                    excursionTour.setNutritionType(NutritionType.valueOf(validateMap.get(standartField)));
                    break;
                case "duration":
                    excursionTour.setDuration(Integer.parseInt(validateMap.get(standartField)));
                    break;
                case "price":
                    excursionTour.setPrice(Double.parseDouble(validateMap.get(standartField)));
                    break;
                case "countCountry":
                    excursionTour.setCountCountry(Integer.parseInt(validateMap.get(standartField)));
                    break;
                case "localGuide":
                    excursionTour.setLocalGuide(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
                case "nightMoving":
                    excursionTour.setNightMoving(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
            }
        }
        return excursionTour;
    }
}
