package by.epam.training.travelagency.controller;

import by.epam.training.travelagency.parser.LineParser;
import by.epam.training.travelagency.repository.TravelTourRepositoryImpl;
import by.epam.training.travelagency.service.TravelTourService;
import by.epam.training.travelagency.validator.DataReader;
import by.epam.training.travelagency.validator.FileValidator;
import by.epam.training.travelagency.validator.TourValidatorFactory;
import by.epam.training.travelagency.validator.TypeValidator;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class TourControllerTest {
    TravelTourRepositoryImpl tourRepository = new TravelTourRepositoryImpl();
    TravelTourService travelTourService = new TravelTourService(tourRepository);
    private FileValidator fileValidator = new FileValidator();
    private DataReader dataReader = new DataReader();
    private LineParser lineParser = new LineParser();
    private TourValidatorFactory tourValidatorFactory = new TourValidatorFactory();
    private TypeValidator typeValidator = new TypeValidator();
    TourController contr = new TourController(travelTourService, fileValidator, dataReader, lineParser, tourValidatorFactory, typeValidator);
    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void saveNineTourFromFile() {
        int expectedSize = 9;
        String path = new File(Objects.requireNonNull(classLoader.getResource("testsuccess.txt")).getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }

    @Test
    public void NoValidPath() {
        //Nonexistent path
        contr.saveEntityFromFile("test123.txt");
        int expectedSize = 0;
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }

    @Test
    public void saveTwoTourFromFile() {
        //field Tour Type invalid
        int expectedSize = 2;
        String path = new File(Objects.requireNonNull(classLoader.getResource("testone.txt")).getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }

    @Test
    public void saveThreeTourFromFile() {
        //missing required fields
        int expectedSize = 3;
        String path = new File(Objects.requireNonNull(classLoader.getResource("testtwo.txt")).getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }

    @Test
    public void saveFourValidTourFromFile() {
        //Incorrect value of fields
        int expectedSize = 4;
        String path = new File(Objects.requireNonNull(classLoader.getResource("testthree.txt")).getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }

    @Test
    public void saveFiveValidTourFromFile() {
        //Miss TourType field
        int expectedSize = 5;
        String path = new File(Objects.requireNonNull(classLoader.getResource("testfour.txt")).getFile()).getAbsolutePath();
        contr.saveEntityFromFile(path);
        assertEquals(expectedSize, tourRepository.getTourList().size());
    }
}