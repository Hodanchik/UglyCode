package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.entity.TransportType;

import by.epam.training.travelpackage.service.TravelTourService;

public class SelectByTransport implements Command {
    private TravelTourService travelTourService;
    private TransportType transportType;

    public SelectByTransport(TravelTourService travelTourService, TransportType transportType) {
        this.travelTourService = travelTourService;
        this.transportType = transportType;
    }

    @Override
    public Object execute() {
       return travelTourService.selectByTransport(transportType);
    }
}
