package by.epam.training.travelpackage.controller.validator;

import org.apache.log4j.Logger;

import java.util.Map;

public class DataValidatorFactory {
    private static final Logger log = Logger.getLogger(DataValidatorFactory.class);
    private String standartField = "tourType";
    ValidatorResult validatorResult = new ValidatorResult();
    int counterLine;

    public DataValidatorFactory(int counterLine) {
        this.counterLine = counterLine;
    }

    public ValidatorResult validateDate(Map<String, String> dateParseMap) {
        if (dateParseMap.containsKey(standartField)) {
            switch (dateParseMap.get(standartField)) {
                case "MEDICAL":
                    return new MedicalTourValidator(counterLine).validate(dateParseMap);
                case "RELAX":
                    return new RelaxTourValidator(counterLine).validate(dateParseMap);
                case "SHOP":
                    return new ShopTourValidator(counterLine).validate(dateParseMap);
                case "EXCURSION":
                    return new ExcursionTourValidator(counterLine).validate(dateParseMap);
                default:
                    validatorResult.addResult(counterLine, "Uncorrect value tourType");
                    log.warn("Uncorrect value TourType");
                    return validatorResult;
            }
        } else {
            validatorResult.addResult(counterLine, "Missing tourType field");
            log.info("the required field is missing");
        }
        return validatorResult;
    }
}
