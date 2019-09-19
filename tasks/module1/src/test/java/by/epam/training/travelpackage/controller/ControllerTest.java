package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.service.TravelTourService;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ControllerTest {
    TravelTourService travelTourService = new TravelTourService();
    @Test
    public void saveEntityFromFileSuccessTest() {
        Controller contr = new Controller();
        int expectedSize = 9;
        contr.saveEntityFromFile("src/test/resources/testsuccess.txt", travelTourService);
        assertEquals(expectedSize, travelTourService.getTravelTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidPathTest() {
        Controller contr = new Controller();
        contr.saveEntityFromFile("src/test/resources/test123.txt", travelTourService);
        assertEquals(contr.validatorResult.isValidate(), false);
    }
    @Test
    public void saveEntityFromFileNoValidDateOneTest() {
        //field Tour Type invalid
        Controller contr = new Controller();
        int expectedSize = 2;
        contr.saveEntityFromFile("src/test/resources/testone.txt", travelTourService);
        assertEquals(expectedSize, travelTourService.getTravelTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidDateTwoTest() {
        //missing required fields
        Controller contr = new Controller();
        int expectedSize = 3;
        contr.saveEntityFromFile("src/test/resources/testtwo.txt", travelTourService);
        assertEquals(expectedSize, travelTourService.getTravelTourList().size());
    }
    @Test
    public void saveEntityFromFileNoValidDateFourTest() {
        //Miss TourType field
        Controller contr = new Controller();
        int expectedSize = 3;
        contr.saveEntityFromFile("src/test/resources/testfour.txt", travelTourService);
        assertEquals(expectedSize, travelTourService.getTravelTourList().size());
    }
}