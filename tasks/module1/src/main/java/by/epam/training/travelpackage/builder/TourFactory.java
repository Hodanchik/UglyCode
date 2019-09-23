package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.TourType;
import by.epam.training.travelpackage.entity.TravelTour;
import org.apache.log4j.Logger;

import java.util.Map;

public class TourFactory {
    private static final Logger log = Logger.getLogger(TourFactory.class);
    private TourType type;
    private static final String MAIN_FIELD = "tourType";

    public TravelTour buildTour(Map<String, String> validateMap) {
        type = TourType.fromString(validateMap.get(MAIN_FIELD)).get();
        switch (type) {
            case MEDICAL:
                return new MedicalTourBuilder().buildTour(validateMap);
            case RELAX:
                return new RelaxTourBuilder().buildTour(validateMap);
            case SHOP:
                return new ShopTourBuilder().buildTour(validateMap);
            case EXCURSION:
                return new ExcursionTourBuilder().buildTour(validateMap);
        }
        log.warn("empty Tour return");
        return new TravelTour();
    }
}
