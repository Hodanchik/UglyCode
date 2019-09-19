package by.epam.training.travelpackage.controller.validator;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcursionTourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ExcursionTourValidator.class);
    ValidatorResult validatorResult = new ValidatorResult();
    List<String> standartExcursionTour = new ArrayList<>();
    private int minDuration = 1;
    private int maxDuration = 60;
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    private int minCountCountry = 1;
    private int maxCountCountry = 197;
    int counterLine;

    public ExcursionTourValidator(int counterLine) {
        standartExcursionTour.add("transportType");
        standartExcursionTour.add("nutritionType");
        standartExcursionTour.add("duration");
        standartExcursionTour.add("price");
        standartExcursionTour.add("countCountry");
        standartExcursionTour.add("localGuide");
        standartExcursionTour.add("nightMoving");
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        for (String standartField : standartExcursionTour) {
            if (validateMap.containsKey(standartField)) {
                switch (standartField) {
                    case "transportType":
                        validateTransportType(validateMap.get(standartField));
                        break;
                    case "nutritionType":
                        validateNutritionType(validateMap.get(standartField));
                        break;
                    case "duration":
                        validateDuration(validateMap.get(standartField));
                        break;
                    case "price":
                        validatePrice(validateMap.get(standartField));
                        break;
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
            } else validatorResult.addResult(counterLine, "Uncorrect field name");
            log.warn("ExcursionTourValidator error uncorrect field name in " + counterLine);
        }
        return validatorResult;
    }


    public void validateTransportType(String transportType) {
        boolean flag = false;
        TransportType[] transportTypeArr = TransportType.values();
        for (TransportType type : transportTypeArr) {
            if (type.toString().equalsIgnoreCase(transportType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field transportType");
            log.warn("Uncorrect value field transportType in ExcursionTour in " + counterLine);
        }
    }

    public void validateNutritionType(String nutritionType) {
        boolean flag = false;
        by.epam.training.travelpackage.entity.NutritionType[] nutritionTypeArr = by.epam.training.travelpackage.entity.NutritionType.values();
        for (NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field nutritionType");
            log.warn("Uncorrect value field nutritionType in ExcursionTour in " + counterLine);
        }
    }

    public void validateDuration(String duration) {
        Integer durationInt = Integer.valueOf(duration);
        if (!(durationInt >= minDuration && durationInt <= maxDuration)) {
            validatorResult.addResult(counterLine, "Uncorrect value field duration");
            log.warn("Uncorrect value field duration in ExcursionTour in " + counterLine);
        }
    }

    public void validatePrice(String price) {
        Double priceDouble = Double.valueOf(price);
        if (!(priceDouble >= minPrice && priceDouble <= maxPrice)) {
            validatorResult.addResult(counterLine, "Uncorrect value field price");
            log.warn("Uncorrect value field price in ExcursionTour in " + counterLine);
        }
    }

    public void validateCountCountry(String countCountry) {
        Integer countCountryInt = Integer.valueOf(countCountry);
        if (!(countCountryInt >= minCountCountry && countCountryInt <= maxCountCountry)) {
            validatorResult.addResult(counterLine, "Uncorrect value field countCountry");
            log.warn("Uncorrect value field countCountry in ExcursionTour in " + counterLine);
        }
    }

    public void validateLocalGuide(String localGuide) {
        if (!("true".equalsIgnoreCase(localGuide) || "false".equalsIgnoreCase(localGuide))) {
            validatorResult.addResult(counterLine, "Uncorrect value field localGuide");
            log.warn("Uncorrect value field localGuide in ExcursionTour in" + counterLine);
        }
    }

    public void validateNightMoving(String nightMoving) {
        if (!("true".equalsIgnoreCase(nightMoving) || "false".equalsIgnoreCase(nightMoving))) {
            validatorResult.addResult(counterLine, "Uncorrect value field nightMoving");
            log.warn("Uncorrect value field nightMoving in ExcursionTour in " + counterLine);
        }
    }
}