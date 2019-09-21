package by.epam.training.travelpackage.validator;

import org.apache.log4j.Logger;

import java.util.Map;
public class DataValidatorFactory {
    private static final Logger log = Logger.getLogger(DataValidatorFactory.class);
    private String standartField = "tourType";
    private ValidatorResult validatorResult;
    private int counterLine;


    public DataValidatorFactory(int counterLine, ValidatorResult validatorResult) {
        this.validatorResult = validatorResult;
        this.counterLine = counterLine;
    }

    public ValidatorResult validateDate(Map<String, String> dateParseMap) {
        if (dateParseMap.containsKey(standartField)) {
            switch (dateParseMap.get(standartField)) {
                case "MEDICAL":
                    return new MedicalTourValidator(validatorResult,counterLine).validate(dateParseMap);
                case "RELAX":
                    return new RelaxTourValidator(validatorResult,counterLine).validate(dateParseMap);
                case "SHOP":
                    return new ShopTourValidator(validatorResult,counterLine).validate(dateParseMap);
                case "EXCURSION":
                    return new ExcursionTourValidator(validatorResult,counterLine).validate(dateParseMap);
            }
            validatorResult.addResult(counterLine, "Incorrect value tourType");
            log.warn("Incorrect value TourType");
            return validatorResult;
        } else {
            validatorResult.addResult(counterLine, "Missing tourType field");
            log.info("the required field is missing");
        }
        return validatorResult;
    }
}
