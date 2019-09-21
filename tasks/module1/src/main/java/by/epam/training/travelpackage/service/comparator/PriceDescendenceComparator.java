package by.epam.training.travelpackage.service.comparator;

import by.epam.training.travelpackage.entity.TravelTour;

import java.util.Comparator;

public class PriceDescendenceComparator implements Comparator<TravelTour> {
    @Override
    public int compare(TravelTour tour1, TravelTour tour2) {
        return Double.compare(tour2.getPrice(), tour1.getPrice());
    }
}

