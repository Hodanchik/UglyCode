package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TravelTour;

public class SelectByNutritionSpecification implements Specification<TravelTour> {

    private final NutritionType nutritionType;

    public SelectByNutritionSpecification(NutritionType nutritionType) {
        this.nutritionType = nutritionType;
    }

    @Override
    public boolean match(TravelTour entity) {
        return entity.getNutritionType() == nutritionType;
    }
}
