package by.epam.training.travelpackage.entity;

import java.util.Objects;

public class ShopTour extends TravelTour {
    private String city;
    private boolean visitDutyFree;

    public ShopTour() {
    }

    public ShopTour(String city, boolean visitDutyFree) {
        this.city = city;
        this.visitDutyFree = visitDutyFree;
    }

    public ShopTour(TransportType transportType, NutritionType nutritionType, int duration, double price, String city, boolean visitDutyFree) {
        super(transportType, nutritionType, duration, price);
        this.city = city;
        this.visitDutyFree = visitDutyFree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isVisitDutyFree() {
        return visitDutyFree;
    }

    public void setVisitDutyFree(boolean visitDutyFree) {
        this.visitDutyFree = visitDutyFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopTour)) return false;
        if (!super.equals(o)) return false;
        ShopTour shopTour = (ShopTour) o;
        return isVisitDutyFree() == shopTour.isVisitDutyFree() &&
                getCity().equals(shopTour.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCity(), isVisitDutyFree());
    }

    @Override
    public String toString() {
        return "ShopTour{" +
                "city='" + city + '\'' +
                ", visitDutyFree=" + visitDutyFree +
                '}';
    }
}
