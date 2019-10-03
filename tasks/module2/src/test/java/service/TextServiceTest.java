package service;

import model.TextLeaf;
import model.WordLeaf;
import org.junit.Assert;
import org.junit.Test;
import repository.TextRepositoryImpl;

public class TextServiceTest {
    TextRepositoryImpl textRepo = new TextRepositoryImpl();
    TextService textService = new TextService(textRepo);


    @Test
    public void saveText() {
        TextLeaf text = new WordLeaf("", "Example", "");
        textService.saveText(text);
        int expect = 1;
        int realSize = textService.getAllText().size();
        Assert.assertEquals(expect, realSize);
    }
}