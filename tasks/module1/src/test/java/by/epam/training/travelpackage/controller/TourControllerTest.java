package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.repository.TravelTourRepositoryImpl;
import by.epam.training.travelpackage.service.TravelTourService;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TourControllerTest {
    TravelTourRepositoryImpl tourRepository = new TravelTourRepositoryImpl();
    TravelTourService travelTourService = new TravelTourService(tourRepository);
    TourController contr = new TourController(travelTourService);
    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void saveEntityFromFileSuccessTest() {
        int expectedSize = 9;
        String path = new File(classLoader.getResource("testsuccess.txt").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }

    @Test
    public void saveEntityFromFileNoValidPathTest() {
        //Nonexistent path
        contr.saveEntityFromFile("test123.txt");
        int expectedSize = 0;
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }

    @Test
    public void saveEntityFromFileNoValidDateOneTest() {
        //field Tour Type invalid
        int expectedSize = 2;
        String path = new File(classLoader.getResource("testone.txt").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }

    @Test
    public void saveEntityFromFileNoValidDateTwoTest() {
        //missing required fields
        int expectedSize = 3;
        String path = new File(classLoader.getResource("testtwo.txt").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }

    @Test
    public void saveEntityFromFileNoValidDateThreeTest() {
        //Incorrect value of fields
        int expectedSize = 2;
        String path = new File(classLoader.getResource("testthree.txt").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }

    @Test
    public void saveEntityFromFileNoValidDateFourTest() {
        //Miss TourType field
        int expectedSize = 3;
        String path = new File(classLoader.getResource("testfour.txt").getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, travelTourService.getTravelTourRepositoryImpl().getTourList().size());
    }
}