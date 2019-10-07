package repository;

import model.TextLeaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class SentenceRepositoryImpl implements Repository<TextLeaf> {
    private static AtomicLong counterId ;
    private List<TextLeaf> sentenceList;

    public SentenceRepositoryImpl() {
        this.sentenceList = new ArrayList<>();
        counterId = new AtomicLong(0);
    }

    @Override
    public long add(TextLeaf text) {
        FindTextSpecification findTextSpecification = new FindTextSpecification(text);
        if (!findTextLeaf(findTextSpecification).isPresent()) {
            sentenceList.add(text);
            return counterId.getAndIncrement();
        } else {
            return findTextLeaf(findTextSpecification).get().getCurrentId();
        }
    }

    @Override
    public Optional<TextLeaf> findTextLeaf(Specification<TextLeaf> spec) {
        for (TextLeaf sentence : sentenceList) {
            if (spec.match(sentence)) {
                return Optional.of(sentence);
            }
        }
        return Optional.empty();
    }


}
