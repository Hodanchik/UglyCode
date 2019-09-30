package model;

import java.util.LinkedList;
import java.util.List;

public class Text implements TextComposite {
    List<TextLeaf> text = new LinkedList<>();

    @Override
    public void addText(TextLeaf textLeaf) {
        text.add(textLeaf);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextLeaf textLeaf : text) {
            sb.append(textLeaf.getText());
        }
        return String.valueOf(sb);
    }
}
