package by.epam.training.travelagency.entity;


import org.apache.log4j.Logger;

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
}

