package by.epam.training.travelagency.validator;

import java.util.Map;

public interface DataValidator {
    ValidatorResult validate(Map<String, String> validateMap);
}
