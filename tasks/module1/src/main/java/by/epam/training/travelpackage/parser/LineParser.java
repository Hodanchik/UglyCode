package by.epam.training.travelpackage.parser;

import by.epam.training.travelpackage.validator.DataReader;
import by.epam.training.travelpackage.validator.ValidatorResult;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    private static final Logger log = Logger.getLogger(DataReader.class);
    int counterLine;
    ValidatorResult validatorResult;

    public LineParser(int counterLine, ValidatorResult validatorResult) {
        this.counterLine = counterLine;
        this.validatorResult = validatorResult;
    }

    public Map<String, String> parseLine(String line) {
        Map<String, String> parseMap = new HashMap<>();
        String[] pairsField = line.split(",");
        if (pairsField.length != 0) {
            for (String pair : pairsField) {
                try {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length == 2) {
                        parseMap.put(keyValue[0], keyValue[1]);
                    } else {
                        validatorResult.addResult(0, "Uncorrect field:value in "
                                + counterLine + " line");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    log.error("Exception with parsing file, line" + " " + counterLine, e);
                    validatorResult.addResult(0, "Exception with parsing file, line "
                            + counterLine + " line");
                }
            }
        } else {
            validatorResult.addResult(0, "Line " + counterLine + " without parameters");
        }
        return parseMap;
    }
}

