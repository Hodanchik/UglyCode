package by.epam.training.travelpackage.builder;

import by.epam.training.travelpackage.entity.TravelTour;
import org.apache.log4j.Logger;

import java.util.Map;

public class AbstractTourFactory {
    private static final Logger log = Logger.getLogger(AbstractTourFactory.class);
    String tourType = "tourType";


    public TravelTour buildTour(Map<String, String> validateMap) {

        switch (validateMap.get(tourType)) {
            case "MEDICAL":
                return new MedicalTourBuilder().buildTour(validateMap);
            case "RELAX":
                return new RelaxTourBuilder().buildTour(validateMap);
            case "SHOP":
                return new ShopTourBuilder().buildTour(validateMap);
            case "EXCURSION":
                return new ExcursionTourBuilder().buildTour(validateMap);
        }
        log.warn("empty Tour return");
        return new TravelTour();
    }
}
