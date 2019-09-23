package by.epam.training.travelpackage.validator;


import by.epam.training.travelpackage.entity.HotelStarsType;
import by.epam.training.travelpackage.validator.field.StandardRelaxField;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class RelaxTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(RelaxTourValidator.class);
    private int counterLine;
    private StandardRelaxField relaxField;

    public RelaxTourValidator( int counterLine) {
        super(counterLine);
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validatorResult.isValidate()) {
            for (String field : validateMap.keySet()) {
                if (StandardRelaxField.fromString(field).isPresent()) {
                    relaxField = StandardRelaxField.fromString(field).get();
                    switch (relaxField) {
                        case TOURTYPE:
                        case PRICE:
                        case DURATION:
                        case NUTRITIONTYPE:
                        case TRANSPORTTYPE:
                            break;
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
                    log.warn("Incorrect field name in " + counterLine);
                    validatorResult.addResult(counterLine, "Incorrect field name");
                }
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

    public void validateHotCountry(String hotCountry,  ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(hotCountry)) {
            validatorResult.addResult(counterLine, "Incorrect value field hotCountry");
            log.warn("Incorrect value field hotCountry in " + counterLine);
        }
    }

    public void validateHaveSea(String haveSea,  ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(haveSea)) {
            validatorResult.addResult(counterLine, "Incorrect value field haveSea");
            log.warn("Incorrect value field haveSea in " + counterLine);
        }
    }

    public void validateHotelStars(String hotelStars,  ValidatorResult validatorResult) {
        boolean flag = false;
        HotelStarsType[] hotelStarsArr = HotelStarsType.values();
        for (HotelStarsType type : hotelStarsArr) {
            if (type.toString().equalsIgnoreCase(hotelStars)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Incorrect value field hotelStars");
            log.warn("Incorrect value field hotelStars in " + counterLine);
        }
    }
}
