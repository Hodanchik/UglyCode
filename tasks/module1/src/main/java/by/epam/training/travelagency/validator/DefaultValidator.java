package by.epam.training.travelagency.validator;

import java.util.Map;

public class DefaultValidator implements DataValidator {

    public DefaultValidator() {
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = new ValidatorResult();
        validatorResult.addResult("tourType", "Incorrect data");
        return validatorResult;
    }
}
