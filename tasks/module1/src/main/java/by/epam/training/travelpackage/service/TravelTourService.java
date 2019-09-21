package by.epam.training.travelpackage.service;

import by.epam.training.travelpackage.service.comparator.BeanComparator;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.repository.specification.Specification;
import by.epam.training.travelpackage.repository.TravelTourRepository;
import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelTourService {

    private static final Logger log = Logger.getLogger(TravelTourService.class);
    private TravelTourRepository travelTourRepository;

    public TravelTourService(TravelTourRepository travelTourRepository) {
        this.travelTourRepository = travelTourRepository;
    }

    public void saveTour(TravelTour travelTour) {
        travelTourRepository.add(travelTour);
    }

    public List<TravelTour> sort(Comparator<TravelTour> comparator) {
        List<TravelTour> sortTravelTourList = travelTourRepository.getTourList();
        sortTravelTourList.sort(comparator);
        return sortTravelTourList;
    }

    public List<TravelTour> getAllByParameter(Specification<TravelTour> spec) {
        return travelTourRepository.findAllByParameter(spec);
    }


    public TravelTourRepository getTravelTourRepository() {
        return travelTourRepository;
    }

    //Custom sorterComplex
    public List<TravelTour> sortIncreasByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortIncreasByParameter method");
        List<TravelTour> travelTourList = travelTourRepository.getTourList();
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                return travelTourList;
            }
        }
        return travelTourList;
    }
    public List<TravelTour> sortIncreasByTwoParameter(Specification<TravelTour> specification, String firstparameter
            , String secondparameter) {
        log.debug("sortIncreasByTwoParameter method");
        List<TravelTour> travelTourList = travelTourRepository.getTourList();
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                Collections.sort(travelTourList, new BeanComparator(firstparameter)
                        .thenComparing(new BeanComparator(secondparameter)));
                return travelTourList;
            }
        }
        return travelTourList;
    }

    public List<TravelTour> sortDescendenceByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortDescendenceByParameter");
        List<TravelTour> travelTourList = travelTourRepository.getTourList();
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                Collections.reverse(travelTourList);
                return travelTourList;
            }
        }
        return travelTourList;
    }
}