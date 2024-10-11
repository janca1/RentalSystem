package model;

import java.util.List;

public interface IRentalService {
    void addMovie(Movie movie);
    void addCustomer(Customer customer);
    List<Movie> findAvailableMovies();
    List<Movie> findUnavailableMovies();
    Movie findMovieByTitle(String title);
    Customer findCustomerByName(String name);
    Customer findCustomerByMovie(Movie movie);
    List<Movie> findMoviesRentedByCustomer(Customer customer);
    List<Movie> findMoviesByGenre(String genre);
    List<Movie> findMoviesByYear(int year);
}
