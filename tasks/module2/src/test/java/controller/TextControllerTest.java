package controller;

import model.ParagraphComposite;
import model.SentenceComposite;
import model.TextLeaf;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.ParagraphParser;
import parser.ParserChain;
import parser.SentenceParser;
import parser.WordParser;
import repository.*;
import service.EntireTextService;
import service.ParagraphService;
import service.SentenceService;
import service.WordService;
import validator.FileReader;
import validator.FileValidator;

import java.io.File;
import java.util.Objects;


public class TextControllerTest {
    private  ClassLoader classLoader = getClass().getClassLoader();
    private  FileValidator fileValidator = new FileValidator();
    private  FileReader fileReader = new FileReader();
//    private ParserChain<TextLeaf> parser = new ParagraphParser().linkWith(new SentenceParser()).linkWith(new WordParser());
//    private TextRepositoryImpl textRepository = new TextRepositoryImpl();
//    private EntireTextService entireTextService = new EntireTextService(textRepository);
//    private ParagraphRepositoryImpl paragraphRepository = new ParagraphRepositoryImpl();
//    private ParagraphService paragraphService = new ParagraphService(paragraphRepository);
//    private SentenceRepositoryImpl sentenceRepository = new SentenceRepositoryImpl();
//    private SentenceService sentenceService = new SentenceService(sentenceRepository);
//    private WordRepositoryImpl wordRepository = new WordRepositoryImpl();
//    private WordService wordService = new WordService(wordRepository);

 private  static TextController textController;
    String text = "\tIt has survived not only five centuries, but also the leap into electronic\n" +
            "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
            "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
            "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n";

    @Test
    public void saveTextFromFileValid() {
        ParserChain<TextLeaf> parser = new ParagraphParser().linkWith(new SentenceParser()).linkWith(new WordParser());
        TextRepositoryImpl textRepository = new TextRepositoryImpl();
        EntireTextService entireTextService = new EntireTextService(textRepository);
        ParagraphRepositoryImpl paragraphRepository = new ParagraphRepositoryImpl();
        ParagraphService paragraphService = new ParagraphService(paragraphRepository);
        SentenceRepositoryImpl sentenceRepository = new SentenceRepositoryImpl();
        SentenceService sentenceService = new SentenceService(sentenceRepository);
        WordRepositoryImpl wordRepository = new WordRepositoryImpl();
        WordService wordService = new WordService(wordRepository);
        textController = new TextController(fileValidator, fileReader, parser,
                textRepository, entireTextService, paragraphRepository, paragraphService,
                sentenceRepository, sentenceService, wordRepository, wordService);

        String path = new File(Objects.requireNonNull(classLoader.getResource("textExample.txt")).getFile()).getAbsolutePath();
        textController.saveTextFromFile(path);

        Assert.assertEquals(sentenceRepository.findTextLeaf(new FindTextByIdSpecification(new SentenceComposite(0))).get().getText(), text);
    }
}