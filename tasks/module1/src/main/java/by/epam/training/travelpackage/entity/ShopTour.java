package by.epam.training.travelpackage.entity;

import java.util.Objects;

public class ShopTour extends TravelTour {
    private String city;
    private boolean visitDutyFree;
    private final TourType tourType = TourType.SHOP;


    public ShopTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(TourType.SHOP, transportType, nutritionType, duration, price);
    }

    public ShopTour(TransportType transportType, NutritionType nutritionType, int duration, double price, String city, boolean visitDutyFree) {
        super(TourType.SHOP, transportType, nutritionType, duration, price);
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
    public TourType getTourType() {
        return tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopTour)) return false;
        if (!super.equals(o)) return false;
        ShopTour shopTour = (ShopTour) o;
        return isVisitDutyFree() == shopTour.isVisitDutyFree() &&
                getCity().equals(shopTour.getCity()) &&
                getTourType() == shopTour.getTourType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCity(), isVisitDutyFree(), getTourType());
    }

    @Override
    public String toString() {
        return "ShopTour{" +
                "city='" + city + '\'' +
                ", visitDutyFree=" + visitDutyFree +
                ", tourType=" + tourType +
                '}';
    }
}
