package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.ExcursionTour;
import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.validator.field.StandardExcursionField;

import java.util.Map;

public class ExcursionTourBuilder implements TourBuilder {
    private StandardExcursionField excursionField;


    public ExcursionTourBuilder() {
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        ExcursionTour excursionTour = new ExcursionTour();
        for (String field : validateMap.keySet()) {
            excursionField = StandardExcursionField.fromString(field).get();
            switch (excursionField) {
                case TRANSPORTTYPE:
                    excursionTour.setTransportType(TransportType.valueOf(validateMap.get(field)));
                    break;
                case NUTRITIONTYPE:
                    excursionTour.setNutritionType(NutritionType.valueOf(validateMap.get(field)));
                    break;
                case DURATION:
                    excursionTour.setDuration(Integer.parseInt(validateMap.get(field)));
                    break;
                case PRICE:
                    excursionTour.setPrice(Double.parseDouble(validateMap.get(field)));
                    break;
                case COUNTCOUNTRY:
                    excursionTour.setCountCountry(Integer.parseInt(validateMap.get(field)));
                    break;
                case LOCALGUIDE:
                    excursionTour.setLocalGuide(Boolean.parseBoolean(validateMap.get(field)));
                    break;
                case NIGHTMOVING:
                    excursionTour.setNightMoving(Boolean.parseBoolean(validateMap.get(field)));
                    break;
            }
        }
        return excursionTour;
    }
}
