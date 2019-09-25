package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.NutritionType;
import by.epam.training.travelagency.entity.ShopTour;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.entity.TravelTour;
import by.epam.training.travelagency.validator.field.StandardShopField;

import java.util.Map;

public class ShopTourBuilder implements TourBuilder {
    private TransportType transportType;
    private NutritionType nutritionType;
    private double price;
    private int duration;
    private String country;
    private boolean visitDutyFree;

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        for (String field : validateMap.keySet()) {
            if (StandardShopField.fromString(field).isPresent()) {
                StandardShopField shopField = StandardShopField.fromString(field).get();
                switch (shopField) {
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
                    case COUNTRY:
                        country = validateMap.get(field);
                        break;
                    case VISITDUTYFREE:
                        visitDutyFree = Boolean.parseBoolean(validateMap.get(field));
                        break;
                }
                return new ShopTour(transportType, nutritionType, duration, price, country, visitDutyFree);
            }
        }
        return new ShopTour(transportType, nutritionType, duration, price, country, visitDutyFree);
    }
}
