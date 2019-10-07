package repository;

import model.TextLeaf;
import org.apache.log4j.Logger;

public class FindTextSpecification implements Specification<TextLeaf> {

    private static final Logger log = Logger.getLogger(FindTextSpecification.class);

    private final TextLeaf textLeaf;

    public FindTextSpecification(TextLeaf textLeaf) {
        this.textLeaf = textLeaf;
    }

    @Override
    public boolean match(TextLeaf text) {
        return text.getText().equals(textLeaf.getText());
    }
}
