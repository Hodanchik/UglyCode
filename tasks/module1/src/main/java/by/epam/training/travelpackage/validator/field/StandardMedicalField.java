package by.epam.training.travelpackage.validator.field;

import java.util.Optional;
import java.util.stream.Stream;

public enum StandardMedicalField {
    TOURTYPE, TRANSPORTTYPE, NUTRITIONTYPE, DURATION, PRICE, MEDICALSUPPORT, COUNTRY;

    public static Optional<StandardMedicalField> fromString(String type) {
        return Stream.of(StandardMedicalField.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
