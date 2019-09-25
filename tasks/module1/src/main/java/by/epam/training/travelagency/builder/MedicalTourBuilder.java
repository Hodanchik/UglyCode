package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.MedicalTour;
import by.epam.training.travelagency.entity.NutritionType;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.entity.TravelTour;
import by.epam.training.travelagency.validator.field.StandardMedicalField;

import java.util.Map;

public class MedicalTourBuilder implements TourBuilder {
    TransportType transportType;
    NutritionType nutritionType;
    int duration;
    double price;
    boolean medicalSupport;
    String country;

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        for (String field : validateMap.keySet()) {
            if (StandardMedicalField.fromString(field).isPresent()) {
                StandardMedicalField medicalField = StandardMedicalField.fromString(field).get();
                switch (medicalField) {
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
                    case MEDICALSUPPORT:
                        medicalSupport = Boolean.parseBoolean(validateMap.get(field));
                        break;
                    case COUNTRY:
                        country = validateMap.get(field);
                        break;
                }
                return new MedicalTour(transportType, nutritionType, duration, price, medicalSupport, country);
            }
        }
        return new MedicalTour(transportType, nutritionType, duration, price, medicalSupport, country);
    }
}