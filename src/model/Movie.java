package model;

public class Movie {
    private String title;
    private String genre;
    private int year;
    private boolean isRented;

    public Movie(String title, String genre, int year) {
        this(title, genre, year, false);
    }

    public Movie(String title, String genre, int year, boolean isRented) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public boolean getStatus() {
        return isRented;
    }

    public void rentMovie() {
        this.isRented = true;
    }

    public void returnMovie() {
        this.isRented = false;
    }
    
    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("Movie: [");
        stringRepresentation.append("title: ");
        stringRepresentation.append(title);
        stringRepresentation.append(", genre: ");
        stringRepresentation.append(genre);
        stringRepresentation.append(", year: ");
        stringRepresentation.append(year);
        stringRepresentation.append(", rented: ");
        stringRepresentation.append(isRented);
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }

}
