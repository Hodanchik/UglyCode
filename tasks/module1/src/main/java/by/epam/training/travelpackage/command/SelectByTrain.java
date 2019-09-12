package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.service.TravelTourService;

public class SelectByTrain implements Command {
    private TravelTourService travelTourService;

    public SelectByTrain(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.selectByTransport(TransportType.TRAIN);
    }
}
