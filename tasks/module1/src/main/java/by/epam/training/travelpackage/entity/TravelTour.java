package by.epam.training.travelpackage.entity;


import org.apache.log4j.Logger;

import java.util.Objects;

public class TravelTour {
    private static final Logger log = Logger.getLogger(TravelTour.class);
    private TransportType transportType;
    private NutritionType nutritionType;
    private int duration;
    private double price;
    private TourType tourType;

    public TravelTour(TourType tourType, TransportType transportType, NutritionType nutritionType, int duration, double price) {
        this.transportType = transportType;
        this.nutritionType = nutritionType;
        this.duration = duration;
        this.price = price;
        this.tourType = tourType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public NutritionType getNutritionType() {
        return nutritionType;
    }

    public void setNutritionType(NutritionType nutritionType) {
        this.nutritionType = nutritionType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelTour)) return false;
        TravelTour that = (TravelTour) o;
        return getDuration() == that.getDuration() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                getTransportType() == that.getTransportType() &&
                getNutritionType() == that.getNutritionType() &&
                getTourType() == that.getTourType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransportType(), getNutritionType(), getDuration(), getPrice(), getTourType());
    }

    @Override
    public String toString() {
        return "TravelTour{" +
                "transportType=" + transportType +
                ", nutritionType=" + nutritionType +
                ", duration=" + duration +
                ", price=" + price +
                ", tourType=" + tourType +
                '}';
    }
}

