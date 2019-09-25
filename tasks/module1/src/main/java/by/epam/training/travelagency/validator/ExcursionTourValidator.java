package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.validator.field.StandardExcursionField;
import by.epam.training.travelagency.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class ExcursionTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ExcursionTourValidator.class);
    private static final int MIN_COUNT_COUNTRY = 1;
    private static final int MAX_COUNT_COUNTRY = 197;

    @Override
    protected ValidatorResult specificFieldValidate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validateMap.size() != StandardExcursionField.values().length) {
            validatorResult.addResult("ExcursionTour", "Incorrect count of fields");
            return validatorResult;
        }
        for (String field : validateMap.keySet()) {
            if (StandardExcursionField.fromString(field).isPresent()) {
                StandardExcursionField excursionField = StandardExcursionField.fromString(field).get();
                switch (excursionField) {
                    case COUNTCOUNTRY:
                        validateCountCountry(validateMap.get(field), validatorResult);
                        break;
                    case LOCALGUIDE:
                        validateLocalGuide(validateMap.get(field), validatorResult);
                        break;
                    case NIGHTMOVING:
                        validateNightMoving(validateMap.get(field), validatorResult);
                        break;
                }
            } else {
                log.warn("Incorrect field name");
                validatorResult.addResult("ExcursionTour", "Incorrect field name");
            }
        }
        return validatorResult;
    }

    private void validateCountCountry(String countCountry, ValidatorResult validatorResult) {
        if (DataChecker.isInteger(countCountry)) {
            Integer countCountryInt = Integer.valueOf(countCountry);
            if (!(countCountryInt >= MIN_COUNT_COUNTRY && countCountryInt <= MAX_COUNT_COUNTRY)) {
                validatorResult.addResult("countCountry", "Incorrect value");
                log.warn("Incorrect value field");
            }
        }
    }

    private void validateLocalGuide(String localGuide, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(localGuide)) {
            validatorResult.addResult("localGuide", "Incorrect value");
            log.warn("Incorrect value field localGuide");
        }
    }

    private void validateNightMoving(String nightMoving, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(nightMoving)) {
            validatorResult.addResult("nightMoving", "Incorrect value");
            log.warn("Incorrect value field nightMoving ");
        }
    }
}