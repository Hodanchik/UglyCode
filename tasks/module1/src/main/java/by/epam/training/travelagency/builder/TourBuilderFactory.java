package by.epam.training.travelagency.builder;

import by.epam.training.travelagency.entity.TourType;
import org.apache.log4j.Logger;

public class TourBuilderFactory {
    private static final Logger log = Logger.getLogger(TourBuilderFactory.class);
    private static final String MAIN_FIELD = "tourType";

    public TourBuilder getBuilderByType(String type) {
        if (TourType.fromString(type).isPresent()) {
            TourType tourType = TourType.fromString(type).get();
            switch (tourType) {
                case MEDICAL:
                    return new MedicalTourBuilder();
                case RELAX:
                    return new RelaxTourBuilder();
                case SHOP:
                    return new ShopTourBuilder();
                case EXCURSION:
                    return new ExcursionTourBuilder();
            }
        }
        log.error("Incorrect data in TourBuilder");
        return new DefaultTourBuilder();
    }
}
