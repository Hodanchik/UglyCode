package by.epam.training.travelagency.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorResult {
    Map<String, String> validatorResult = new HashMap<>();

    public boolean isValidate() {
        return validatorResult.isEmpty();
    }

    public void addResult(String fieldName, String fieldMessage) {
        validatorResult.put(fieldName, fieldMessage);
    }
}
