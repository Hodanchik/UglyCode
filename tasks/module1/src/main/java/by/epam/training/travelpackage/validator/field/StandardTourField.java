package by.epam.training.travelpackage.validator.field;

import java.util.Optional;
import java.util.stream.Stream;

public enum StandardTourField {
    TRANSPORTTYPE, NUTRITIONTYPE, DURATION, PRICE;

    public static Optional<StandardTourField> fromString(String type) {
        return Stream.of(StandardTourField.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
