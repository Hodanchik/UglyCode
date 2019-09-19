package by.epam.training.travelpackage.controller.validator;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    private static final Logger log = Logger.getLogger(DataReader.class);
    private List<String> lines;
    public List<String> ReadDate(String path) {
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Can't read file", e);
            e.printStackTrace();
        }
        return lines;
    }


}
