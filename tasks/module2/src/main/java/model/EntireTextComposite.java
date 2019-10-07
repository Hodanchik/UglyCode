package model;

import repository.TextRepositoryImpl;
import service.EntireTextService;

import java.util.LinkedList;
import java.util.List;

public class EntireTextComposite implements TextComposite {
    List<TextLeaf> text = new LinkedList<>();
    private long currentId;
    private TextRepositoryImpl textRepository;
    private EntireTextService textService;

    public EntireTextComposite(long currentId, TextRepositoryImpl textRepository,EntireTextService textService) {
        this.currentId = currentId;
        this.textRepository = textRepository;
        this.textService = textService;
    }
    public EntireTextComposite(long currentId) {
        this.currentId = currentId;
    }
    public EntireTextComposite() {
    }

    @Override
    public void save() {
        long currentId = textService.saveText(this);
        setCurrentId(currentId);
        for (TextLeaf textLeaf : text) {
            textLeaf.save();
        }
    }

    @Override
    public TextLeaf load() {
        return textService.loadText(this.currentId);
    }

    @Override
    public long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(long currentId) {
        this.currentId = currentId;
    }

    @Override
    public void addText(TextLeaf textLeaf) {
        text.add(textLeaf);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextLeaf textLeaf : text) {
            sb.append(textLeaf.getText());
        }
        return String.valueOf(sb);
    }
}

