package parser;

import model.TextLeaf;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParserChainTest {
    private String textWithParagraphs = "\tIt has survived not only five centuries, but also the leap into electronic" +
            "typesetting, remaining essentially unchanged. It was popularised in the with the" +
            "release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
            "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\tIt is a long established fact that a reader will be distracted by the readable" +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a" +
            "more-or-less normal distribution of letters, as opposed to using 'Content here, content" +
            "here', making it look like readable English.\n" +
            "\tIt is a established fact that a reader will be of a page when looking at its" +
            "layout...\n" +
            "\tBye.\n";;
    private String textWithoutParagraphs = "It has survived not only five centuries, but also the leap into electronic" +
            "typesetting, remaining essentially unchanged. It was popularised in the with the" +
            "release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
            "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "It is a long established fact that a reader will be distracted by the readable" +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a" +
            "more-or-less normal distribution of letters, as opposed to using 'Content here, content" +
            "here', making it look like readable English.\n" +
            "It is a established fact that a reader will be of a page when looking at its" +
            "layout...\n" +
            "Bye.\n";

    private String textWithWords = "It has survived not only five centuries, but also the leap into electronic" +
            "typesetting, remaining essentially unchanged It was popularised in the with the" +
            "release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
            "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum" +
            "It is a long established fact that a reader will be distracted by the readable" +
            "content of a page when looking at its layout The point of using Ipsum is that it has a" +
            "more-or-less normal distribution of letters, as opposed to using 'Content here, content" +
            "here', making it look like readable English. ";

    private static ParserChain<TextLeaf> textParser;

    @BeforeClass
    public static void prepare() {
        textParser = new ParagraphParser();
        textParser.linkWith(new SentenceParser()).linkWith(new WordParser());
    }
    @Test
    public void parseTextWithParagraphs() {
        TextLeaf entireText;
        entireText = textParser.parse(textWithParagraphs);
        String actualText = entireText.getText();
        Assert.assertEquals(textWithParagraphs, actualText);
    }
    @Test
    public void parseTextWithoutParagraphs() {
        TextLeaf entireText;
        entireText = textParser.parse(textWithoutParagraphs);
        String actualText = entireText.getText();
        Assert.assertEquals(textWithoutParagraphs, actualText);
    }
    @Test
    public void parseTextWithWords() {
        TextLeaf entireText;
        entireText = textParser.parse(textWithWords);
        String actualText = entireText.getText();
        Assert.assertEquals(textWithWords, actualText);
    }
}