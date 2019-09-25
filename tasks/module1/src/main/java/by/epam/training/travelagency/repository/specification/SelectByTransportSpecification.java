package by.epam.training.travelagency.repository.specification;
import by.epam.training.travelagency.entity.TransportType;
import by.epam.training.travelagency.entity.TravelTour;
import by.epam.training.travelagency.repository.Specification;
import org.apache.log4j.Logger;

public class SelectByTransportSpecification implements Specification<TravelTour> {

    private static final Logger log = Logger.getLogger(SelectByTransportSpecification.class);

    private final TransportType transportType;

    public SelectByTransportSpecification(TransportType transportType) {
        this.transportType = transportType;
    }
    @Override
    public boolean match(TravelTour entity) {
        return entity.getTransportType() == transportType;
    }
}
