package repository;

import model.TextLeaf;

import java.util.ArrayList;
import java.util.List;

public class TextRepositoryImpl implements Repository<TextLeaf> {
    private List<TextLeaf> text = new ArrayList<>();

    @Override
    public void add(TextLeaf entity) {
        text.add(entity);
    }

    @Override
    public void remove(TextLeaf entity) {
        text.remove(entity);
    }

    public List<TextLeaf> getTextList() {
        return new ArrayList<>(text);
    }

}
