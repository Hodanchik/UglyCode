package by.epam.training.travelagency.service.comparator;

import by.epam.training.travelagency.entity.TravelTour;

import java.util.Comparator;

public class PriceIncreaseComparator implements Comparator<TravelTour> {
    @Override
    public int compare(TravelTour tour1, TravelTour tour2) {
        return Double.compare(tour1.getPrice(), tour2.getPrice());
    }
}
