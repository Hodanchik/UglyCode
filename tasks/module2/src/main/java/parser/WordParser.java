package parser;

import entity.Sentence;
import entity.Word;
import model.SentenceComposite;
import model.TextLeaf;
import model.WordLeaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends TextParser {
    private String regexWord = "([\\'\\(\\\"]+)?(\\w+([\\-\\']*\\w*)*)+([\\.\\!\\?\\\"\\)\\'\\,]+)?";
    private Pattern pattern = Pattern.compile(regexWord);
    private Matcher matcher;

    @Override
    public TextLeaf parse(String text) {
        matcher = pattern.matcher(text);
        Sentence sentence = new Sentence();
        sentence.setNewLine(parseNewLine(text));
        SentenceComposite sentenceComposite = new SentenceComposite(sentence);
        while (matcher.find()) {
            Word word = new Word(matcher.group(1), matcher.group(2), matcher.group(4));
            WordLeaf wordLeaf = new WordLeaf(word);
            sentenceComposite.addText(wordLeaf);
        }
        return sentenceComposite;
    }

    private boolean parseNewLine(String sentence) {
        String regexNewLine = "\n";
        Pattern patternLine = Pattern.compile(regexNewLine);
        Matcher matcherNewLine = patternLine.matcher(sentence);
        return matcherNewLine.find();
    }
}
