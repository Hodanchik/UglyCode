package by.epam.training.travelpackage.entity;

import java.util.Objects;

public class ExcursionTour extends TravelTour {
    private int countCountry;
    private boolean localGuide;
    private boolean nightMoving;

    public ExcursionTour() {
    }

    public ExcursionTour(int countCountry, boolean localGuide, boolean nightMoving) {
        this.countCountry = countCountry;
        this.localGuide = localGuide;
        this.nightMoving = nightMoving;
    }

    public ExcursionTour(TransportType transportType, NutritionType nutritionType, int duration, double price, int countCountry, boolean localGuide, boolean nightMoving) {
        super(transportType, nutritionType, duration, price);
        this.countCountry = countCountry;
        this.localGuide = localGuide;
        this.nightMoving = nightMoving;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExcursionTour)) return false;
        if (!super.equals(o)) return false;
        ExcursionTour that = (ExcursionTour) o;
        return getCountCountry() == that.getCountCountry() &&
                isLocalGuide() == that.isLocalGuide() &&
                isNightMoving() == that.isNightMoving();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountCountry(), isLocalGuide(), isNightMoving());
    }

    @Override
    public String toString() {
        return "ExcursionTour{" +
                "countCountry=" + countCountry +
                ", localGuide=" + localGuide +
                ", nightMoving=" + nightMoving +
                '}';
    }
}
