package by.epam.training.travelpackage.service;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TransportType;
import by.epam.training.travelpackage.entity.TravelTour;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TravelTourService {
    private List<TravelTour> travelTourList = new ArrayList<>();

    public TravelTourService() {
    }

    public TravelTourService(List<TravelTour> travelTourList) {
        this.travelTourList = travelTourList;
    }

    public void save(TravelTour travelTour) {
        travelTourList.add(travelTour);
    }

    public List<TravelTour> getTravelTourList() {
        return travelTourList;
    }

    public List<TravelTour> selectByTransport(TransportType transportType) {
        List<TravelTour> selectList = new ArrayList<>();
        for (TravelTour tour : travelTourList) {
            if (tour.getTransportType().equals(transportType)) {
                selectList.add(tour);
            }
        }
        return selectList;
    }

    public List<TravelTour> selectByNutrition(NutritionType nutritionType) {
        List<TravelTour> selectList = new ArrayList<>();
        for (TravelTour tour : travelTourList) {
            if (tour.getNutritionType().equals(nutritionType)) {
                selectList.add(tour);
            }
        }
        return selectList;
    }

    public List<TravelTour> selectByTourType(Class classType) {
        List<TravelTour> selectList = new ArrayList<>();
        for (TravelTour tour : travelTourList) {
            if (tour.getClass().equals(classType)) {
                selectList.add(tour);
            }
        }
        return selectList;
    }

    public List<TravelTour> sortIncreasByDuration() {
        Collections.sort(travelTourList, Comparator.comparing(TravelTour::getDuration));
        return travelTourList;
    }

    public List<TravelTour> sortDescendenceByDuration() {
        Collections.sort(travelTourList, Comparator.comparing(TravelTour::getDuration));
        Collections.reverse(travelTourList);
        return travelTourList;
    }

    public List<TravelTour> sortIncreasByPriceAndDuration() {
        Collections.sort(travelTourList, Comparator.comparing(TravelTour::getPrice)
                .thenComparing(Comparator.comparing(TravelTour::getDuration)));
        return travelTourList;
    }
}

