package by.epam.training.travelpackage.controller.validator;

import java.util.Map;
public interface DataValidator {
     ValidatorResult validate(Map<String, String > validateMap);
}
