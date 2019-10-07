package service;
import model.SentenceComposite;
import model.TextLeaf;
import org.apache.log4j.Logger;
import repository.FindTextByIdSpecification;
import repository.SentenceRepositoryImpl;
import java.util.Optional;

public class SentenceService implements Service<TextLeaf> {
    private static final Logger log = Logger.getLogger(SentenceService.class);
    private SentenceRepositoryImpl sentenceRepository;
    public SentenceService(SentenceRepositoryImpl sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @Override
    public long saveText(TextLeaf textLeaf) {
        return sentenceRepository.add(textLeaf);
    }

    @Override
    public TextLeaf loadText(long textId) {
        FindTextByIdSpecification  findTextByIdSpecification = new FindTextByIdSpecification(new SentenceComposite(textId));
        Optional<TextLeaf> loadTextLeaf = sentenceRepository.findTextLeaf(findTextByIdSpecification);
        if (loadTextLeaf.isPresent()) {
            return loadTextLeaf.get();
        }
        log.error("Incorrect data in textId");
        return null;
    }

}
