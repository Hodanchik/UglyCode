package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.entity.TourType;

import java.util.Map;

public class TypeValidator {
    private static final String MAIN_FIELD = "tourType";


    public ValidatorResult validateType(Map<String, String> validateMap) {

        if (TourType.fromString(validateMap.get(MAIN_FIELD)).isPresent()) {
            return new ValidatorResult();
        } else {
            ValidatorResult validatorResult = new ValidatorResult();
            validatorResult.addResult("tourType", "Incorrect value");
            return validatorResult;
        }
    }

}

