package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.field.StandardMedicalField;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class MedicalTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(MedicalTourValidator.class);
    private int counterLine;
    private StandardMedicalField medicalField;
    private int numbField = StandardMedicalField.values().length;
    private int countField;

    public MedicalTourValidator(int counterLine) {
        super(counterLine);
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = commonValidate(validateMap);
        if (validatorResult.isValidate()) {
            for (String field : validateMap.keySet()) {
                if (StandardMedicalField.fromString(field).isPresent()) {
                    medicalField = StandardMedicalField.fromString(field).get();
                    switch (medicalField) {
                        case TOURTYPE:
                        case PRICE:
                        case DURATION:
                        case NUTRITIONTYPE:
                        case TRANSPORTTYPE:
                            countField++;
                            break;
                        case MEDICALSUPPORT:
                            validateMedicalSupport(validateMap.get(field), validatorResult);
                            countField++;
                            break;
                        case COUNTRY:
                            validateCountry(validateMap.get(field), validatorResult);
                            countField++;
                            break;
                    }
                } else {
                    log.warn("Incorrect field name in " + counterLine);
                    validatorResult.addResult(counterLine, "Incorrect field name");
                }
            }
            if (countField != numbField) {
                log.warn("Incorrect count of valid field in " + counterLine);
                validatorResult.addResult(counterLine, "Incorrect count of valid field");
            }
        }
        return validatorResult;
    }

    public void validateMedicalSupport(String medicalSupport, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(medicalSupport)) {
            validatorResult.addResult(counterLine, "Incorrect value field medicalSupport");
            log.warn("Incorrect value field medicalSupport in" + counterLine);
        }
    }

    public void validateCountry(String countryName, ValidatorResult validatorResult) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult(counterLine, "Incorrect value field countryName");
            log.warn("Incorrect value field countryName in" + counterLine);
        }
    }
}


