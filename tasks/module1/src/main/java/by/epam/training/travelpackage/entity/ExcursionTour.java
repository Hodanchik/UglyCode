package by.epam.training.travelpackage.entity;

import org.apache.log4j.Logger;

import java.util.Objects;

public class ExcursionTour extends TravelTour {
    private static final Logger log = Logger.getLogger(ExcursionTour.class);
    private int countCountry;
    private boolean localGuide;
    private boolean nightMoving;
    private final TourType tourType = TourType.EXCURSION;

    public ExcursionTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(TourType.EXCURSION, transportType, nutritionType, duration, price);
    }

    public ExcursionTour(TourType tourType, TransportType transportType, NutritionType nutritionType, int duration, double price, int countCountry, boolean localGuide, boolean nightMoving) {
        super(tourType, transportType, nutritionType, duration, price);
        this.countCountry = countCountry;
        this.localGuide = localGuide;
        this.nightMoving = nightMoving;
    }

    public ExcursionTour() {
        super();
    }

    public int getCountCountry() {
        return countCountry;
    }

    public void setCountCountry(int countCountry) {
        this.countCountry = countCountry;
    }

    public boolean isLocalGuide() {
        return localGuide;
    }

    public void setLocalGuide(boolean localGuide) {
        this.localGuide = localGuide;
    }

    public boolean isNightMoving() {
        return nightMoving;
    }

    public void setNightMoving(boolean nightMoving) {
        this.nightMoving = nightMoving;
    }

    @Override
    public TourType getTourType() {
        return tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExcursionTour)) return false;
        if (!super.equals(o)) return false;
        ExcursionTour that = (ExcursionTour) o;
        return getCountCountry() == that.getCountCountry() &&
                isLocalGuide() == that.isLocalGuide() &&
                isNightMoving() == that.isNightMoving() &&
                getTourType() == that.getTourType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountCountry(), isLocalGuide(), isNightMoving(), getTourType());
    }

    @Override
    public String toString() {
        return "ExcursionTour{" +
                "countCountry=" + countCountry +
                ", localGuide=" + localGuide +
                ", nightMoving=" + nightMoving +
                ", tourType=" + tourType +
                '}';
    }
}
