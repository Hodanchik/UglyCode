package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcursionTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ExcursionTourValidator.class);
    private ValidatorResult validatorResult;
    private int minCountCountry;
    private int maxCountCountry;
    private int counterLine;
    private List<String> standartExcursionTour = new ArrayList<>();

    public ExcursionTourValidator(ValidatorResult validatorResult, int counterLine) {
        super(validatorResult, counterLine);
        this.validatorResult = validatorResult;
        this.minCountCountry = 1;
        this.maxCountCountry = 197;
        standartExcursionTour.add("countCountry");
        standartExcursionTour.add("localGuide");
        standartExcursionTour.add("nightMoving");
    }


    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        commonValidate(validateMap);
        for (String standartField : standartExcursionTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "countCountry":
                        validateCountCountry(validateMap.get(standartField));
                        break;
                    case "localGuide":
                        validateLocalGuide(validateMap.get(standartField));
                        break;
                    case "nightMoving":
                        validateNightMoving(validateMap.get(standartField));
                        break;
                }
            } else {
                validatorResult.addResult(counterLine, "Uncorrect field name");
                log.warn("ExcursionTourValidator error uncorrect field name in " + counterLine);
            }
        }
        return validatorResult;
    }

    public void validateCountCountry(String countCountry) {
        if (DataChecker.isInteger(countCountry)) {
            Integer countCountryInt = Integer.valueOf(countCountry);
            if (!(countCountryInt >= minCountCountry && countCountryInt <= maxCountCountry)) {
                validatorResult.addResult(counterLine, "Uncorrect value field countCountry");
                log.warn("Uncorrect value field countCountry in ExcursionTour in " + counterLine);
            }
        }
    }

    public void validateLocalGuide(String localGuide) {
        if (!DataChecker.isBoolean(localGuide)) {
            validatorResult.addResult(counterLine, "Uncorrect value field localGuide");
            log.warn("Uncorrect value field localGuide in ExcursionTour in" + counterLine);
        }
    }

    public void validateNightMoving(String nightMoving) {
        if (!DataChecker.isBoolean(nightMoving)) {
            validatorResult.addResult(counterLine, "Uncorrect value field nightMoving");
            log.warn("Uncorrect value field nightMoving in ExcursionTour in " + counterLine);
        }
    }
}