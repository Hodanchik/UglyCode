package by.epam.training.travelpackage.validator;

import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MedicalTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(MedicalTourValidator.class);
    ValidatorResult validatorResult;
    int counterLine;
    List<String> standartMedicalTour = new ArrayList<String>();

    public MedicalTourValidator(ValidatorResult validatorResult, int counterLine) {
        super(validatorResult, counterLine);
        standartMedicalTour.add("medicalSupport");
        standartMedicalTour.add("country");
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        commonValidate(validateMap);
        for (String standartField : standartMedicalTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "medicalSupport":
                        validateMedicalSupport(validateMap.get(standartField));
                        break;
                    case "country":
                        validateCountry(validateMap.get(standartField));
                        break;
                }
            } else {
                validatorResult.addResult(counterLine, "Uncorrect field name");
                log.warn(" Uncorrect field name in " + counterLine);
            }

        }
        return validatorResult;
    }

    public void validateMedicalSupport(String medicalSupport) {
        if (!DataChecker.isBoolean(medicalSupport)) {
            validatorResult.addResult(counterLine, "Uncorrect value field medicalSupport");
            log.warn("medicalSupport in MedicalTour uncorrect value field in " + counterLine);
        }
    }

    public void validateCountry(String countryName) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult(counterLine, "Uncorrect value field countryName");
            log.warn("countryName in MedicalTour uncorrect value field in " + counterLine);
        }
    }
}


