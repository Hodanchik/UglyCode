package by.epam.training.travelpackage.controller;

import by.epam.training.travelpackage.controller.builder.AbstractTourFactory;
import by.epam.training.travelpackage.controller.validator.*;
import by.epam.training.travelpackage.service.TravelTourService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class);
    ValidatorResult validatorResult = new ValidatorResult();
    int counter = 1; //counter for line in file

    public Controller() {
    }

    public void saveEntityFromFile(String path, TravelTourService travelTourService) {
        validatorResult = new FileValidator().validateFile(path);
        if (validatorResult.isValidate()) {
            List<String> dateLine = new DataReader().ReadDate(path);
            for (String date : dateLine) {
                Map<String, String> dateMap = new LineParser(counter).parseLine(date);
                validatorResult = new DataValidatorFactory(counter).validateDate(dateMap);
                if (validatorResult.isValidate()) {
                    travelTourService.save(new AbstractTourFactory().buildTour(dateMap));
                }
                counter++;
            }
        } else {
            log.warn("File is not validate");
        }
    }
}

