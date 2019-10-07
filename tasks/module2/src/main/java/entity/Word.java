package entity;

public class Word {
    private String start;
    private String word;
    private String ending;


    public Word(String start, String word, String ending) {
        this.start = start;
        this.word = word;
        this.ending = ending;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

    @Override
    public String toString() {
        return start + word + ending;
    }
}
