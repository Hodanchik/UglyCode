package controller;

import model.TextLeaf;
import org.apache.log4j.Logger;
import parser.ParserChain;
import repository.ParagraphRepositoryImpl;
import repository.SentenceRepositoryImpl;
import repository.TextRepositoryImpl;
import repository.WordRepositoryImpl;
import service.*;
import validator.FileReader;
import validator.FileValidator;
import validator.ValidatorResult;

public class TextController {
    private static final Logger log = Logger.getLogger(TextController.class);
    private FileValidator fileValidator;
    private FileReader fileReader;
    private ParserChain<TextLeaf> textParser;
    private TextRepositoryImpl textRepository;
    private EntireTextService entireTextService;
    private ParagraphRepositoryImpl paragraphRepository;
    private ParagraphService paragraphService;
    private SentenceRepositoryImpl sentenceRepository;
    private SentenceService sentenceService;
    private WordRepositoryImpl wordRepository;
    private WordService wordService;

    public ParagraphRepositoryImpl getParagraphRepository() {
        return paragraphRepository;
    }

    public void setParagraphRepository(ParagraphRepositoryImpl paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    public TextController(FileValidator fileValidator, FileReader fileReader, ParserChain<TextLeaf> textParser,
                          TextRepositoryImpl textRepository, EntireTextService entireTextService,
                          ParagraphRepositoryImpl paragraphRepository, ParagraphService paragraphService,
                          SentenceRepositoryImpl sentenceRepository, SentenceService sentenceService,
                          WordRepositoryImpl wordRepository, WordService wordService) {
        this.fileValidator = fileValidator;
        this.fileReader = fileReader;
        this.textParser = textParser;
        this.textRepository = textRepository;
        this.entireTextService = entireTextService;
        this.paragraphRepository = paragraphRepository;
        this.paragraphService = paragraphService;
        this.sentenceRepository = sentenceRepository;
        this.sentenceService = sentenceService;
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }

    public void saveTextFromFile(String path) {
        ValidatorResult validatorResult = fileValidator.validateFile(path);
        if (validatorResult.isValidate()) {
            String text = fileReader.readData(path);
            TextLeaf parseText = textParser.parse(text);
            parseText.save();
           // entireTextService.saveText(textParser.parse(text));
        } else {
            log.warn("File is not validate");
        }
    }

}
