package controller;

import model.TextLeaf;
import org.apache.log4j.Logger;
import parser.ParserChain;
import service.TextService;
import validator.FileReader;
import validator.FileValidator;
import validator.ValidatorResult;

public class TextController {
    private static final Logger log = Logger.getLogger(TextController.class);
    private FileValidator fileValidator;
    private FileReader fileReader;
    private ParserChain<TextLeaf> textParser;
    private TextService textService;


    public TextController(FileValidator fileValidator, FileReader fileReader, ParserChain textParser, TextService textService) {
        this.fileValidator = fileValidator;
        this.fileReader = fileReader;
        this.textParser = textParser;
        this.textService = textService;
    }

    public void saveTextFromFile(String path) {
        ValidatorResult validatorResult = fileValidator.validateFile(path);
        if (validatorResult.isValidate()) {
            String text = fileReader.readData(path);
            textService.saveText(textParser.parse(text));
        } else {
            log.warn("File is not validate");
        }
    }

}
