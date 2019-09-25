package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.entity.NutritionType;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.validator.field.StandardTourField;
import by.epam.training.travelagency.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public abstract class TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(TourValidator.class);
    private static final int MIN_DURATION = 1;
    private static final int MAX_DURATION = 90;
    private static final double MIN_PRICE = 0;
    private static final double MAX_PRICE = Double.MAX_VALUE;

    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult commonFieldResult = commonValidate(validateMap);
        if (!commonFieldResult.isValidate()) {
            return commonFieldResult;
        } else {
            ValidatorResult specificFieldResult = specificFieldValidate(validateMap);
            return specificFieldResult;
        }

    }

    protected abstract ValidatorResult specificFieldValidate(Map<String, String> validateMap);

    ValidatorResult commonValidate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = new ValidatorResult();
        for (String field : validateMap.keySet()) {
            if (StandardTourField.fromString(field).isPresent()) {
                StandardTourField tourField = StandardTourField.fromString(field).get();
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

    private void validateTransportType(String transportType, ValidatorResult validatorResult) {
        boolean flag = false;
        TransportType[] transportTypeArr = TransportType.values();
        for (TransportType type : transportTypeArr) {
            if (type.toString().equalsIgnoreCase(transportType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult("transportType", "Incorrect value");
            log.warn("Incorrect value field transportType");
        }
    }

    private void validateNutritionType(String nutritionType, ValidatorResult validatorResult) {
        boolean flag = false;
        NutritionType[] nutritionTypeArr = NutritionType.values();
        for (NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult("nutritionType", "Incorrect value");
            log.warn("Incorrect value field nutritionType");
        }
    }

    private void validateDuration(String duration, ValidatorResult validatorResult) {
        if (DataChecker.isInteger(duration)) {
            Integer durationInt = Integer.valueOf(duration);
            if (!(durationInt >= MIN_DURATION && durationInt <= MAX_DURATION)) {
                validatorResult.addResult("duration", "Incorrect value");
                log.warn("Incorrect value field duration");
            }
        } else {
            validatorResult.addResult(duration, "Incorrect value");
            log.warn("Incorrect value field duration");
        }
    }

    private void validatePrice(String price, ValidatorResult validatorResult) {
        if (DataChecker.isDouble(price)) {
            Double priceDouble = Double.valueOf(price);
            if (!(priceDouble >= MIN_PRICE && priceDouble <= MAX_PRICE)) {
                validatorResult.addResult("price", "Incorrect value");
                log.warn("Incorrect value field price");
            }
        } else {
            validatorResult.addResult("price", "Incorrect value");
            log.warn("Incorrect value field price in");
        }
    }
}
