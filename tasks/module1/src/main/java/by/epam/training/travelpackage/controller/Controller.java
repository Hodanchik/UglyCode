package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.builder.AbstractTourFactory;
import by.epam.training.travelpackage.parser.LineParser;
import by.epam.training.travelpackage.service.TravelTourService;
import by.epam.training.travelpackage.validator.DataReader;
import by.epam.training.travelpackage.validator.DataValidatorFactory;
import by.epam.training.travelpackage.validator.FileValidator;
import by.epam.training.travelpackage.validator.ValidatorResult;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class);
    ValidatorResult validatorResult;
    TravelTourService travelTourService;
    int counter = 1; //counter for line in file

    public Controller(TravelTourService travelTourService) {
        this.travelTourService = travelTourService;
        validatorResult = new ValidatorResult();
    }

    public void saveEntityFromFile(String path) {
        validatorResult = new FileValidator().validateFile(path);
        if (validatorResult.isValidate()) {
            List<String> dateLine = new DataReader(validatorResult).ReadDate(path);
            if (validatorResult.isValidate()) {
                for (String date : dateLine) {
                    Map<String, String> dateMap = new LineParser(counter, validatorResult).parseLine(date);
                    if (validatorResult.isValidate()) {
                        validatorResult = new DataValidatorFactory(counter, validatorResult).validateDate(dateMap);
                        if (validatorResult.isValidate()) {
                            travelTourService.saveTour(new AbstractTourFactory().buildTour(dateMap));
                        }
                        counter++;
                    }
                }
            } else {
                log.warn("File is not validate");
            }
        }
    }
}

