package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.service.TravelTourService;

public class SortDescByDuration implements Command {
    private TravelTourService travelTourService;

    public SortDescByDuration(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.sortDescendenceByDuration();
    }
}
