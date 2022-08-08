package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name can't be blank/empty");
        if (format == null || format.isBlank())
            throw new IllegalArgumentException("Name must contain a value");
        if (!(format.equalsIgnoreCase("dvd") || format.equalsIgnoreCase("blue-ray")))
            throw new IllegalArgumentException("Wrong format, should be dvd/blue-ray");
        if (rating < 0 || rating > 10)
            throw new IllegalArgumentException("Invalid rating");

        this.name = name;
        this.format = format;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.rating = rating;
        this.isAvailable = true;

    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name can't be null or blank");
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray")))
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray");
        this.format = format;
        setSellingPrice(format.equalsIgnoreCase("Blue-Ray") ? 4.25 : 2.25);
        setRentalPrice(format.equalsIgnoreCase("Blue-Ray") ? 1.99 : 0.99);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10)
            throw new IllegalArgumentException("Invalid rating");
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        if (sellingPrice <= 0)
            throw new IllegalArgumentException("Price can't be equal/less than 0");
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        if (rentalPrice <= 0)
            throw new IllegalArgumentException("Price can't be equal/less than 0");
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public String toString() {
        return "\t Name: " + name + "\n" +

                "\t Format: " + format + "\n" +

                "\t Rating: " + rating + "\n" +

                "\t Selling Price: " + sellingPrice + "\n" +

                "\t Rental Price: " + rentalPrice + "\n" +

                "\t Availability: " + (this.isAvailable ? "in stock" : "rented") + "\n";
    }
}
