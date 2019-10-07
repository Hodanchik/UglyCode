package entity;

import java.util.LinkedList;
import java.util.List;

public class Sentence {

    private boolean newLine;
    private  final String separator = " ";

    public Sentence() {
    }


    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    public String getSeparator() {
        return separator;
    }
}
