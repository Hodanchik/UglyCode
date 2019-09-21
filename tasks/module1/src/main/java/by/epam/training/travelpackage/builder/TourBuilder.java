package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.TravelTour;

import java.util.Map;

public interface TourBuilder {
    public TravelTour buildTour(Map<String, String> validateMap);
}
