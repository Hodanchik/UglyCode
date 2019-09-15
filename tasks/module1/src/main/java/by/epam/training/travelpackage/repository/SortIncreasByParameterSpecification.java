package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.entity.TravelTour;

public class SortIncreasByParameterSpecification implements Specification<TravelTour> {
    private final String parameter;

    public SortIncreasByParameterSpecification(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean match(TravelTour entity) {
        try {
            return entity.getClass().getDeclaredField(parameter).getName().equals(parameter);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }
}
