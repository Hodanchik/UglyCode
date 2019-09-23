package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.field.StandardShopField;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class ShopTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ShopTourValidator.class);
    private int counterLine;
    private StandardShopField shopField;
    private int numbField = StandardShopField.values().length;
    private int countField;

    public ShopTourValidator(int counterLine) {
        super(counterLine);
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validatorResult.isValidate()) {
            for (String field : validateMap.keySet()) {
                if (StandardShopField.fromString(field).isPresent()) {
                    shopField = StandardShopField.fromString(field).get();
                    switch (shopField) {
                        case TOURTYPE:
                        case PRICE:
                        case DURATION:
                        case TRANSPORTTYPE:
                        case NUTRITIONTYPE:
                            countField++;
                            break;
                        case COUNTRY:
                            validateCountry(validateMap.get(field), validatorResult);
                            countField++;
                            break;
                        case VISITDUTYFREE:
                            validateVisitDutyFree(validateMap.get(field), validatorResult);
                            countField++;
                            break;
                    }

                } else {
                    log.warn("Incorrect field name in " + counterLine);
                    validatorResult.addResult(counterLine, "Incorrect field name");
                }
            }
            if (countField != numbField) {
                log.warn("Incorrect count of valid field in " + counterLine);
                validatorResult.addResult(counterLine, "Incorrect count of valid field");
            }
        }
        return validatorResult;
    }

    public void validateCountry(String countryName, ValidatorResult validatorResult) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult(counterLine, "Incorrect value field countryName");
            log.warn("Incorrect value field countryName in " + counterLine);
        }
    }

    public void validateVisitDutyFree(String visitDutyFree, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(visitDutyFree)) {
            validatorResult.addResult(counterLine, "Incorrect value field visitDutyFree");
            log.warn("Incorrect value field visitDutyFree in " + counterLine);
        }
    }
}
