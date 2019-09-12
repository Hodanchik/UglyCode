package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.service.TravelTourService;

public class SelectByCruiseShip implements Command {
    private TravelTourService travelTourService;

    public SelectByCruiseShip(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {

        return travelTourService.selectByTransport(TransportType.CRUISE_SHIP);
    }
}
