package by.epam.training.travelagency.parser;

import by.epam.training.travelagency.validator.DataReader;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    private static final Logger log = Logger.getLogger(DataReader.class);
    private int counterLine;
    private static final String FIRST_SEPARATOR = ",";
    private static final String SECOND_SEPARATOR = ":";


    public Map<String, String> parseLine(String line) {
        Map<String, String> parseMap = new HashMap<>();
        String[] pairsField = line.split(FIRST_SEPARATOR);
        if (pairsField.length != 0) {
            for (String pair : pairsField) {
                try {
                    String[] keyValue = pair.split(SECOND_SEPARATOR);
                    if (keyValue.length == 2) {
                        parseMap.put(keyValue[0], keyValue[1]);
                    } else {
                        log.warn("Incorrect field:value in "
                                + counterLine + " line");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    log.error("Exception with parsing file, line" + " " + counterLine, e);
                }
            }
        } else {
            log.warn("Line " + counterLine + " without parameters");
        }
        return parseMap;
    }
}

