package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.ExcursionTour;
import by.epam.training.travelagency.entity.NutritionType;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.entity.TravelTour;
import by.epam.training.travelagency.validator.field.StandardExcursionField;

import java.util.Map;

public class ExcursionTourBuilder implements TourBuilder {
    TransportType transportType;
    NutritionType nutritionType;
    int duration;
    double price;
    int countCountry;
    boolean localGuide;
    boolean nightMoving;

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        for (String field : validateMap.keySet()) {
            if (StandardExcursionField.fromString(field).isPresent()) {
                StandardExcursionField excursionField = StandardExcursionField.fromString(field).get();
                switch (excursionField) {
                    case TRANSPORTTYPE:
                        transportType = TransportType.valueOf(validateMap.get(field));
                        break;
                    case NUTRITIONTYPE:
                        nutritionType = NutritionType.valueOf(validateMap.get(field));
                        break;
                    case DURATION:
                        duration = Integer.parseInt(validateMap.get(field));
                        break;
                    case PRICE:
                        price = Double.parseDouble(validateMap.get(field));
                        break;
                    case COUNTCOUNTRY:
                        countCountry = Integer.parseInt(validateMap.get(field));
                        break;
                    case LOCALGUIDE:
                        localGuide = Boolean.parseBoolean(validateMap.get(field));
                        break;
                    case NIGHTMOVING:
                        nightMoving = Boolean.parseBoolean(validateMap.get(field));
                        break;
                }
                return new ExcursionTour(transportType, nutritionType, duration, price, countCountry, localGuide, nightMoving);
            }
        }
        return new ExcursionTour(transportType, nutritionType, duration, price, countCountry, localGuide, nightMoving);
    }
}