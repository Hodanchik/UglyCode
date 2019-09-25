package by.epam.training.travelagency.entity;

import java.util.Optional;
import java.util.stream.Stream;

public enum TransportType {
    AIRPLANE, BUS, TRAIN, CRUISE_SHIP;

    public static Optional<TransportType> fromString(String type) {
        return Stream.of(TransportType.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
