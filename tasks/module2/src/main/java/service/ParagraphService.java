package service;

import model.ParagraphComposite;
import model.TextLeaf;
import org.apache.log4j.Logger;
import repository.FindTextByIdSpecification;
import repository.ParagraphRepositoryImpl;

import java.util.Optional;

public class ParagraphService implements Service<TextLeaf> {
    private static final Logger log = Logger.getLogger(ParagraphService.class);
    private ParagraphRepositoryImpl paragraphRepository;
    public ParagraphService(ParagraphRepositoryImpl paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    @Override
    public long saveText(TextLeaf textLeaf) {
        return paragraphRepository.add(textLeaf);
    }

    @Override
    public TextLeaf loadText(long textId) {
        FindTextByIdSpecification findTextByIdSpecification = new FindTextByIdSpecification(new ParagraphComposite(textId));
        Optional<TextLeaf> loadTextLeaf = paragraphRepository.findTextLeaf(findTextByIdSpecification);
        if (loadTextLeaf.isPresent()) {
            return loadTextLeaf.get();
        }
        log.error("Incorrect data in textId");
        return null;
    }
}
