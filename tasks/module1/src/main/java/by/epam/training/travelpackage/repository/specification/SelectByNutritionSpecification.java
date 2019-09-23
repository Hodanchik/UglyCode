package by.epam.training.travelpackage.repository.specification;

import by.epam.training.travelpackage.entity.NutritionType;
import by.epam.training.travelpackage.entity.TravelTour;
import by.epam.training.travelpackage.repository.Specification;
import org.apache.log4j.Logger;

public class SelectByNutritionSpecification implements Specification<TravelTour> {
    private static final Logger log = Logger.getLogger(SelectByNutritionSpecification.class);

    private final NutritionType nutritionType;

    public SelectByNutritionSpecification(NutritionType nutritionType) {
        this.nutritionType = nutritionType;
    }

    @Override
    public boolean match(TravelTour entity) {
        return entity.getNutritionType() == nutritionType;
    }
}
