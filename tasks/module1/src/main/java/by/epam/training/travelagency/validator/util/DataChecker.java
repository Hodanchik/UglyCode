package by.epam.training.travelagency.validator.util;

import java.util.Locale;

public class DataChecker {

    public static boolean isInteger(String numbString) {
        try {
            Integer.parseInt(numbString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String numbString) {
        try {
            Double.parseDouble(numbString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBoolean(String boolString) {
        return "true".equalsIgnoreCase(boolString) || "false".equalsIgnoreCase(boolString);
    }
    public static boolean isCountry(String countryString) {
        Locale.setDefault(new Locale("en"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (countryString.equalsIgnoreCase(country)) {
                return true;
            }
        }return false;
    }


}
