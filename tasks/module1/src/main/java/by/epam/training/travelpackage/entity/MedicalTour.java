package by.epam.training.travelpackage.entity;

import org.apache.log4j.Logger;

import java.util.Objects;

public class MedicalTour extends TravelTour {
    private static final Logger log = Logger.getLogger(MedicalTour.class);
    private boolean medicalSupport;
    private String сountry;
    private final TourType tourType = TourType.MEDICAL;

    public MedicalTour() {
        super();
    }

    public MedicalTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(TourType.MEDICAL, transportType, nutritionType, duration, price);
    }

    public MedicalTour(TransportType transportType, NutritionType nutritionType, int duration, double price, boolean medicalSupport, String сountry) {
        super(TourType.MEDICAL, transportType, nutritionType, duration, price);
        this.medicalSupport = medicalSupport;
        this.сountry = сountry;
    }


    public boolean isMedicalSupport() {
        return medicalSupport;
    }

    public void setMedicalSupport(boolean medicalSupport) {
        this.medicalSupport = medicalSupport;
    }

    public String getCountry() {
        return сountry;
    }

    public void setCountry(String сountry) {
        this.сountry = сountry;
    }

    @Override
    public TourType getTourType() {
        return tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalTour)) return false;
        if (!super.equals(o)) return false;
        MedicalTour that = (MedicalTour) o;
        return isMedicalSupport() == that.isMedicalSupport() &&
                getCountry().equals(that.getCountry()) &&
                getTourType() == that.getTourType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMedicalSupport(), getCountry(), getTourType());
    }

    @Override
    public String toString() {
        return "MedicalTour{" +
                "medicalSupport=" + medicalSupport +
                ", country='" + сountry + '\'' +
                ", tourType=" + tourType +
                '}';
    }
}
