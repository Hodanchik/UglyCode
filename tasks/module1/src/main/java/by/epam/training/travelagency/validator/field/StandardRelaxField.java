package by.epam.training.travelagency.validator.field;

import java.util.Optional;
import java.util.stream.Stream;

public enum StandardRelaxField {
    TOURTYPE, TRANSPORTTYPE, NUTRITIONTYPE, DURATION, PRICE, COUNTRY, HOTCOUNTRY, HAVESEA, HOTELSTARSTYPE;

    public static Optional<StandardRelaxField> fromString(String type) {
        return Stream.of(StandardRelaxField.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
