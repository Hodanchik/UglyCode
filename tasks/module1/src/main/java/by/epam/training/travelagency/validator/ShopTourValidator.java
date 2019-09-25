package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.validator.field.StandardShopField;
import by.epam.training.travelagency.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class ShopTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ShopTourValidator.class);

    @Override
    protected ValidatorResult specificFieldValidate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validateMap.size() != StandardShopField.values().length) {
            validatorResult.addResult("ShopTour", "Incorrect count of fields");
            return validatorResult;
        }
        for (String field : validateMap.keySet()) {
            if (StandardShopField.fromString(field).isPresent()) {
                StandardShopField shopField = StandardShopField.fromString(field).get();
                switch (shopField) {
                    case COUNTRY:
                        validateCountry(validateMap.get(field), validatorResult);
                        break;
                    case VISITDUTYFREE:
                        validateVisitDutyFree(validateMap.get(field), validatorResult);
                        break;
                }

            } else {
                log.warn("Incorrect field name ");
                validatorResult.addResult("ShopTour", "Incorrect field name");
            }
        }
        return validatorResult;
    }
    private void validateCountry(String countryName, ValidatorResult validatorResult) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult("countryName", "Incorrect value");
            log.warn("Incorrect value field countryName");
        }
    }
    private void validateVisitDutyFree(String visitDutyFree, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(visitDutyFree)) {
            validatorResult.addResult("countryName", "Incorrect value field");
            log.warn("Incorrect value field visitDutyFree");
        }
    }
}
