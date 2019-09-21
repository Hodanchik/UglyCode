package by.epam.training.travelpackage.entity;

import java.util.Optional;
import java.util.stream.Stream;

public enum TourType {
    RELAX, EXCURSION, MEDICAL, SHOP;

    public static Optional<TourType> fromString(String type) {
        return Stream.of(TourType.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}