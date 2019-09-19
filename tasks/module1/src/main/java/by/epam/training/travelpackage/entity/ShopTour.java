package by.epam.training.travelpackage.entity;

import org.apache.log4j.Logger;

import java.util.Objects;

public class ShopTour extends TravelTour {
    private static final Logger log = Logger.getLogger(ShopTour.class);
    private String country;
    private boolean visitDutyFree;
    private final TourType tourType = TourType.SHOP;


    public ShopTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(TourType.SHOP, transportType, nutritionType, duration, price);
    }

    public ShopTour(TransportType transportType, NutritionType nutritionType, int duration, double price, String country, boolean visitDutyFree) {
        super(TourType.SHOP, transportType, nutritionType, duration, price);
        this.country = country;
        this.visitDutyFree = visitDutyFree;
    }

    public ShopTour() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                getCountry().equals(shopTour.getCountry()) &&
                getTourType() == shopTour.getTourType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountry(), isVisitDutyFree(), getTourType());
    }

    @Override
    public String toString() {
        return "ShopTour{" +
                "city='" + country + '\'' +
                ", visitDutyFree=" + visitDutyFree +
                ", tourType=" + tourType +
                '}';
    }
}
