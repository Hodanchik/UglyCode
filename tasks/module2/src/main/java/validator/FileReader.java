package validator;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final Logger log = Logger.getLogger(FileReader.class);
    private List<String> lines = new ArrayList<>();
    private StringBuilder text = new StringBuilder();

    public String readData(String path) {
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for (String line : lines) {
                text.append(line);
            }
            return String.valueOf(text);
        } catch (IOException e) {
            log.error("Can't read file", e);
        }
        return String.valueOf(text);
    }
}
