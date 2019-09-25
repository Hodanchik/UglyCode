package by.epam.training.travelagency.controller;

import by.epam.training.travelagency.builder.TourBuilderFactory;
import by.epam.training.travelagency.parser.LineParser;
import by.epam.training.travelagency.service.TravelTourService;
import by.epam.training.travelagency.validator.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class TourController {
    private static final Logger log = Logger.getLogger(TourController.class);
    private TravelTourService travelTourService;
    private FileValidator fileValidator;
    private DataReader dataReader;
    private LineParser lineParser;
    private TourValidatorFactory tourValidatorFactory;
    private TypeValidator typeValidator;

    public TourController(TravelTourService travelTourService, FileValidator fileValidator, DataReader dataReader,
                          LineParser lineParser, TourValidatorFactory tourValidatorFactory, TypeValidator typeValidator) {
        this.travelTourService = travelTourService;
        this.fileValidator = fileValidator;
        this.dataReader = dataReader;
        this.lineParser = lineParser;
        this.tourValidatorFactory = tourValidatorFactory;
        this.typeValidator = typeValidator;
    }

    public void saveEntityFromFile(String path) {
        ValidatorResult validatorResult = fileValidator.validateFile(path);
        if (validatorResult.isValidate()) {
            List<String> dataLine = dataReader.ReadData(path);
            int count = 1;//counter for line in file
            for (String data : dataLine) {
                Map<String, String> dataMap = lineParser.parseLine(data);
                validatorResult = typeValidator.validateType(dataMap);
                if (validatorResult.isValidate()) {
                    validatorResult = tourValidatorFactory
                            .getValidatorByType(dataMap.get("tourType")).validate(dataMap);
                    if (validatorResult.isValidate()) {
                        travelTourService.saveTour(new TourBuilderFactory()
                                .getBuilderByType(dataMap.get("tourType")).buildTour(dataMap));
                    }
                    count++;
                }
            }
        } else {
            log.warn("File is not validate");
        }
    }
}

