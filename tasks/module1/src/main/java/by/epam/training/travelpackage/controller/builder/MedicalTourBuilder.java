package by.epam.training.travelpackage.controller.builder;

import by.epam.training.travelpackage.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MedicalTourBuilder implements TourBuilder {
    List<String> standartMedicalTour = new ArrayList<>();

    public MedicalTourBuilder() {
        standartMedicalTour.add("transportType");
        standartMedicalTour.add("nutritionType");
        standartMedicalTour.add("duration");
        standartMedicalTour.add("price");
        standartMedicalTour.add("medicalSupport");
        standartMedicalTour.add("country");
    }

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        MedicalTour medicalTour = new MedicalTour();
        for (String standartField : standartMedicalTour) {
            switch (standartField) {
                case "transportType":
                    medicalTour.setTransportType(TransportType.valueOf(validateMap.get(standartField)));
                    break;
                case "nutritionType":
                    medicalTour.setNutritionType(NutritionType.valueOf(validateMap.get(standartField)));
                    break;
                case "duration":
                    medicalTour.setDuration(Integer.parseInt(validateMap.get(standartField)));
                    break;
                case "price":
                    medicalTour.setPrice(Double.parseDouble(validateMap.get(standartField)));
                    break;
                case "medicalSupport":
                    medicalTour.setMedicalSupport(Boolean.parseBoolean(validateMap.get(standartField)));
                    break;
                case "country":
                    medicalTour.setCountry(validateMap.get(standartField));
                    break;
            }
        }
        return medicalTour;
    }
}