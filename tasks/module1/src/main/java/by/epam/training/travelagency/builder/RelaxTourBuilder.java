package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.*;
import by.epam.training.travelagency.validator.field.StandardRelaxField;

import java.util.Map;

public class RelaxTourBuilder implements TourBuilder {
    TransportType transportType;
    NutritionType nutritionType;
    int duration;
    double price;
    String country;
    boolean hotCountry;
    boolean haveSea;
    HotelStarsType hotelStarsType;

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        for (String field : validateMap.keySet()) {
            if (StandardRelaxField.fromString(field).isPresent()) {
                StandardRelaxField relaxField = StandardRelaxField.fromString(field).get();
                switch (relaxField) {
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
                    case HOTCOUNTRY:
                        hotCountry = Boolean.parseBoolean(validateMap.get(field));
                        break;
                    case HAVESEA:
                        haveSea = Boolean.parseBoolean(validateMap.get(field));
                        break;
                    case HOTELSTARSTYPE:
                        hotelStarsType = HotelStarsType.valueOf(validateMap.get(field));
                        break;
                }
            }
            return new RelaxTour(transportType, nutritionType, duration, price, country, hotCountry, haveSea, hotelStarsType);
        }
        return new RelaxTour(transportType, nutritionType, duration, price, country, hotCountry, haveSea, hotelStarsType);
    }
}
