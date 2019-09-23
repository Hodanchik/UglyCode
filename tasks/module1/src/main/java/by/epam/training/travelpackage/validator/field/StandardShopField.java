package by.epam.training.travelpackage.validator.field;

import java.util.Optional;
import java.util.stream.Stream;

public enum StandardShopField {
    TOURTYPE, TRANSPORTTYPE, NUTRITIONTYPE, DURATION, PRICE, COUNTRY, VISITDUTYFREE;

    public static Optional<StandardShopField> fromString(String type) {
        return Stream.of(StandardShopField.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
