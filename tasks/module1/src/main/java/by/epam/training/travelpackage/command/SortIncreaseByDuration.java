package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.service.TravelTourService;

public class SortIncreaseByDuration implements Command {
    private TravelTourService travelTourService;

    public SortIncreaseByDuration(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.sortIncreasByDuration();
    }
}
