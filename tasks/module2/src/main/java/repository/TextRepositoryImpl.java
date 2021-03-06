package repository;

import model.TextLeaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TextRepositoryImpl implements Repository<TextLeaf> {
    private static AtomicLong counterId = new AtomicLong(0);
    private List<TextLeaf> textList = new ArrayList<>();


    @Override
    public long add(TextLeaf text) {
        FindTextSpecification findTextSpecification = new FindTextSpecification(text);
        if (!findTextLeaf(findTextSpecification).isPresent()) {
            textList.add(text);
            return counterId.getAndIncrement();
        } else {
            return findTextLeaf(findTextSpecification).get().getCurrentId();
        }
    }

    @Override
    public Optional<TextLeaf> findTextLeaf(Specification<TextLeaf> spec) {
        for (TextLeaf text : textList) {
            if (spec.match(text)) {
                return Optional.of(text);
            }
        }
        return Optional.empty();
    }
}
