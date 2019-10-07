package model;

import entity.Word;
import repository.WordRepositoryImpl;
import service.WordService;

public class WordLeaf implements TextLeaf {
    private Word word;
    private long currentId;
    private  WordRepositoryImpl wordRepository = new WordRepositoryImpl();
    private  WordService wordService = new WordService(wordRepository);

    public WordLeaf(Word word) {
        this.word = word;
    }
    public WordLeaf(long currentId) {
        this.currentId = currentId;
    }
    public WordLeaf(Word word, WordRepositoryImpl wordRepository, WordService wordService) {
        this.word = word;
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }
    public WordLeaf(long currentId, WordRepositoryImpl wordRepository, WordService wordService) {
        this.currentId = currentId;
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }

    @Override
    public void save() {
        long currentId = wordService.saveText(this);
        setCurrentId(currentId);
    }

    public void setCurrentId(long currentId) {
        this.currentId = currentId;
    }

    @Override
    public TextLeaf load() {

        return wordService.loadText(currentId);
    }

    @Override
    public long getCurrentId() {
        return currentId;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        if (word.getStart() != null) {
            sb.append(word.getStart());
        }
        sb.append(word.getWord());
        if (word.getEnding() != null) {
            sb.append(word.getEnding());
        }
        return String.valueOf(sb);
    }
}
