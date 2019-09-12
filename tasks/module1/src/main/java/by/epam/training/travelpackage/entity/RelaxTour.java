package by.epam.training.travelpackage.entity;

import java.util.Objects;

public class RelaxTour extends TravelTour {
    private String city;
    private boolean hotCountry;
    private boolean haveSea;
    private HotelStars hotelStars;

    public RelaxTour() {
    }

    public RelaxTour(String city, boolean hotCountry, boolean haveSea, HotelStars hotelStars) {
        this.city = city;
        this.hotCountry = hotCountry;
        this.haveSea = haveSea;
        this.hotelStars = hotelStars;
    }

    public RelaxTour(TransportType transportType, NutritionType nutritionType, int duration, double price, String city, boolean hotCountry, boolean haveSea, HotelStars hotelStars) {
        super(transportType, nutritionType, duration, price);
        this.city = city;
        this.hotCountry = hotCountry;
        this.haveSea = haveSea;
        this.hotelStars = hotelStars;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public HotelStars getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(HotelStars hotelStars) {
        this.hotelStars = hotelStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelaxTour)) return false;
        if (!super.equals(o)) return false;
        RelaxTour relaxTour = (RelaxTour) o;
        return isHotCountry() == relaxTour.isHotCountry() &&
                isHaveSea() == relaxTour.isHaveSea() &&
                getCity().equals(relaxTour.getCity()) &&
                getHotelStars() == relaxTour.getHotelStars();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCity(), isHotCountry(), isHaveSea(), getHotelStars());
    }

    @Override
    public String toString() {
        return "RelaxTour{" +
                "city='" + city + '\'' +
                ", hotCountry=" + hotCountry +
                ", haveSea=" + haveSea +
                ", hotelStars=" + hotelStars +
                '}';
    }
}
