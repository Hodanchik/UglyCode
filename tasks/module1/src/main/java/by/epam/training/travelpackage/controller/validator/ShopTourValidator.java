package by.epam.training.travelpackage.controller.validator;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ShopTourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(ShopTourValidator.class);
    ValidatorResult validatorResult = new ValidatorResult();
    List<String> standartShopTour = new ArrayList<>();
    private int minDuration = 1;
    private int maxDuration = 60;
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    int counterLine;
    public ShopTourValidator(int counterLine) {
        standartShopTour.add("transportType");
        standartShopTour.add("nutritionType");
        standartShopTour.add("duration");
        standartShopTour.add("price");
        standartShopTour.add("country");
        standartShopTour.add("visitDutyFree");
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        for (String standartField : standartShopTour) {
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
                    case "country":
                        validateCountry(validateMap.get(standartField));
                        break;
                    case "visitDutyFree":
                        validateVisitDutyFree(validateMap.get(standartField));
                        break;

                }
            } else validatorResult.addResult(counterLine, "Uncorrect field name");
            log.warn("ShopTourValidator error uncorrect field name in " + counterLine);
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
            validatorResult.addResult(counterLine, "Uncorrect value field transportType in ShopTour");
            log.warn("Uncorrect value field transportType in ShopTour in " + counterLine);
        }
    }

    public void validateNutritionType(String nutritionType) {
        boolean flag = false;
        NutritionType[] nutritionTypeArr = NutritionType.values();
        for (NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field nutritionType in ShopTour");
            log.warn("Uncorrect value field nutritionType in ShopTour in " + counterLine);
        }
    }

    public void validateDuration(String duration) {
        Integer durationInt = Integer.valueOf(duration);
        if (!(durationInt >= minDuration && durationInt <= maxDuration)) {
            validatorResult.addResult(counterLine, "Uncorrect value field duration in ShopTour");
            log.warn("Uncorrect value field duration in ShopTour in "+ counterLine);
        }
    }

    public void validatePrice(String price) {
        Double priceDouble = Double.valueOf(price);
        if (!(priceDouble >= minPrice && priceDouble <= maxPrice)) {
            validatorResult.addResult(counterLine, "Uncorrect value field price in ShopTour");
            log.warn("Uncorrect value field price in ShopTour in "+ counterLine);
        }
    }


    public void validateCountry(String countryName) {
        boolean flag = false;
        Locale.setDefault(new Locale("en"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (countryName.equalsIgnoreCase(country)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field countryName in ShopTour");
            log.warn("Uncorrect value field countryName in ShopTour in " + counterLine);
        }
    }

    public void validateVisitDutyFree(String visitDutyFree) {
        if (!("true".equalsIgnoreCase(visitDutyFree) || "false".equalsIgnoreCase(visitDutyFree))) {
            validatorResult.addResult(counterLine, "Uncorrect value field visitDutyFree in ShopTour");
            log.warn("Uncorrect value field visitDutyFree in ShopTour in "+ counterLine);
        }
    }
}
