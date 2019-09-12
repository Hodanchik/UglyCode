package by.epam.training.travelpackage.command;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.RelaxTour;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.service.TravelTourService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void execute() {
    }

    @Test
public void SelectByAirplaneTest(){
        int executeCount = 2;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new TravelTour(TransportType.AIRPLANE, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.TRAIN, NutritionType.RO, 7, 23.5));
        travelTourService.save(new TravelTour(TransportType.AIRPLANE, NutritionType.AI, 9, 213.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 10, 222.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.AIP, 12, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SELECT_BY_AIRPLANE);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(executeCount, execute.size());

    }
    @Test
    public void SelectByBusTest(){
        int executeCount = 3;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.TRAIN, NutritionType.RO, 7, 23.5));
        travelTourService.save(new TravelTour(TransportType.AIRPLANE, NutritionType.AI, 9, 213.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 10, 222.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.AIP, 12, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SELECT_BY_BUS);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(executeCount, execute.size());
    }
    @Test
    public void SelectByuCruiseShipTest(){
        int executeCount = 5;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 7, 23.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AI, 9, 213.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 10, 222.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 12, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SELECT_BY_CRUISE_SHIP);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(executeCount, execute.size());
    }
    @Test
    public void SelectByuNutitionRo(){
        int executeCount = 2;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 7, 23.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AI, 9, 213.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 10, 222.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 12, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SELECT_BY_NUTRITION_RO);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(executeCount, execute.size());
    }
    @Test
    public void SelectByuTourRelax(){
        int executeCount = 3;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new RelaxTour(TransportType.BUS, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 7, 23.5));
        travelTourService.save(new RelaxTour(TransportType.AIRPLANE, NutritionType.AI, 9, 213.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 10, 222.5));
        travelTourService.save(new RelaxTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 12, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SELECT_BY_TOUR_TYPE_RELAX);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(executeCount, execute.size());
    }
    @Test
    public void SortIncreaseDurationTest(){
        int MAXDURATION = 32;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new RelaxTour(TransportType.BUS, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 7, 23.99));
        travelTourService.save(new RelaxTour(TransportType.AIRPLANE, NutritionType.AI, MAXDURATION, 213.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 10, 222.5));
        travelTourService.save(new RelaxTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 22, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SORT_INCREASE_BY_DURATION);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(MAXDURATION, execute.get(4).getDuration());
    }
    @Test
    public void SortDescByDurationTest(){
        int MAXDURATION = 32;
        TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new RelaxTour(TransportType.BUS, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 7, 23.99));
        travelTourService.save(new RelaxTour(TransportType.AIRPLANE, NutritionType.AI, MAXDURATION, 213.5));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 10, 222.5));
        travelTourService.save(new RelaxTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 22, 243.5));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SORT_DESCREASE_BY_DURATION);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        assertEquals(MAXDURATION, execute.get(0).getDuration());
    }
    @Test
    public void sortIncreasByPriceAndDurationTest(){
        int MAXPRICE = 700;
        int MAXDURATION = 32;
               TravelTourService travelTourService = new TravelTourService();
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TransportType.BUS, NutritionType.RO, 7, 23.99));
        travelTourService.save(new TravelTour(TransportType.AIRPLANE, NutritionType.AI, MAXDURATION, MAXPRICE));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.RO, 22, MAXPRICE));
        travelTourService.save(new TravelTour(TransportType.CRUISE_SHIP, NutritionType.AIP, 16, MAXPRICE));
        CommandFactory factory = new CommandFactory(travelTourService);
        Command command = factory.getByType(CommandType.SORT_INCREASE_BY_PRICE_DURATION);
        List<TravelTour> execute = (List<TravelTour>) command.execute();
        TravelTour executeTour = new TravelTour(TransportType.AIRPLANE, NutritionType.AI, MAXDURATION, MAXPRICE);
        assertEquals(executeTour, execute.get(4));
    }
}