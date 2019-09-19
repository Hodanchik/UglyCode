package by.epam.training.travelpackage.controller.validator;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    private static final Logger log = Logger.getLogger(DataReader.class);
    int counterLine;

    public LineParser(int counterLine) {
        this.counterLine = counterLine;
    }

    public  Map<String, String> parseLine(String line) {

        String[] pairsField = line.split(",");
        Map<String, String> parseMap = new HashMap<>();
        for (String pair : pairsField) {
            try {
                String[] keyValue = pair.split(":");
                parseMap.put(keyValue[0], keyValue[1]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                log.error("Exception with parsing file, line" + " " + counterLine, e);
            }
        }
        return parseMap;
    }
}

