package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.validator.field.StandardTourField;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class TourValidator {
    private static final Logger log = Logger.getLogger(TourValidator.class);
    private static final int MIN_DURATION = 1;
    private static final int MAX_DURATION = 90;
    private static final double MIN_PRICE = 0;
    private static final double MAX_PRICE = Double.MAX_VALUE;
    private int counterLine;
    private StandardTourField tourField;

    public TourValidator(int counterLine) {
        this.counterLine = counterLine;
    }

    public ValidatorResult commonValidate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = new ValidatorResult();
        for (String field : validateMap.keySet()) {
            if (StandardTourField.fromString(field).isPresent()) {
                tourField = StandardTourField.fromString(field).get();
                switch (tourField) {
                    case TRANSPORTTYPE:
                        validateTransportType(validateMap.get(field), validatorResult);
                        break;
                    case NUTRITIONTYPE:
                        validateNutritionType(validateMap.get(field), validatorResult);
                        break;
                    case DURATION:
                        validateDuration(validateMap.get(field), validatorResult);
                        break;
                    case PRICE:
                        validatePrice(validateMap.get(field), validatorResult);
                        break;
                }
            }
        }
        return validatorResult;
    }

    public void validateTransportType(String transportType, ValidatorResult validatorResult) {
        boolean flag = false;
        TransportType[] transportTypeArr = TransportType.values();
        for (TransportType type : transportTypeArr) {
            if (type.toString().equalsIgnoreCase(transportType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Incorrect value field transportType");
            log.warn("Incorrect value field transportType in " + counterLine);
        }
    }

    public void validateNutritionType(String nutritionType, ValidatorResult validatorResult) {
        boolean flag = false;
        NutritionType[] nutritionTypeArr = NutritionType.values();
        for (NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Incorrect value field nutritionType");
            log.warn("Incorrect value field nutritionType in " + counterLine);
        }
    }

    public void validateDuration(String duration, ValidatorResult validatorResult) {
        if (DataChecker.isInteger(duration)) {
            Integer durationInt = Integer.valueOf(duration);
            if (!(durationInt >= MIN_DURATION && durationInt <= MAX_DURATION)) {
                validatorResult.addResult(counterLine, "Incorrect value field duration");
                log.warn("Incorrect value field duration  in " + counterLine);
            }
        } else {
            validatorResult.addResult(counterLine, "Incorrect value field daration");
            log.warn("Incorrect value field duration in " + counterLine);
        }
    }

    public void validatePrice(String price, ValidatorResult validatorResult) {
        if (DataChecker.isDouble(price)) {
            Double priceDouble = Double.valueOf(price);
            if (!(priceDouble >= MIN_PRICE && priceDouble <= MAX_PRICE)) {
                validatorResult.addResult(counterLine, "Uncorrect value field");
                log.warn("Incorrect value field price in " + counterLine);
            }
        } else {
            validatorResult.addResult(counterLine, "Incorrect value field price");
            log.warn("Incorrect value field price in " + counterLine);
        }
    }
}
