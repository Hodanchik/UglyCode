package service;

import entity.Sentence;
import entity.Word;
import model.WordLeaf;
import org.junit.Assert;
import org.junit.Test;
import repository.SentenceRepositoryImpl;
import repository.WordRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class TextServiceTest {
    WordRepositoryImpl wordRepository = new WordRepositoryImpl();
    WordService wordService = new WordService(wordRepository);
    SentenceRepositoryImpl sentenceRepository = new SentenceRepositoryImpl();
    SentenceService sentenceService = new SentenceService(sentenceRepository);

    @Test
    public void saveWord() {
        Word wordEntity = new Word("", "Retyt", ",");
        Word wordEntityOne = new Word("(", "Ryu", ",");
        WordLeaf wordLeaf = new WordLeaf(wordEntity, wordRepository, wordService);
        WordLeaf wordLeafOne = new WordLeaf(wordEntityOne, wordRepository, wordService);
        wordLeaf.save();
        wordLeafOne.save();
        String expect = wordEntity.toString();
        String expectOne = wordEntityOne.toString();
        String wordActeal = wordService.loadText(0).getText();
        String wordActealOne = wordService.loadText(1).getText();
        Assert.assertEquals(expect, wordActeal);
        Assert.assertEquals(expectOne, wordActealOne);
    }
}
