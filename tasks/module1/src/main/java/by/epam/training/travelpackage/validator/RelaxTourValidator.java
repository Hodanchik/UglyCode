package by.epam.training.travelpackage.validator;


import by.epam.training.travelpackage.entity.HotelStarsType;
import by.epam.training.travelpackage.validator.util.DataChecker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelaxTourValidator extends TourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(RelaxTourValidator.class);
    List<String> standartRelaxTour = new ArrayList<>();
    ValidatorResult validatorResult;
    int counterLine;


    public RelaxTourValidator(ValidatorResult validatorResult, int counterLine) {
        super(validatorResult, counterLine);
        standartRelaxTour.add("country");
        standartRelaxTour.add("hotCountry");
        standartRelaxTour.add("haveSea");
        standartRelaxTour.add("hotelStarsType");
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        commonValidate(validateMap);
        for (String standartField : standartRelaxTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "country":
                        validateCountry(validateMap.get(standartField));
                        break;
                    case "hotCountry":
                        validateHotCountry(validateMap.get(standartField));
                        break;
                    case "haveSea":
                        validateHaveSea(validateMap.get(standartField));
                        break;
                    case "hotelStarsType":
                        validateHotelStars(validateMap.get(standartField));
                        break;
                }
            } else {
                validatorResult.addResult(counterLine, "Uncorrect field name");
                log.warn("RelaxTourValidator error uncorrect field name in " + counterLine);
            }
        }
        return validatorResult;
    }

    public void validateCountry(String countryName) {
        if (!DataChecker.isCountry(countryName)) {
            validatorResult.addResult(counterLine, "Uncorrect value field countryName");
            log.warn("countryName in RelaxTour uncorrect value field in " + counterLine);
        }
    }

    public void validateHotCountry(String hotCountry) {
        if (!DataChecker.isBoolean(hotCountry)) {
            validatorResult.addResult(counterLine, "Uncorrect value field hotCountry");
            log.warn("hotCountry in RelaxTour uncorrect value field in " + counterLine);
        }
    }

    public void validateHaveSea(String haveSea) {
        if (!DataChecker.isBoolean(haveSea)) {
            validatorResult.addResult(counterLine, "Uncorrect value field haveSea");
            log.warn("haveSea in RelaxTour uncorrect value field in " + counterLine);
        }
    }

    public void validateHotelStars(String hotelStars) {
        boolean flag = false;
        HotelStarsType[] hotelStarsArr = HotelStarsType.values();
        for (HotelStarsType type : hotelStarsArr) {
            if (type.toString().equalsIgnoreCase(hotelStars)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field hotelStars");
            log.warn("Uncorrect value field hotelStars in RelaxTour in " + counterLine);
        }
    }
}
