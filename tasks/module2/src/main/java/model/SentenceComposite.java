package model;

import java.util.LinkedList;
import java.util.List;

public class SentenceComposite implements TextComposite {
    List<TextLeaf> sentence = new LinkedList<>();
    boolean newLine;
    @Override
    public void addText(TextLeaf textLeaf) {
        sentence.add(textLeaf);
    }
    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        if (newLine) {
            sb.append("\n");
        }
        for (TextLeaf textLeaf : sentence) {
            sb.append(textLeaf.getText());
        }
        return String.valueOf(sb);
    }

}
