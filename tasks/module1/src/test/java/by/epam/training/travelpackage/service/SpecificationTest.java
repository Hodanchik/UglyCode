package by.epam.training.travelpackage.service;

import by.epam.training.travelpackage.entity.*;
import by.epam.training.travelpackage.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SpecificationTest {
    TravelTourService travelTourService = new TravelTourService();

    @Before
    public void init() {
        travelTourService.save(new TravelTour(TourType.MEDICAL, TransportType.TRAIN, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new TravelTour(TourType.SHOP, TransportType.AIRPLANE, NutritionType.AIP, 6, 23.5));
        travelTourService.save(new RelaxTour(TransportType.TRAIN, NutritionType.RO, 23, 8.99));
        travelTourService.save(new TravelTour(TourType.EXCURSION, TransportType.AIRPLANE, NutritionType.AI, 19, 213.5));
        travelTourService.save(new TravelTour(TourType.EXCURSION, TransportType.BUS, NutritionType.RO, 10, 222.5));
        travelTourService.save(new TravelTour(TourType.RELAX, TransportType.BUS, NutritionType.AIP, 12, 243.5));
    }

    @Test
    public void SelectByNutritionSpecificationTest() {
        //test
        SelectByNutritionSpecification spec = new SelectByNutritionSpecification(NutritionType.RO);
        List<TravelTour> allByParametr = travelTourService.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.size(), 2);
    }

    @Test
    public void SelectByTransportSpecificationTest() {
        //test
        SelectByTransportSpecification spec = new SelectByTransportSpecification(TransportType.TRAIN);
        List<TravelTour> allByParametr = travelTourService.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.size(), 1);
    }

    @Test
    public void SelectByTourTypeSpecificationTest() {
        //test
        SelectByTourTypeSpecification spec = new SelectByTourTypeSpecification(TourType.RELAX);
        List<TravelTour> allByParametr = travelTourService.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.size(), 2);
    }

    @Test
    public void SortIncreasByParameterSpecificationTest() {
        //test
        SortIncreasByParameterSpecification spec = new SortIncreasByParameterSpecification("duration");
        List<TravelTour> allByParametr = travelTourService.sortIncreasByParameter(spec, "duration");
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.get(5).getDuration(), 23);
    }

    @Test
    public void SortDescendenceByParameterTest() {
        //test
        SortDescendenceByParameterSpecification spec = new SortDescendenceByParameterSpecification("duration");
        List<TravelTour> allByParametr = travelTourService.sortDescendenceByParameter(spec, "price");
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.get(5).getPrice(), 8.99, 0);
    }

    @Test
    public void SelectByTwoParametersSpecificationTest() {
        //test
        SelectByTourTypeSpecification spec = new SelectByTourTypeSpecification(TourType.RELAX);
        Specification<TravelTour> and = spec.and(new SelectByTransportSpecification(TransportType.TRAIN));
        List<TravelTour> allByParametr = travelTourService.findAllByParameter(and);
        //assert
        Assert.assertNotNull(allByParametr);
        Assert.assertEquals(allByParametr.size(), 1);
    }
}


