package model;

public class WordLeaf implements TextLeaf {
    private String start;
    private String word;
    private String ending;

    public WordLeaf(String start, String word, String ending) {
        this.start = start;
        this.word = word;
        this.ending = ending;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        if (start != null) {
            sb.append(start);
        }
        sb.append(word);
        if (ending != null) {
            sb.append(ending);
        }
        return String.valueOf(sb);
    }
}
