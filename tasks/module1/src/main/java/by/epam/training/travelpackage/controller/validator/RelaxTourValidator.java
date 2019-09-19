package by.epam.training.travelpackage.controller.validator;


import by.epam.training.travelpackage.entity.HotelStarsType;
import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RelaxTourValidator implements DataValidator {
    private static final Logger log = Logger.getLogger(RelaxTourValidator.class);
    ValidatorResult validatorResult = new ValidatorResult();
    List<String> standartRelaxTour = new ArrayList<>();
    private int minDuration = 1;
    private int maxDuration = 60;
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    int counterLine;

    public RelaxTourValidator(int counterLine) {
        standartRelaxTour.add("transportType");
        standartRelaxTour.add("nutritionType");
        standartRelaxTour.add("duration");
        standartRelaxTour.add("price");
        standartRelaxTour.add("country");
        standartRelaxTour.add("hotCountry");
        standartRelaxTour.add("haveSea");
        standartRelaxTour.add("hotelStarsType");
        this.counterLine = counterLine;
    }

    @Override
    public ValidatorResult validate(Map<String, String> validateMap) {
        for (String standartField : standartRelaxTour) {
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
            } else validatorResult.addResult(counterLine, "Uncorrect field name");
            log.warn("RelaxTourValidator error uncorrect field name in " + counterLine);
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
            validatorResult.addResult(counterLine, "Uncorrect value field transportType in RelaxTour");
            log.warn("uncorrect value field transportType in RelaxTour in " + counterLine);
        }
    }

    public void validateNutritionType(String nutritionType) {
        boolean flag = false;
        NutritionType[] nutritionTypeArr = NutritionType.values();
        for (by.epam.training.travelpackage.entity.NutritionType type : nutritionTypeArr) {
            if (type.toString().equalsIgnoreCase(nutritionType)) {
                flag = true;
            }
        }
        if (!flag) {
            validatorResult.addResult(counterLine, "Uncorrect value field nutritionType");
            log.warn("Uncorrect value field nutritionType in RelaxTour in" + counterLine);
        }
    }

    public void validateDuration(String duration) {
        Integer durationInt = Integer.valueOf(duration);
        if (!(durationInt >= minDuration && durationInt <= maxDuration)) {
            validatorResult.addResult(counterLine, "Uncorrect value field duration");
            log.warn("Uncorrect value field duration in RelaxTour in " + counterLine);
        }
    }

    public void validatePrice(String price) {
        Double priceDouble = Double.valueOf(price);
        if (!(priceDouble >= minPrice && priceDouble <= maxPrice)) {
            validatorResult.addResult(counterLine, "Uncorrect value field price");
            log.warn("Uncorrect value field price in RelaxTour in" + counterLine);
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
            validatorResult.addResult(counterLine, "Uncorrect value field country");
            log.warn("Uncorrect value field countryName in RelaxTour in" + counterLine);
        }
    }

    public void validateHotCountry(String hotCountry) {
        if (!("true".equalsIgnoreCase(hotCountry) || "false".equalsIgnoreCase(hotCountry))) {
            validatorResult.addResult(counterLine, "Uncorrect value field hotCountry");
            log.warn("Uncorrect value field hotCountry in RelaxTour in "+ counterLine);
        }
    }

    public void validateHaveSea(String haveSea) {

        if (!("true".equalsIgnoreCase(haveSea) || "false".equalsIgnoreCase(haveSea))) {
            validatorResult.addResult(counterLine, "Uncorrect value field haveSea");
            log.warn("Uncorrect value field haveSea in RelaxTour in" + counterLine);
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
