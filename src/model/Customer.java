package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Movie> rentedMovies;

    public Customer(String name) {
        this(name, new ArrayList<>());
    }

    public Customer(String name, List<Movie> rentedMovies) {
        this.name = name;
        this.rentedMovies = rentedMovies;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return rentedMovies;
    }

    public void rentMovie(Movie movie) {
        if (movie != null && !movie.getStatus()) {
            rentedMovies.add(movie);
            movie.rentMovie();
        }
        else    
            System.out.println("Couldn't rent this movie! Check title and availability for this movie.");
    }

    public void returnMovie(Movie movie) {
        if (movie != null && rentedMovies.remove(movie))
            movie.returnMovie();
        else
            System.out.println("Couldn't return this movie! Check title and availability for this movie.");
    }
    
    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("Customer details: [");
        stringRepresentation.append("name: ");
        stringRepresentation.append(name);
        stringRepresentation.append(", rented movies: ");
        if (rentedMovies == null)
            stringRepresentation.append("none");
        else {
            for (int i = 0; i < rentedMovies.size(); i++) {
                stringRepresentation.append(rentedMovies.get(i).getTitle());
                if (i < rentedMovies.size() - 1)
                    stringRepresentation.append(", ");
            }
        } 
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }

}
