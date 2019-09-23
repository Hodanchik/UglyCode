package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.*;
import by.epam.training.travelpackage.validator.field.StandardRelaxField;

import java.util.Map;

public class RelaxTourBuilder implements TourBuilder {
    private StandardRelaxField relaxField;

    public RelaxTourBuilder() {
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        RelaxTour relaxTour = new RelaxTour();
        for (String field : validateMap.keySet()) {
            relaxField = StandardRelaxField.fromString(field).get();
            switch (relaxField) {
                case TRANSPORTTYPE:
                    relaxTour.setTransportType(TransportType.valueOf(validateMap.get(field)));
                    break;
                case NUTRITIONTYPE:
                    relaxTour.setNutritionType(NutritionType.valueOf(validateMap.get(field)));
                    break;
                case DURATION:
                    relaxTour.setDuration(Integer.parseInt(validateMap.get(field)));
                    break;
                case PRICE:
                    relaxTour.setPrice(Double.parseDouble(validateMap.get(field)));
                    break;
                case COUNTRY:
                    relaxTour.setCountry(validateMap.get(field));
                    break;
                case HOTCOUNTRY:
                    relaxTour.setHotCountry(Boolean.parseBoolean(validateMap.get(field)));
                    break;
                case HAVESEA:
                    relaxTour.setHaveSea(Boolean.parseBoolean(validateMap.get(field)));
                    break;
                case HOTELSTARSTYPE:
                    relaxTour.setHotelStarsType(HotelStarsType.valueOf(validateMap.get(field)));
                    break;
            }
        }
        return relaxTour;
    }
}

