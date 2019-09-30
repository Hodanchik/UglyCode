package parser;

import model.TextLeaf;

public abstract class TextParser implements ParserChain<TextLeaf> {

    private TextParser nextParser;

    @Override
    public ParserChain<TextLeaf> linkWith(ParserChain<TextLeaf> next) {
        this.nextParser = (TextParser) next;
        return nextParser;
    }

    protected TextLeaf nextParse(String text) {
        if (nextParser != null) {
            return nextParser.parse(text);
        } else {
            return null;
        }
    }
}
