package parser;

import model.EntireTextComposite;
import model.TextComposite;
import model.TextLeaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser {
    String regexSentence = "([A-Z]{1})(.)+?([\\.\\!\\?]+)(\\n+)?";
    private Pattern pattern = Pattern.compile(regexSentence);
    private Matcher matcher;

    @Override
    public TextLeaf parse(String text) {
        matcher = pattern.matcher(text);
        TextComposite parseText = new EntireTextComposite();
        while (matcher.find()) {
            parseText.addText(nextParse(matcher.group()));
        }
        if (parseText.getText().isEmpty()) {
            parseText.addText(nextParse(text));
        }

        return parseText;
    }

}
