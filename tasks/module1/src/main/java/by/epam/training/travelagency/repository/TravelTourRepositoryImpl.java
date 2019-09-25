package by.epam.training.travelagency.repository;

import by.epam.training.travelagency.entity.TravelTour;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TravelTourRepositoryImpl implements Repository<TravelTour> {
    private static final Logger log = Logger.getLogger(TravelTourRepositoryImpl.class);

    private List<TravelTour> travelTourList = new ArrayList<>();

    public TravelTourRepositoryImpl() {
    }

    public TravelTourRepositoryImpl(List<TravelTour> travelTourList) {
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

