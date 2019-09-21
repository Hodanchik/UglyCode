package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ShopTourValidator.class);
    private List<String> standartShopTour = new ArrayList<>();
    private ValidatorResult validatorResult;
    int counterLine;

    public ShopTourValidator(ValidatorResult validatorResult, int counterLine) {
        super(validatorResult, counterLine);
        this.validatorResult = validatorResult;
        this.counterLine = counterLine;
        standartShopTour.add("country");
        standartShopTour.add("visitDutyFree");
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        commonValidate(validateMap);
        for (String standartField : standartShopTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "country":
                        validateCountry(validateMap.get(standartField));
                        break;
                    case "visitDutyFree":
                        validateVisitDutyFree(validateMap.get(standartField));
                        break;
                }
            } else {
                validatorResult.addResult(counterLine, "Uncorrect field name");
                log.warn("ShopTourValidator error uncorrect field name in " + counterLine);
            }

        }
        return validatorResult;
    }

    public void validateCountry(String countryName) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult(counterLine, "Uncorrect value field countryName");
            log.warn("countryName in ShopTour uncorrect value field in " + counterLine);
        }
    }

    public void validateVisitDutyFree(String visitDutyFree) {
        if (!DataChecker.isBoolean(visitDutyFree)) {
            validatorResult.addResult(counterLine, "Uncorrect value field visitDutyFree");
            log.warn("visitDutyFree in ShopTour uncorrect value field in " + counterLine);
        }
    }
}
