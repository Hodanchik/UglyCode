package by.epam.training.travelpackage.controller.validator;

import org.apache.log4j.Logger;

import java.io.File;

public class FileValidator {
    private static final Logger log = Logger.getLogger(FileValidator.class);

    ValidatorResult validatorResult = new ValidatorResult();
    public FileValidator() {
    }
    public ValidatorResult validateFile(String path) {
        File file = new File(path);

        if (!file.isFile()) {
            validatorResult.addResult(0,  "Nonexistent path to file" );
            log.error("Nonexistent path to file");
        }
        if (!path.substring(path.lastIndexOf(".") + 1).equals("txt")) {
            validatorResult.addResult(0, "Incorrect file format");
            log.error("Incorrect file format");
        }
        return validatorResult;

    }
}
