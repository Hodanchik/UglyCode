package by.epam.training.travelpackage.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorResult {
    Map<Integer, String> validatorResult = new HashMap<Integer, String>();

    public boolean isValidate(){
       return  validatorResult.isEmpty();
    }

    public void addResult(Integer lineCounter, String fieldMessage){
        validatorResult.put(lineCounter, fieldMessage);
    }


}
