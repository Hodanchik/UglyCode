package repository;

import model.TextLeaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ParagraphRepositoryImpl implements Repository<TextLeaf>{
    private static AtomicLong counterId;
    private List<TextLeaf> paragraphList;

    public ParagraphRepositoryImpl() {
      counterId = new AtomicLong(0);
        paragraphList = new ArrayList<>();
    }

    @Override
    public long add(TextLeaf text) {
        FindTextSpecification findTextSpecification = new FindTextSpecification(text);
        if (!findTextLeaf(findTextSpecification).isPresent()) {
            paragraphList.add(text);
            return counterId.getAndIncrement();
        } else {
            return findTextLeaf(findTextSpecification).get().getCurrentId();
        }
    }
    @Override
    public Optional<TextLeaf> findTextLeaf(Specification<TextLeaf> spec) {
        for (TextLeaf paragraph : paragraphList) {
            if (spec.match(paragraph)) {
                return Optional.of(paragraph);
            }
        }
        return Optional.empty();
    }
}
