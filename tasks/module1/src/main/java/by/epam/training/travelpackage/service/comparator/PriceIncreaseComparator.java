package by.epam.training.travelpackage.service.comparator;

import by.epam.training.travelpackage.entity.TravelTour;

import java.util.Comparator;

public class PriceIncreaseComparator implements Comparator<TravelTour> {
    @Override
    public int compare(TravelTour tour1, TravelTour tour2) {
        return Double.compare(tour1.getPrice(), tour2.getPrice());
    }
}
