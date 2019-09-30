package validator;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {
    private static final Logger log = Logger.getLogger(FileValidator.class);

    private ValidatorResult validatorResult = new ValidatorResult();

    public ValidatorResult validateFile(String pathString) {
        if (pathString == null) {
            validatorResult.addResult("File is no valid", "Null path");
            log.error("Null path");
            return validatorResult;
        }
        File file = new File(pathString);
        Path path = Paths.get(pathString);
        if (!file.isFile()) {
            validatorResult.addResult("File is no valid", "Nonexistent path to file");
            log.error("Nonexistent path to file");
            return validatorResult;
        }
        if (!Files.isReadable(path)) {
            validatorResult.addResult("File is no valid", "File can't be read");
            log.error("File can't be read");
            return validatorResult;
        }
        if (!pathString.substring(pathString.lastIndexOf(".") + 1).equals("txt")) {
            validatorResult.addResult("File is no valid", "Incorrect file format");
            log.error("Incorrect file format");
            return validatorResult;
        }
        try {
            FileChannel textFileChannel = FileChannel.open(path);
            if (textFileChannel.size() == 0) {
                validatorResult.addResult("File is no valid", "Empty file");
                log.warn("Empty file");

            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Incorrect file format");
        }

        return validatorResult;
    }
}
