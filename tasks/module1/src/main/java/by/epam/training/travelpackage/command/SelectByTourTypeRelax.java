package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.entity.RelaxTour;
import by.epam.training.travelpackage.service.TravelTourService;

public class SelectByTourTypeRelax implements Command {
    private TravelTourService travelTourService;

    public SelectByTourTypeRelax(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {

        return travelTourService.selectByTourType(RelaxTour.class);
    }
}
