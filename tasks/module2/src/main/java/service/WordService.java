package service;

import model.TextLeaf;
import model.WordLeaf;
import org.apache.log4j.Logger;
import repository.FindTextByIdSpecification;
import repository.FindTextSpecification;
import repository.WordRepositoryImpl;

import java.util.Optional;

public class WordService  implements Service<TextLeaf> {
    private static final Logger log = Logger.getLogger(WordService.class);
    private  WordRepositoryImpl wordRepository;
    public WordService(WordRepositoryImpl wordRepository) {
        this.wordRepository = wordRepository;
    }

    public long saveText(TextLeaf textLeaf) {
        FindTextSpecification findTextSpecification = new FindTextSpecification(textLeaf);
        if (!wordRepository.findTextLeaf(findTextSpecification).isPresent()) {
            return wordRepository.add(textLeaf);
        } else {
            return wordRepository.findTextLeaf(findTextSpecification).get().getCurrentId();
        }
    }

    public TextLeaf loadText(long textId) {
        FindTextByIdSpecification findTextByIdSpecification = new FindTextByIdSpecification(new WordLeaf(textId));
        Optional<TextLeaf> loadTextLeaf = wordRepository.findTextLeaf(findTextByIdSpecification);
        if (loadTextLeaf.isPresent()) {
            return loadTextLeaf.get();
        }
        log.error("Incorrect data in textId");
        return null;
    }

}
