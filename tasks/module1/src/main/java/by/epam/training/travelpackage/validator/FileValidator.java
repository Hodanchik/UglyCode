package by.epam.training.travelpackage.validator;

import org.apache.log4j.Logger;

import java.io.File;

public class FileValidator {
    private static final Logger log = Logger.getLogger(FileValidator.class);

    ValidatorResult validatorResult = new ValidatorResult();

    public FileValidator() {
    }

    public ValidatorResult validateFile(String path) {
        File file = new File(path);

        if (path == null) {
            validatorResult.addResult(0, "Null path");
            log.error("Null path");
            return validatorResult;
        }
        if (!file.isFile()) {
            validatorResult.addResult(0, "Nonexistent path to file");
            log.error("Nonexistent path to file");
            return validatorResult;
        }
        if (!path.substring(path.lastIndexOf(".") + 1).equals("txt")) {
            validatorResult.addResult(0, "Incorrect file format");
            log.error("Incorrect file format");
            return validatorResult;
        }
        return validatorResult;
    }
}
