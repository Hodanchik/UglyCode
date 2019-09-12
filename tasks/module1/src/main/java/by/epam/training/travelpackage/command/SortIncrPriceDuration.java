package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.service.TravelTourService;

public class SortIncrPriceDuration implements Command {
    private TravelTourService travelTourService;

    public SortIncrPriceDuration(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.sortIncreasByPriceAndDuration();
    }
}
