package by.epam.training.travelagency.validator.field;

import java.util.Optional;
import java.util.stream.Stream;

public enum StandardExcursionField {
    TOURTYPE, TRANSPORTTYPE, NUTRITIONTYPE, DURATION, PRICE, COUNTCOUNTRY, LOCALGUIDE, NIGHTMOVING;

    public static Optional<StandardExcursionField> fromString(String type) {
        return Stream.of(StandardExcursionField.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
