package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.entity.TourType;
import org.apache.log4j.Logger;

import java.util.Map;

public class DataValidatorFactory {
    private static final Logger log = Logger.getLogger(DataValidatorFactory.class);
    private static final String MAIN_FIELD = "tourType";
    private int counterLine;
    private TourType type;

    public DataValidatorFactory(int counterLine) {
        this.counterLine = counterLine;
    }

    public ValidatorResult validateDate(Map<String, String> dateParseMap) {
        ValidatorResult validatorResult = new ValidatorResult();
        if (dateParseMap.containsKey(MAIN_FIELD)) {
            String typeString = dateParseMap.get(MAIN_FIELD);
            if (TourType.fromString(typeString).isPresent()) {
                type = TourType.fromString(typeString).get();
                switch (type) {
                    case MEDICAL:
                        return new MedicalTourValidator(counterLine).validate(dateParseMap);
                    case RELAX:
                        return new RelaxTourValidator(counterLine).validate(dateParseMap);
                    case SHOP:
                        return new ShopTourValidator(counterLine).validate(dateParseMap);
                    case EXCURSION:
                        return new ExcursionTourValidator(counterLine).validate(dateParseMap);
                }
                validatorResult.addResult(counterLine, "Incorrect value " + MAIN_FIELD);
                log.warn("Incorrect value " + MAIN_FIELD);
                return validatorResult;
            } else {
                validatorResult.addResult(counterLine, "Incorrect value " + MAIN_FIELD);
                log.warn("Incorrect value " + MAIN_FIELD);
                return validatorResult;
            }
        } else {
            validatorResult.addResult(counterLine, "Missing field " + MAIN_FIELD);
            log.info("the required field is missing");
            return validatorResult;
        }
    }
}
