package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.repository.specification.Specification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TravelTourRepository implements Repository<TravelTour> {
    private static final Logger log = Logger.getLogger(TravelTourRepository.class);

    private List<TravelTour> travelTourList = new ArrayList<>();

    public TravelTourRepository() {
    }

    public TravelTourRepository(List<TravelTour> travelTourList) {
        this.travelTourList = travelTourList;
    }

    public List<TravelTour> getTourList() {
        return new ArrayList<>(travelTourList);
    }

    @Override
    public void add(TravelTour travelTour) {
        log.debug("add tour to repository");
        travelTourList.add(travelTour);
    }

    @Override
    public void remove(TravelTour travelTour) {
        log.debug("remove tour from repository");travelTourList.remove(travelTour);
    }

    @Override
    public List<TravelTour> findAllByParameter(Specification<TravelTour> spec) {
        List<TravelTour> selectList = new ArrayList<>();
        for (TravelTour tour : travelTourList) {
            if (spec.match(tour)) {
                selectList.add(tour);
            }
        }
        return selectList;
    }
}

