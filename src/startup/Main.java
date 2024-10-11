package startup;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model. Movie;
import model.RentalService;
import view.Interpreter;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
    
        customers.add(new Customer("Leonardo"));
        customers.add(new Customer("Omar"));
        customers.add(new Customer("Tiffany"));
        customers.add(new Customer("Ines"));
        customers.add(new Customer("Kendra"));

        movies.add(new Movie("The Godfather", "Crime", 1972));
        movies.add(new Movie("The Dark Knight", "Action", 2008));
        movies.add(new Movie("Angry Men", "Crime", 1957));
        movies.add(new Movie("Pulp Fiction", "Crime", 1994));
        movies.add(new Movie("Inception", "Action", 2010));
        movies.add(new Movie("Fight Club", "Drama", 1999));
        movies.add(new Movie("Forrest Gump", "Drama", 1994));
        movies.add(new Movie("Interstellar", "Adventure", 2014));
        movies.add(new Movie("The Matrix", "Action", 1999));
        movies.add(new Movie("Goodfellas", "Biography", 1990));

        RentalService rentalService = new RentalService();
        for (Customer customer : customers) 
            rentalService.addCustomer(customer);
        for (Movie movie : movies) 
            rentalService.addMovie(movie);

        // TESTING BEFORE UI: (line 40-75)
        /* 
        // Display available movies:
        System.out.println("Available Movies:");
        rentalService.findAvailableMovies().forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println("");

        // Leonardo rents one movie 
        Customer c = rentalService.findCustomerByName("Leonardo");
        Movie m = rentalService.findMovieByTitle("Inception");
        c.rentMovie(m);

        // Display available movies again, look for change:
        System.out.println("Available Movies:");
        rentalService.findAvailableMovies().forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println("");

        // Movies rented by Leonardo:
        System.out.println("Rented by Leonardo: ");
        List<Movie> rentedMovies = c.getMovies();
        rentedMovies.forEach(rentedMovie -> System.out.println(rentedMovie.getTitle()));
        System.out.println("");

        // Leonardo returns movie
        c.returnMovie(m);

        // Movies rented by Leonardo:
        System.out.println("Rented by Leonardo: ");
        //List<Movie> rentedMovies = c.getMovies();
        rentedMovies.forEach(rentedMovie -> System.out.println(rentedMovie.getTitle()));
        System.out.println("");

        // Display movies again:
        System.out.println("Available Movies:");
        rentalService.findAvailableMovies().forEach(movie -> System.out.println(movie.getTitle()));
        */

        Interpreter interpreter = new Interpreter(rentalService);
        interpreter.handleCmds();
    }
}
