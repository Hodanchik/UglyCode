package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.field.StandardExcursionField;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class ExcursionTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ExcursionTourValidator.class);
    private int counterLine;
    private StandardExcursionField excursionField;
    private static final int MIN_COUNT_COUNTRY = 1;
    private int MAX_COUNT_COUNTRY = 197;

    public ExcursionTourValidator(int counterLine) {
        super(counterLine);
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validatorResult.isValidate()) {
            for (String field : validateMap.keySet()) {
                if (StandardExcursionField.fromString(field).isPresent()) {
                    excursionField = StandardExcursionField.fromString(field).get();
                    switch (excursionField) {
                        case TOURTYPE:
                        case PRICE:
                        case DURATION:
                        case NUTRITIONTYPE:
                        case TRANSPORTTYPE:
                            break;
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
                    log.warn("Incorrect field name in " + counterLine);
                    validatorResult.addResult(counterLine, "Incorrect field name");
                }
            }
        }
        return validatorResult;
    }

    public void validateCountCountry(String countCountry, ValidatorResult validatorResult) {
        if (DataChecker.isInteger(countCountry)) {
            Integer countCountryInt = Integer.valueOf(countCountry);
            if (!(countCountryInt >= MIN_COUNT_COUNTRY && countCountryInt <= MAX_COUNT_COUNTRY)) {
                validatorResult.addResult(counterLine, "Incorrect value field countCountry");
                log.warn("Incorrect value field countCountry in " + counterLine);
            }
        }
    }

    public void validateLocalGuide(String localGuide, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(localGuide)) {
            validatorResult.addResult(counterLine, "Incorrect value field localGuide");
            log.warn("Incorrect value field localGuide in" + counterLine);
        }
    }

    public void validateNightMoving(String nightMoving, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(nightMoving)) {
            validatorResult.addResult(counterLine, "Incorrect value field nightMoving");
            log.warn("Incorrect value field nightMoving in " + counterLine);
        }
    }
}