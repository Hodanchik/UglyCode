package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.repository.TravelTourRepository;
import by.epam.training.travelpackage.service.TravelTourService;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    TravelTourRepository tourRepository = new TravelTourRepository();
    TravelTourService travelTourService = new TravelTourService(tourRepository);
    Controller contr = new Controller(travelTourService);
    ClassLoader classLoader = getClass().getClassLoader();
    @Test
    public void saveEntityFromFileSuccessTest() {
        int expectedSize = 9;
        String path = new File(classLoader.getResource("testsuccess").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepository().getTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidPathTest() {
        File file = new File(classLoader.getResource("test123").getFile());
        contr.saveEntityFromFile(file.getAbsolutePath());
        assertEquals(contr.validatorResult.isValidate(), false);
    }
    @Test
    public void saveEntityFromFileNoValidDateOneTest() {
        //field Tour Type invalid
        int expectedSize = 2;
        File file = new File(classLoader.getResource("testone").getFile());
        contr.saveEntityFromFile(file.getAbsolutePath());
        assertEquals(expectedSize, travelTourService.getTravelTourRepository().getTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidDateTwoTest() {
        //missing required fields
        int expectedSize = 3;
        File file = new File(classLoader.getResource("testthree").getFile());
        contr.saveEntityFromFile(file.getAbsolutePath());
        assertEquals(expectedSize, travelTourService.getTravelTourRepository().getTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidDateFourTest() {
        //Miss TourType field
        int expectedSize = 3;
        File file = new File(classLoader.getResource("testfour").getFile());
        contr.saveEntityFromFile(file.getAbsolutePath());
        assertEquals(expectedSize, travelTourService.getTravelTourRepository().getTourList().size());
    }
}