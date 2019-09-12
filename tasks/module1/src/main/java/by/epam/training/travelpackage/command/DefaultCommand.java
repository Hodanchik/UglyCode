package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.service.TravelTourService;

import java.util.List;

public class DefaultCommand implements Command {
    private TravelTourService travelTourService;

    public DefaultCommand(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.getTravelTourList();
    }
}
