package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.builder.TourFactory;
import by.epam.training.travelpackage.parser.LineParser;
import by.epam.training.travelpackage.service.TravelTourService;
import by.epam.training.travelpackage.validator.DataReader;
import by.epam.training.travelpackage.validator.DataValidatorFactory;
import by.epam.training.travelpackage.validator.FileValidator;
import by.epam.training.travelpackage.validator.ValidatorResult;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class TourController {
    private static final Logger log = Logger.getLogger(TourController.class);
    private TravelTourService travelTourService;

    public TourController(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
    }

    public void saveEntityFromFile(String path) {
        ValidatorResult validatorResult = new FileValidator().validateFile(path);
        if (validatorResult.isValidate()) {
            List<String> dateLine = new DataReader().ReadDate(path);
            for (String date : dateLine) {
                int counter = dateLine.indexOf(date) + 1; //counter for line in file
                Map<String, String> dateMap = new LineParser(counter).parseLine(date);
                validatorResult = new DataValidatorFactory(counter).validateDate(dateMap);
                if (validatorResult.isValidate()) {
                    travelTourService.saveTour(new TourFactory().buildTour(dateMap));
                }
            }
        } else {
            log.warn("File is not validate");
        }
    }
}

