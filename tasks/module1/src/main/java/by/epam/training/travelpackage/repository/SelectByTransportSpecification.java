package by.epam.training.travelpackage.repository;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;

public class SelectByTransportSpecification implements Specification<TravelTour> {
    private final TransportType transportType;

    public SelectByTransportSpecification(TransportType transportType) {
        this.transportType = transportType;
    }
    @Override
    public boolean match(TravelTour entity) {
        return entity.getTransportType() == transportType;
    }
}
