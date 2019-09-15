package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.entity.TourType;
import by.epam.training.travelpackage.entity.TravelTour;

public class SelectByTourTypeSpecification implements Specification<TravelTour> {
    private final TourType tourType;

    public SelectByTourTypeSpecification(TourType tourType) {
        this.tourType = tourType;
    }

    @Override
    public boolean match(TravelTour entity) {
        return entity.getTourType() == tourType;
    }
}
