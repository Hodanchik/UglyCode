package repository;

import model.TextLeaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class WordRepositoryImpl implements Repository<TextLeaf> {
    private static AtomicLong counterId ;
    private List<TextLeaf> wordList;

    public WordRepositoryImpl() {
        this.wordList = new ArrayList<>();
        counterId = new AtomicLong(0);
    }

    @Override
    public long add(TextLeaf text) {
            wordList.add(text);
            return counterId.getAndIncrement();
    }

    @Override
    public Optional<TextLeaf> findTextLeaf(Specification<TextLeaf> spec) {
        for (TextLeaf word : wordList) {
            if (spec.match(word)) {
                return Optional.of(word);
            }
        }
        return Optional.empty();
    }
}



