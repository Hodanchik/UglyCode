package by.epam.training.travelpackage.controller.validator;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import org.apache.log4j.Logger;

import java.util.*;

public class MedicalTourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(MedicalTourValidator.class);
    ValidatorResult validatorResult = new ValidatorResult();
    List<String> standartMedicalTour = new ArrayList<String>();
    private int minDuration = 1;
    private int maxDuration = 90;
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    int counterLine;

    public MedicalTourValidator(int counterLine) {
        standartMedicalTour.add("transportType");
        standartMedicalTour.add("nutritionType");
        standartMedicalTour.add("duration");
        standartMedicalTour.add("price");
        standartMedicalTour.add("medicalSupport");
        standartMedicalTour.add("country");
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        for (String standartField : standartMedicalTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "transportType":
                        validateTransportType(validateMap.get(standartField));
                        break;
                    case "nutritionType":
                        validateNutritionType(validateMap.get(standartField));
                        break;
                    case "duration":
                        validateDuration(validateMap.get(standartField));
                        break;
                    case "price":
                        validatePrice(validateMap.get(standartField));
                        break;
                    case "medicalSupport":
                        validateMedicalSupport(validateMap.get(standartField));
                        break;
                    case "country":
                        validateCountry(validateMap.get(standartField));
                        break;
                }
            } else validatorResult.addResult(counterLine, "Uncorrect field name");
            log.warn("MedicalTourValidator Uncorrect field name in " + counterLine);
        }
        return validatorResult;
    }

    public void validateTransportType(String transportType) {
        boolean flag = false;
        TransportType[] transportTypeArr = TransportType.values();
        for (TransportType type : transportTypeArr) {
            if (type.toString().equalsIgnoreCase(transportType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field");
            log.warn("transportType in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validateNutritionType(String nutritionType) {
        boolean flag = false;
        NutritionType[] nutritionTypeArr = NutritionType.values();
        for (NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field");
            log.warn("nutritionType in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validateDuration(String duration) {
        Integer durationInt = Integer.valueOf(duration);
        if (!(durationInt >= minDuration && durationInt <= maxDuration)) {
            validatorResult.addResult(counterLine, "Uncorrect value field");
            log.warn("duration in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validatePrice(String price) {
        Double priceDouble = Double.valueOf(price);
        if (!(priceDouble >= minPrice && priceDouble <= maxPrice)) {
            validatorResult.addResult(counterLine, "Uncorrect value field");
            log.warn("price in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validateMedicalSupport(String medicalSupport) {
        if (!("true".equalsIgnoreCase(medicalSupport) || "false".equalsIgnoreCase(medicalSupport))) {
            validatorResult.addResult(counterLine, "Uncorrect value field");
            log.warn("medicalSupport in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validateCountry(String countryName) {
        boolean flag = false;
        Locale.setDefault(new Locale("en"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (countryName.equalsIgnoreCase(country)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field countryName");
            log.warn("countryName in MedicalTour uncorrect value field in " + counterLine);
        }
    }
}


