package model;

public class WordLeaf implements TextLeaf {
    private String word;
    private String ending;

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append(word).append(ending).append(" ");
        return String.valueOf(sb);
    }
}
