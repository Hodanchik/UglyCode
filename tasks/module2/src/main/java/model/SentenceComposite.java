package model;

import entity.Sentence;
import repository.SentenceRepositoryImpl;
import service.SentenceService;

import java.util.LinkedList;
import java.util.List;

public class SentenceComposite implements TextComposite {
    private List<TextLeaf> sentence = new LinkedList<>();
    private Sentence sentenceEntity;
    private long currentId;
    SentenceRepositoryImpl sentenceRepository = new SentenceRepositoryImpl();
    SentenceService sentenceService = new SentenceService(sentenceRepository);

    public SentenceComposite(Sentence sentenceEntity, SentenceRepositoryImpl sentenceRepository,
                             SentenceService sentenceService) {
        this.sentenceEntity = sentenceEntity;
        this.sentenceRepository = sentenceRepository;
        this.sentenceService = sentenceService;
    }

    public SentenceComposite(Sentence sentenceEntity) {
        this.sentenceEntity = sentenceEntity;
    }

    public SentenceComposite(long currentId) {
        this.currentId = currentId;
    }

    public SentenceComposite(long currentId, SentenceRepositoryImpl sentenceRepository,
                             SentenceService sentenceService) {
        this.currentId = currentId;
        this.sentenceRepository = sentenceRepository;
        this.sentenceService = sentenceService;
    }

    @Override
    public void save() {
        long currentId = sentenceService.saveText(this);
        setCurrentId(currentId);
        for (TextLeaf textLeaf : sentence) {
            textLeaf.save();
        }
    }
    @Override
    public TextLeaf load() {
        return sentenceService.loadText(this.currentId);
    }

    @Override
    public long getCurrentId() {
        return currentId;
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
            sb.append(sentenceEntity.getSeparator());
        }
        if (sentenceEntity.isNewLine()) {
            sb.replace(sb.lastIndexOf(sentenceEntity.getSeparator()),
                    sb.lastIndexOf(sentenceEntity.getSeparator()) + 1, "\n");
        }
        return String.valueOf(sb);
    }

    public void setCurrentId(long currentId) {
        this.currentId = currentId;
    }
}
