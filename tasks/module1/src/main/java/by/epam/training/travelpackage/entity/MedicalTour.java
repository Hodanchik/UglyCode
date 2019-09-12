package by.epam.training.travelpackage.entity;

import java.util.Objects;

public class MedicalTour extends TravelTour {
    private boolean medicalSupport;
    private String city;

    public MedicalTour(TransportType transportType, NutritionType nutritionType, int duration, double price) {
        super(transportType, nutritionType, duration, price);
    }

    public MedicalTour(TransportType transportType, NutritionType nutritionType, int duration, double price, boolean medicalSupport, String city) {
        super(transportType, nutritionType, duration, price);
        this.medicalSupport = medicalSupport;
        this.city = city;
    }

    public boolean isMedicalSupport() {
        return medicalSupport;
    }

    public void setMedicalSupport(boolean medicalSupport) {
        this.medicalSupport = medicalSupport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalTour)) return false;
        if (!super.equals(o)) return false;
        MedicalTour that = (MedicalTour) o;
        return isMedicalSupport() == that.isMedicalSupport() &&
                getCity().equals(that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMedicalSupport(), getCity());
    }

    @Override
    public String toString() {
        return "MedicalTour{" +
                "medicalSupport=" + medicalSupport +
                ", city='" + city + '\'' +
                '}';
    }
}
