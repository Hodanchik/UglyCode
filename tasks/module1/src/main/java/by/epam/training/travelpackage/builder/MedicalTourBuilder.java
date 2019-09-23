package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.MedicalTour;
import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.validator.field.StandardMedicalField;

import java.util.Map;

public class MedicalTourBuilder implements TourBuilder {
    private StandardMedicalField medicalField;

    public MedicalTourBuilder() {
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        MedicalTour medicalTour = new MedicalTour();
        for (String field : validateMap.keySet()) {
            medicalField = StandardMedicalField.fromString(field).get();
            switch (medicalField) {
                case TRANSPORTTYPE:
                    medicalTour.setTransportType(TransportType.valueOf(validateMap.get(field)));
                    break;
                case NUTRITIONTYPE:
                    medicalTour.setNutritionType(NutritionType.valueOf(validateMap.get(field)));
                    break;
                case DURATION:
                    medicalTour.setDuration(Integer.parseInt(validateMap.get(field)));
                    break;
                case PRICE:
                    medicalTour.setPrice(Double.parseDouble(validateMap.get(field)));
                    break;
                case MEDICALSUPPORT:
                    medicalTour.setMedicalSupport(Boolean.parseBoolean(validateMap.get(field)));
                    break;
                case COUNTRY:
                    medicalTour.setCountry(validateMap.get(field));
                    break;
            }
        }
        return medicalTour;
    }
}