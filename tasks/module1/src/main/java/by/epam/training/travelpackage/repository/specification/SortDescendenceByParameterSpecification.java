package by.epam.training.travelpackage.repository.specification;

import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.repository.Specification;
import org.apache.log4j.Logger;

public class SortDescendenceByParameterSpecification implements Specification<TravelTour> {

    private static final Logger log = Logger.getLogger(SortDescendenceByParameterSpecification.class);

    private final String parameter;

    public SortDescendenceByParameterSpecification(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean match(TravelTour entity) {
        try {
            return entity.getClass().getDeclaredField(parameter).getName().equals(parameter);
        } catch (NoSuchFieldException e) {
            log.error("NoSuchFieldException" );
            e.printStackTrace();
        }
        return false;
    }
}

