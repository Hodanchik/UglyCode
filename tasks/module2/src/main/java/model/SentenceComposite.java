package model;

import java.util.LinkedList;
import java.util.List;

public class SentenceComposite implements TextComposite {
    private List<TextLeaf> sentence = new LinkedList<>();
    private boolean newLine;
    private String separator = " ";

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    @Override
    public void addText(TextLeaf textLeaf) {
        sentence.add(textLeaf);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextLeaf textLeaf : sentence) {
            sb.append(textLeaf.getText());
            sb.append(separator);
        }
        if (isNewLine()) {
            sb.replace(sb.lastIndexOf(separator), sb.lastIndexOf(separator) + 1, "\n");
        }
        return String.valueOf(sb);
    }
}
