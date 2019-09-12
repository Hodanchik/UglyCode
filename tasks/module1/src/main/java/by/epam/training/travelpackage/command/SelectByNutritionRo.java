package by.epam.training.travelpackage.command;
import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.service.TravelTourService;

public class SelectByNutritionRo implements Command {
    private TravelTourService travelTourService;

    public SelectByNutritionRo(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    @Override
    public Object execute() {
        return travelTourService.selectByNutrition(NutritionType.RO);
    }
}
