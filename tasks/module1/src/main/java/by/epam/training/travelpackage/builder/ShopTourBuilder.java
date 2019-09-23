package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.ShopTour;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.validator.field.StandardShopField;

import java.util.Map;

public class ShopTourBuilder implements TourBuilder {
    private StandardShopField shopField;

    public ShopTourBuilder() {
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        ShopTour shopTour = new ShopTour();
        for (String field : validateMap.keySet()) {
            shopField = StandardShopField.fromString(field).get();
            switch (shopField) {
                case TRANSPORTTYPE:
                    shopTour.setTransportType(TransportType.valueOf(validateMap.get(field)));
                    break;
                case NUTRITIONTYPE:
                    shopTour.setNutritionType(NutritionType.valueOf(validateMap.get(field)));
                    break;
                case DURATION:
                    shopTour.setDuration(Integer.parseInt(validateMap.get(field)));
                    break;
                case PRICE:
                    shopTour.setPrice(Double.parseDouble(validateMap.get(field)));
                    break;
                case COUNTRY:
                    shopTour.setCountry(validateMap.get(field));
                    break;
                case VISITDUTYFREE:
                    shopTour.setVisitDutyFree(Boolean.parseBoolean(validateMap.get(field)));
                    break;
            }
        }
        return shopTour;
    }
}
