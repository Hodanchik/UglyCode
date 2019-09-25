package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.TravelTour;

import java.util.Map;

public interface TourBuilder {
    TravelTour buildTour(Map<String, String> validateMap);
}
