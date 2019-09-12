package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.service.TravelTourService;


public class CommandFactory {
    private TravelTourService travelTourService;

    public CommandFactory(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    public Command getByType(CommandType commandType) {
        switch (commandType) {
            case SELECT_BY_AIRPLANE:
                return new SelectByAirplane(travelTourService);
            case SELECT_BY_BUS:
                return new SelectByBus(travelTourService);
            case SELECT_BY_TRAIN:
                return new SelectByTrain(travelTourService);
            case SELECT_BY_CRUISE_SHIP:
                return new SelectByCruiseShip(travelTourService);
            case SELECT_BY_NUTRITION_RO:
                return new SelectByNutritionRo(travelTourService);
            case SELECT_BY_TOUR_TYPE_RELAX:
                return new SelectByTourTypeRelax(travelTourService);
            case SORT_INCREASE_BY_DURATION:
                return new SortIncreaseByDuration(travelTourService);
            case SORT_DESCREASE_BY_DURATION:
                return new SortDescByDuration(travelTourService);
            case SORT_INCREASE_BY_PRICE_DURATION:
                return new SortIncrPriceDuration(travelTourService);
            default:
                return new DefaultCommand(travelTourService);
        }

    }
}
