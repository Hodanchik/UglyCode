package model;

import java.util.List;

public interface TextLeaf {
    String getText();
    void save();
    TextLeaf load();
    long getCurrentId();
}
