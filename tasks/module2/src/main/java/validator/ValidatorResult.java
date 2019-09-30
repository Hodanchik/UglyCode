package validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorResult {
    Map<String, String> validatorResult = new HashMap<>();

    public boolean isValidate() {
        return validatorResult.isEmpty();
    }

    public void addResult(String exeptionName, String exeptionMessage) {
        validatorResult.put(exeptionName, exeptionMessage);
    }

}
