package by.epam.training.travelpackage.repository.specification;

import by.epam.training.travelpackage.entity.TourType;
import by.epam.training.travelpackage.entity.TravelTour;
import org.apache.log4j.Logger;

public class SelectByTourTypeSpecification implements Specification<TravelTour> {
    private static final Logger log = Logger.getLogger(SelectByTourTypeSpecification.class);

    private final TourType tourType;

    public SelectByTourTypeSpecification(TourType tourType) {
        this.tourType = tourType;
    }

    @Override
    public boolean match(TravelTour entity) {
        return entity.getTourType() == tourType;
    }
}
