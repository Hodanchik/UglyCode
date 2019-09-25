package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.validator.field.StandardMedicalField;
import by.epam.training.travelagency.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.Map;

public class MedicalTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(MedicalTourValidator.class);

    @Override
    protected ValidatorResult specificFieldValidate(Map<String, String> validateMap) {
        ValidatorResult validatorResult = new ValidatorResult();
        if (validateMap.size() != StandardMedicalField.values().length) {
            validatorResult.addResult("MedicalTour", "Incorrect count of fields");
            return validatorResult;
        }
        for (String field : validateMap.keySet()) {
            if (StandardMedicalField.fromString(field).isPresent()) {
                StandardMedicalField medicalField = StandardMedicalField.fromString(field).get();
                switch (medicalField) {
                    case MEDICALSUPPORT:
                        validateMedicalSupport(validateMap.get(field), validatorResult);
                        break;
                    case COUNTRY:
                        validateCountry(validateMap.get(field), validatorResult);
                        break;
                }
            } else {
                log.warn("Incorrect field name");
                validatorResult.addResult("MedicalTour", "Incorrect field name");
            }
        }
        return validatorResult;
    }

    private void validateMedicalSupport(String medicalSupport, ValidatorResult validatorResult) {
        if (!DataChecker.isBoolean(medicalSupport)) {
            validatorResult.addResult("medicalSupport", "Incorrect value");
            log.warn("Incorrect value field medicalSupport");
        }
    }

    private void validateCountry(String countryName, ValidatorResult validatorResult) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult("countryName", "Incorrect value field");
            log.warn("Incorrect value field countryName");
        }
    }

}


