package repository;

import model.TextLeaf;
import org.apache.log4j.Logger;

import java.util.Objects;

public class FindTextByIdSpecification implements Specification<TextLeaf> {

    private static final Logger log = Logger.getLogger(FindTextByIdSpecification.class);

    private final TextLeaf textLeaf;

    public FindTextByIdSpecification(TextLeaf textLeaf) {
        this.textLeaf = textLeaf;
    }

    @Override
    public boolean match(TextLeaf text) {

        return Objects.equals(text.getCurrentId(), textLeaf.getCurrentId());
    }
}

