package by.epam.training.travelpackage.entity;

import org.apache.log4j.Logger;

import java.util.Objects;

public class RelaxTour extends TravelTour {
    private static final Logger log = Logger.getLogger(RelaxTour.class);
    private String country;
    private boolean hotCountry;
    private boolean haveSea;
    private HotelStarsType hotelStarsType;
    private final TourType tourType = TourType.RELAX;

    public RelaxTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(TourType.RELAX, transportType, nutritionType, duration, price);
    }

    public RelaxTour(TransportType transportType, NutritionType nutritionType, int duration, double price, String country, boolean hotCountry, boolean haveSea, HotelStarsType hotelStarsType) {
        super(TourType.RELAX, transportType, nutritionType, duration, price);
        this.country = country;
        this.hotCountry = hotCountry;
        this.haveSea = haveSea;
        this.hotelStarsType = hotelStarsType;
    }

    public RelaxTour() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHotCountry() {
        return hotCountry;
    }

    public void setHotCountry(boolean hotCountry) {
        this.hotCountry = hotCountry;
    }

    public boolean isHaveSea() {
        return haveSea;
    }

    public void setHaveSea(boolean haveSea) {
        this.haveSea = haveSea;
    }

    public HotelStarsType getHotelStarsType() {
        return hotelStarsType;
    }

    public void setHotelStarsType(HotelStarsType hotelStarsType) {
        this.hotelStarsType = hotelStarsType;
    }

    public TourType getTourType() {
        return tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelaxTour)) return false;
        if (!super.equals(o)) return false;
        RelaxTour relaxTour = (RelaxTour) o;
        return isHotCountry() == relaxTour.isHotCountry() &&
                isHaveSea() == relaxTour.isHaveSea() &&
                getCountry().equals(relaxTour.getCountry()) &&
                getHotelStarsType() == relaxTour.getHotelStarsType() &&
                tourType == relaxTour.tourType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountry(), isHotCountry(), isHaveSea(), getHotelStarsType(), tourType);
    }

    @Override
    public String toString() {
        return "RelaxTour{" +
                "city='" + country + '\'' +
                ", hotCountry=" + hotCountry +
                ", haveSea=" + haveSea +
                ", hotelStars=" + hotelStarsType +
                ", tourType=" + tourType +
                '}';
    }
}
