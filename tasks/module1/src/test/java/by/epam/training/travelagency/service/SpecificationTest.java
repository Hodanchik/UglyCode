package by.epam.training.travelagency.service;

import by.epam.training.travelagency.entity.*;
import by.epam.training.travelagency.repository.Specification;
import by.epam.training.travelagency.repository.TravelTourRepositoryImpl;
import by.epam.training.travelagency.repository.specification.*;
import by.epam.training.travelagency.service.comparator.DurationDescendenceComparator;
import by.epam.training.travelagency.service.comparator.DurationIncreaseComparator;
import by.epam.training.travelagency.service.comparator.PriceDescendenceComparator;
import by.epam.training.travelagency.service.comparator.PriceIncreaseComparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class SpecificationTest {
    TravelTourRepositoryImpl tourRepository = new TravelTourRepositoryImpl();
    TravelTourService travelTourService = new TravelTourService(tourRepository);

    @Before
    public void init() {
        travelTourService.saveTour(new TravelTour(TourType.MEDICAL, TransportType.TRAIN, NutritionType.AIP, 6, 65.5));
        travelTourService.saveTour(new TravelTour(TourType.SHOP, TransportType.AIRPLANE, NutritionType.AIP, 6, 23.5));
        travelTourService.saveTour(new RelaxTour(TransportType.TRAIN, NutritionType.RO, 23, 8.99));
        travelTourService.saveTour(new TravelTour(TourType.EXCURSION, TransportType.AIRPLANE, NutritionType.AI, 19, 213.5));
        travelTourService.saveTour(new TravelTour(TourType.EXCURSION, TransportType.BUS, NutritionType.RO, 10, 222.5));
        travelTourService.saveTour(new TravelTour(TourType.RELAX, TransportType.BUS, NutritionType.AIP, 12, 243.5));
    }

    @Test
    public void SelectByNutritionSpecificationTest() {
        //test
        SelectByNutritionSpecification spec = new SelectByNutritionSpecification(NutritionType.RO);
        List<TravelTour> allByParameter = tourRepository.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.size(), 2);
    }

    @Test
    public void SelectByTransportSpecificationTest() {
        //test
        SelectByTransportSpecification spec = new SelectByTransportSpecification(TransportType.TRAIN);
        List<TravelTour> allByParameter = tourRepository.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.size(), 2);
    }

    @Test
    public void SelectByTourTypeSpecificationTest() {
        //test
        SelectByTourTypeSpecification spec = new SelectByTourTypeSpecification(TourType.RELAX);
        List<TravelTour> allByParameter = tourRepository.findAllByParameter(spec);
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.size(), 2);
    }

    @Test
    public void sortByDurationIncreasTest() {
        Comparator<TravelTour>  durationComparator = new DurationIncreaseComparator();
        List<TravelTour> sortByDurationIncreas  = travelTourService.sort(durationComparator);
        Assert.assertTrue(sortByDurationIncreas.get(0).getDuration() <= sortByDurationIncreas.get(1).getDuration() &&
                sortByDurationIncreas.get(1).getDuration() <= sortByDurationIncreas.get(2).getDuration());
    }
    @Test
    public void sortByDurationDescendenceTest() {
        Comparator<TravelTour>  durationComparator = new DurationDescendenceComparator();
        List<TravelTour> sortByDurationDescendence  = travelTourService.sort(durationComparator);
        Assert.assertTrue(sortByDurationDescendence.get(0).getDuration() >= sortByDurationDescendence.get(1).getDuration() &&
                sortByDurationDescendence.get(1).getDuration() >= sortByDurationDescendence.get(2).getDuration());
    }
    @Test
    public void sortByPriceIncreasTest() {
        Comparator<TravelTour>  priceComparator = new PriceIncreaseComparator();
        List<TravelTour> sortByPriceIncreas  = travelTourService.sort(priceComparator);
        Assert.assertTrue(sortByPriceIncreas.get(0).getPrice() <= sortByPriceIncreas.get(1).getPrice() &&
                sortByPriceIncreas.get(1).getPrice() <= sortByPriceIncreas.get(2).getPrice());
    }
    @Test
    public void sortByPriceDescendenceTest() {
        Comparator<TravelTour>  priceComparator = new PriceDescendenceComparator();
        List<TravelTour> sortByPriceDescendence  = travelTourService.sort(priceComparator);
        Assert.assertTrue(sortByPriceDescendence.get(0).getPrice() >= sortByPriceDescendence.get(1).getPrice() &&
                sortByPriceDescendence.get(1).getPrice() >= sortByPriceDescendence.get(2).getPrice());
    }
    @Test
    public void sortByDurationAndPrice() {
        Comparator<TravelTour>  durationComparator = new DurationIncreaseComparator();
        Comparator<TravelTour>  priceComparator = new PriceIncreaseComparator();
        Comparator<TravelTour> durationAndPriceComparator = durationComparator.thenComparing(priceComparator);
        List<TravelTour> sortedTour = travelTourService.sort(durationAndPriceComparator);
        Assert.assertEquals(sortedTour.get(0).getPrice(), 23.5, 0);
    }


    @Test
    public void SortIncreasByParameterSpecificationTest() {
        //test
        SortIncreaseByParameterSpecification spec = new SortIncreaseByParameterSpecification("duration");
        List<TravelTour> allByParameter = travelTourService.sortIncreaseByParameter(spec, "duration");
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.get(5).getDuration(), 23);
    }

    @Test
    public void SortDescendenceByParameterTest() {
        //test
        SortDescendenceByParameterSpecification spec = new SortDescendenceByParameterSpecification("price");
        List<TravelTour> allByParameter = travelTourService.sortDescendenceByParameter(spec, "price");
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.get(5).getPrice(), 8.99, 0);
    }

    @Test
    public void SelectByTwoParametersSpecificationTest() {
        //test
        SelectByTourTypeSpecification spec = new SelectByTourTypeSpecification(TourType.RELAX);
        Specification<TravelTour> and = spec.and(new SelectByTransportSpecification(TransportType.TRAIN));
        List<TravelTour> allByParameter = travelTourService.getAllByParameter(and);
        //assert
        Assert.assertNotNull(allByParameter);
        Assert.assertEquals(allByParameter.size(), 1);
    }

    @Test
    public void SortByTwoParametersSpecificationTest() {
        //test
        SortIncreaseByParameterSpecification spec = new SortIncreaseByParameterSpecification("duration");
        List<TravelTour> sortByTwoParameter = travelTourService.sortIncreaseByTwoParameter(spec, "duration",
                "price");
        //assert
        Assert.assertNotNull(sortByTwoParameter);
        Assert.assertEquals(sortByTwoParameter.get(0).getPrice(), 23.5, 0);
    }
}


