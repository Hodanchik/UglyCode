package parser;

import model.EntireTextComposite;
import model.ParagraphComposite;
import model.TextComposite;
import model.TextLeaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser {
    private String regexParagraph = "(\\t)(.+)(\\n?)?";
    private Pattern pattern = Pattern.compile(regexParagraph);

    @Override
    public TextLeaf parse(String text) {
        Matcher matcher = pattern.matcher(text);
        TextComposite parseText = new EntireTextComposite();
        while (matcher.find()) {
            ParagraphComposite paragraphComposite = new ParagraphComposite();
            paragraphComposite.addText(nextParse(matcher.group()));
            parseText.addText(paragraphComposite);
        }
        if (parseText.getText().isEmpty()) {
            parseText.addText(nextParse(text));
        }
        return parseText;
    }
}

