// Might be more suitable as controller

package model;

import java.util.ArrayList;
import java.util.List;

public class RentalService implements IRentalService {
    private List<Movie> movies;
    private List<Customer> customers;

    public RentalService() {
        this.movies = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (movie != null) 
            movies.add(movie);
    }

    public void addCustomer(Customer customer) {
        if (customer != null) 
            customers.add(customer);
    }

    public List<Movie> findAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (!movie.getStatus()) 
                availableMovies.add(movie);
        }
        return availableMovies;
    }

    public List<Movie> findUnavailableMovies() {
        List<Movie> unavailableMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getStatus()) 
                unavailableMovies.add(movie);
        }
        return unavailableMovies;
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) 
                return movie; 
        }
        return null;
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) 
                return customer; 
        }
        return null;
    }

    public Customer findCustomerByMovie(Movie movie) {
        for (Customer customer : customers) {
            if (customer.getMovies().contains(movie))
                return customer;
        }
        return null;
    }

    public List<Movie> findMoviesRentedByCustomer(Customer customer) {
        if (customer != null) 
            return customer.getMovies();
        else
            return new ArrayList<>();
    }

    public List<Movie> findMoviesByGenre(String genre) {
        List<Movie> genreMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) 
                genreMovies.add(movie);
        }
        return genreMovies;
    }

    public List<Movie> findMoviesByYear(int year) {
        List<Movie> yearMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear() == year) 
                yearMovies.add(movie);
        }
        return yearMovies;
    }
    
}
