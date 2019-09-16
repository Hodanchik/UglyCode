package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.entity.TravelTour;
import org.apache.log4j.Logger;

public class SortIncreasByParameterSpecification implements Specification<TravelTour> {
    private static final Logger log = Logger.getLogger(SortIncreasByParameterSpecification.class);

    private final String parameter;

    public SortIncreasByParameterSpecification(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean match(TravelTour entity) {
        try {
            return entity.getClass().getDeclaredField(parameter).getName().equals(parameter);
        } catch (NoSuchFieldException e) {
            log.error("NoSuchFieldException");
            e.printStackTrace();
        }
        return false;
    }
}
