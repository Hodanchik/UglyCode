package model;

import repository.ParagraphRepositoryImpl;
import service.ParagraphService;

import java.util.LinkedList;
import java.util.List;

public class ParagraphComposite implements TextComposite {
    private List<TextLeaf> paragraph = new LinkedList<>();
    private long currentId;
    private ParagraphRepositoryImpl paragraphRepository = new ParagraphRepositoryImpl();
    private ParagraphService paragraphService = new ParagraphService(paragraphRepository);

    public ParagraphComposite(long currentId) {
        this.currentId = currentId;
    }
    public ParagraphComposite(long currentId, ParagraphRepositoryImpl paragraphRepository,
                              ParagraphService paragraphService) {
        this.currentId = currentId;
        this.paragraphRepository = paragraphRepository;
        this.paragraphService = paragraphService;
    }
    public ParagraphComposite() {
    }

    @Override
    public void save() {
        long currentId = paragraphService.saveText(this);
        setCurrentId(currentId);
        for (TextLeaf textLeaf : paragraph) {
            textLeaf.save();
        }
    }

    @Override
    public TextLeaf load() {
        return paragraphService.loadText(this.currentId);
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
        paragraph.add(textLeaf);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (TextLeaf textLeaf : paragraph) {
            sb.append(textLeaf.getText());
        }
        return String.valueOf(sb);
    }


}
