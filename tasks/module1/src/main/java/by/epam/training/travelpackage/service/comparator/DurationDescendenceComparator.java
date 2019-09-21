package by.epam.training.travelpackage.service.comparator;

import by.epam.training.travelpackage.entity.TravelTour;

import java.util.Comparator;

public class DurationDescendenceComparator implements Comparator<TravelTour> {
    @Override
    public int compare(TravelTour tour1, TravelTour tour2) {
        return Integer.compare(tour2.getDuration(), tour1.getDuration());
    }
}
