package model;

import java.util.LinkedList;
import java.util.List;

public class ParagraphСomposite implements TextComposite {
    private List<TextLeaf> paragraph = new LinkedList<>();

    @Override
    public void addText(TextLeaf textLeaf) {
        paragraph.add(textLeaf);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (TextLeaf textLeaf : paragraph) {
            sb.append(textLeaf.getText());
        }
        return String.valueOf(sb);
    }
}
