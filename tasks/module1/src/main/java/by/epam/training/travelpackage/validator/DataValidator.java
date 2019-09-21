package by.epam.training.travelpackage.validator;

import java.util.Map;
public interface DataValidator {
     ValidatorResult validate(Map<String, String > validateMap);
}
