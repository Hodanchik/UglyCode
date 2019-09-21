package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopTourBuilder implements TourBuilder {
    List<String> standartShopTour = new ArrayList<>();

    public ShopTourBuilder() {
        standartShopTour.add("transportType");
        standartShopTour.add("nutritionType");
        standartShopTour.add("duration");
        standartShopTour.add("price");
        standartShopTour.add("country");
        standartShopTour.add("visitDutyFree");
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        ShopTour shopTour = new ShopTour();
        for (String standartField : standartShopTour) {
            switch (standartField) {
                case "transportType":
                    shopTour.setTransportType(TransportType.valueOf(validateMap.get(standartField)));
                    break;
                case "nutritionType":
                    shopTour.setNutritionType(NutritionType.valueOf(validateMap.get(standartField)));
                    break;
                case "duration":
                    shopTour.setDuration(Integer.parseInt(validateMap.get(standartField)));
                    break;
                case "price":
                    shopTour.setPrice(Double.parseDouble(validateMap.get(standartField)));
                    break;
                case "country":
                    shopTour.setCountry(validateMap.get(standartField));
                    break;
                case "visitDutyFree":
                    shopTour.setVisitDutyFree(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
            }
        }
        return shopTour;
    }
}
