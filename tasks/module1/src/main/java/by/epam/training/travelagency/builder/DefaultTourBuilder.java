package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.NutritionType;
import by.epam.training.travelagency.entity.TourType;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.entity.TravelTour;

import java.util.Map;

public class DefaultTourBuilder implements TourBuilder {

    TourType tourType;
    TransportType transportType;
    NutritionType nutritionType;
    int duration;
    double price;

    @Override
    public TravelTour buildTour(Map<String, String> validateMap) {
        //this code never will call
        return new TravelTour(tourType, transportType, nutritionType, duration, price);
    }
}
