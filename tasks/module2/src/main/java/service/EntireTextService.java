package service;

import model.EntireTextComposite;
import model.TextLeaf;
import org.apache.log4j.Logger;
import repository.FindTextByIdSpecification;
import repository.TextRepositoryImpl;

import java.util.Optional;

public class EntireTextService implements Service<TextLeaf> {
    private static final Logger log = Logger.getLogger(EntireTextService.class);
    private TextRepositoryImpl textRepository;
    public EntireTextService(TextRepositoryImpl textRepository) {
        this.textRepository = textRepository;
    }
    @Override
    public long saveText(TextLeaf text) {
        return textRepository.add(text);
    }

    @Override
    public TextLeaf loadText(long textId) {
        FindTextByIdSpecification findTextByIdSpecification = new FindTextByIdSpecification(new EntireTextComposite(textId));
        Optional<TextLeaf> loadTextLeaf = textRepository.findTextLeaf(findTextByIdSpecification);
        if (loadTextLeaf.isPresent()) {
            return loadTextLeaf.get();
        }
        log.error("Incorrect data in textId");
        return null;
    }

}
