package by.epam.training.travelpackage.entity;


import java.util.Objects;

public class TravelTour {
    private TransportType transportType;
    private NutritionType nutritionType;
    private int duration;
    private double price;

    public TravelTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        this.transportType = transportType;
        this.nutritionType = nutritionType;
        this.duration = duration;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelTour)) return false;
        TravelTour that = (TravelTour) o;
        return getDuration() == that.getDuration() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                getTransportType() == that.getTransportType() &&
                getNutritionType() == that.getNutritionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransportType(), getNutritionType(), getDuration(), getPrice());
    }

    @Override
    public String toString() {
        return "TravelTour{" +
                "transportType=" + transportType +
                ", nutritionType=" + nutritionType +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}

