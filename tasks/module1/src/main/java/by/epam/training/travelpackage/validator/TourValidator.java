package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class TourValidator {

    private static final Logger log = Logger.getLogger(TourValidator.class);
    ValidatorResult validatorResult;
    List<String> standartTour = new ArrayList<>();
    private int minDuration = 1;
    private int maxDuration = 90;
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    int counterLine;

    public TourValidator(ValidatorResult validatorResult, int counterLine) {
        this.validatorResult = validatorResult;
        this.counterLine = counterLine;
        standartTour.add("transportType");
        standartTour.add("nutritionType");
        standartTour.add("duration");
        standartTour.add("price");
    }

    public ValidatorResult commonValidate(Map<String, String> validateMap) {
        for (String standartField : standartTour) {
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
                }
            } else {log.warn("Uncorrect field name in " + counterLine);
                validatorResult.addResult(counterLine, "Uncorrect field name");
            }

        }return validatorResult;
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
            validatorResult.addResult(counterLine, "Uncorrect value field transportType");
            log.warn("transportType in  uncorrect value field in " + counterLine);
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
            validatorResult.addResult(counterLine, "Uncorrect value field nutritionType");
            log.warn("nutritionType in  uncorrect value field in " + counterLine);
        }
    }

    public void validateDuration(String duration) {
        if (DataChecker.isInteger(duration)) {
            Integer durationInt = Integer.valueOf(duration);
            if (!(durationInt >= minDuration && durationInt <= maxDuration)) {
                validatorResult.addResult(counterLine, "Uncorrect value field duration");
                log.warn("duration in  uncorrect value field in " + counterLine);
            }
        } else {
            validatorResult.addResult(counterLine, "Uncorrect value field daration");
            log.warn("duration in  uncorrect value field in " + counterLine);
        }
    }

    public void validatePrice(String price) {
        if (DataChecker.isDouble(price)) {
            Double priceDouble = Double.valueOf(price);
            if (!(priceDouble >= minPrice && priceDouble <= maxPrice)) {
                validatorResult.addResult(counterLine, "Uncorrect value field");
                log.warn("price in MedicalTour uncorrect value field in " + counterLine);
            }
        } else {
            validatorResult.addResult(counterLine, "Uncorrect value field price");
            log.warn("price in uncorrect value field in " + counterLine);
        }
    }
}
