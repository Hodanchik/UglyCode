package by.epam.training.travelagency.validator;

import by.epam.training.travelagency.entity.TourType;
import org.apache.log4j.Logger;

public class TourValidatorFactory {
    private static final Logger log = Logger.getLogger(TourValidatorFactory.class);

    public DataValidator getValidatorByType(String type) {
        if (TourType.fromString(type).isPresent()) {
            TourType tourType = TourType.fromString(type).get();
            switch (tourType) {
                case MEDICAL:
                    return new MedicalTourValidator();
                case RELAX:
                    return new RelaxTourValidator();
                case SHOP:
                    return new ShopTourValidator();
                case EXCURSION:
                    return new ExcursionTourValidator();
            }
        } else {
            log.warn("Incorrect value tourType");
        }return new DefaultValidator();
    }
}
