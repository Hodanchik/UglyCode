package by.epam.training.travelpackage.service;
import by.epam.training.travelpackage.entity.BeanComparator;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.repository.Repository;
import by.epam.training.travelpackage.repository.Specification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TravelTourService implements Repository<TravelTour> {

    private static final Logger log = Logger.getLogger(TravelTourService.class);

    private List<TravelTour> travelTourList = new ArrayList<>();

    public TravelTourService() {
    }


    public TravelTourService(List<TravelTour> travelTourList) {
        this.travelTourList = travelTourList;
    }

    public List<TravelTour> getTravelTourList() {
        return travelTourList;
    }

    @Override
    public TravelTour find(Specification<TravelTour> specification){
        log.debug("find method");
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                return tour;
            }
        }
        log.error("Not find tour");
        return null;
    }

    @Override
    public void save(TravelTour travelTour) {
        travelTourList.add(travelTour);
    }

    @Override
    public void delete(TravelTour travelTour) {
        log.debug("delete method");
        for (TravelTour tour : travelTourList) {
            if (tour.equals(travelTour)) {
                travelTourList.remove(travelTour);
            }
        }
    }
    public List<TravelTour> findAllByParameter(Specification<TravelTour> specification){
        log.debug("findAllByParameter method");
        List<TravelTour> selectList = new ArrayList<>();
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                selectList.add(tour);
            }
        }
        return selectList;
    }

    public List<TravelTour> sortIncreasByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortIncreasByParameter method");
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                return travelTourList;
            }
        } return travelTourList;
    }

    public List<TravelTour> sortDescendenceByParameter(Specification<TravelTour> specification, String parameter) {
        log.debug("sortDescendenceByParameter");
        for (TravelTour tour : travelTourList) {
            if (specification.match(tour)) {
                Collections.sort(travelTourList, new BeanComparator(parameter));
                Collections.reverse(travelTourList);
                return travelTourList;
            }
        } return travelTourList;
    }
}