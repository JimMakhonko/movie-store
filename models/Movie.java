package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        this.name = name;
        this.format = format;
        if (this.format.equals("Blue-Ray")) {
            setSellingPrice(4.25);
            setRentalPrice(1.99);
        }
        if (this.format.equals("DVD")){
            setSellingPrice(2.25);
            setRentalPrice(0.99);
        }
        this.rating = rating;
        this.isAvailable = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Movie(Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = true;
    }
    public String toString(){
        return "\t Name: " + name + "\n" +

                "\t Format: " + format + "\n" +

                "\t Rating: " + rating + "\n" +

                "\t Selling Price: " + sellingPrice + "\n" +

                "\t Rental Price: " + rentalPrice + "\n" +

                "\t Availability: " + isAvailable() + "\n";
    }
}