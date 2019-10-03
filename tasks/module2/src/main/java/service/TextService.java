package service;

import model.TextLeaf;
import org.apache.log4j.Logger;
import repository.TextRepositoryImpl;

import java.util.List;

public class TextService {
    private static final Logger log = Logger.getLogger(TextService.class);
    private TextRepositoryImpl textRepository;

    public TextService(TextRepositoryImpl textRepository) {
        this.textRepository = textRepository;
    }

    public void saveText(TextLeaf textLeaf) {
        textRepository.add(textLeaf);
    }

    public List<TextLeaf> getAllText() {
        return textRepository.getTextList();
    }
}
