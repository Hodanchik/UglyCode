package by.epam.training.travelagency.validator;


import by.epam.training.travelagency.entity.HotelStarsType;
import by.epam.training.travelagency.validator.field.StandardRelaxField;
import by.epam.training.travelagency.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class RelaxTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(RelaxTourValidator.class);
    ValidatorResult validatorResult  = new ValidatorResult();

    @Override
    protected ValidatorResult specificFieldValidate(Map<String, String> validateMap) {
        if (validateMap.size() != StandardRelaxField.values().length) {
            validatorResult.addResult("RelaxTour", "Incorrect count of fields");
            return validatorResult;
        }
            for (String field : validateMap.keySet()) {
                if (StandardRelaxField.fromString(field).isPresent()) {
                    StandardRelaxField relaxField = StandardRelaxField.fromString(field).get();
                    switch (relaxField) {
                        case COUNTRY:
                            validateCountry(validateMap.get(field), validatorResult);
                            break;
                        case HOTCOUNTRY:
                            validateHotCountry(validateMap.get(field), validatorResult);
                            break;
                        case HAVESEA:
                            validateHaveSea(validateMap.get(field), validatorResult);
                            break;
                        case HOTELSTARSTYPE:
                            validateHotelStars(validateMap.get(field), validatorResult);
                            break;
                    }
                } else {
                    log.warn("Incorrect field name ");
                    validatorResult.addResult("RelaxTour", "Incorrect field name");
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

    private void validateHotCountry(String hotCountry, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(hotCountry)) {
            validatorResult.addResult(hotCountry, "Incorrect value");
            log.warn("Incorrect value field hotCountry");
        }
    }

    private void validateHaveSea(String haveSea, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(haveSea)) {
            validatorResult.addResult("haveSea", "Incorrect value");
            log.warn("Incorrect value field haveSea");
        }
    }

    private void validateHotelStars(String hotelStars, ValidatorResult validatorResult) {
        boolean flag = false;
        HotelStarsType[] hotelStarsArr = HotelStarsType.values();
        for (HotelStarsType type : hotelStarsArr) {
            if (type.toString().equalsIgnoreCase(hotelStars)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult("hotelStars", "Incorrect value");
            log.warn("Incorrect value field hotelStars");
        }
    }
}
