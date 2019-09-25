package by.epam.training.travelagency.service;

import by.epam.training.travelagency.service.comparator.BeanComparator;
import by.epam.training.travelagency.entity.TravelTour;
import by.epam.training.travelagency.repository.Specification;
import by.epam.training.travelagency.repository.TravelTourRepositoryImpl;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelTourService {

    private static final Logger log = Logger.getLogger(TravelTourService.class);
    private TravelTourRepositoryImpl travelTourRepositoryImpl;

    public TravelTourService(TravelTourRepositoryImpl travelTourRepositoryImpl) {
        this.travelTourRepositoryImpl = travelTourRepositoryImpl;
    }

    public void saveTour(TravelTour travelTour) {
        travelTourRepositoryImpl.add(travelTour);
    }

    public List<TravelTour> sort(Comparator<TravelTour> comparator) {
        List<TravelTour> sortTravelTourList = travelTourRepositoryImpl.getTourList();
        sortTravelTourList.sort(comparator);
        return sortTravelTourList;
    }

    public List<TravelTour> getAllByParameter(Specification<TravelTour> spec) {
        return travelTourRepositoryImpl.findAllByParameter(spec);
    }


    public TravelTourRepositoryImpl getTravelTourRepositoryImpl() {
        return travelTourRepositoryImpl;
    }

    //Custom sorterComplex
    public List<TravelTour> sortIncreaseByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortIncreaseByParameter method");
        List<TravelTour> travelTourList = travelTourRepositoryImpl.getTourList();
        if (specification.match(travelTourList.get(0))) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                return travelTourList;
            }
        return travelTourList;
    }
    public List<TravelTour> sortIncreaseByTwoParameter(Specification<TravelTour> specification, String firstparameter
            , String secondparameter) {
        log.debug("sortIncreaseByTwoParameter method");
        List<TravelTour> travelTourList = travelTourRepositoryImpl.getTourList();
            if (specification.match(travelTourList.get(0))) {
                Collections.sort(travelTourList, new BeanComparator(firstparameter)
                        .thenComparing(new BeanComparator(secondparameter)));
                return travelTourList;
            }
        return travelTourList;
    }

    public List<TravelTour> sortDescendenceByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortDescendenceByParameter");
        List<TravelTour> travelTourList = travelTourRepositoryImpl.getTourList();
        if (specification.match(travelTourList.get(0))) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                Collections.reverse(travelTourList);
                return travelTourList;
        }
        return travelTourList;
    }
}