package view;

import java.util.List;
import java.util.Scanner;

import model.RentalService;
import model.Movie;
import model.Customer;

public class Interpreter {
    private static final String PROMPT = "> ";
    private final Scanner console = new Scanner(System.in);
    private RentalService rentalService;
    private boolean keepReceivingCmds = false;

    public Interpreter(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public void stop() {
        keepReceivingCmds = false;
    }

    public void handleCmds() {
        keepReceivingCmds = true;
        while (keepReceivingCmds) {
            try {
                CmdLine cmdLine = new CmdLine(readNextLine());
                switch (cmdLine.getCmd()) {
                    case HELP:
                        for (Command command : Command.values()) {
                            if (command == Command.ILLEGAL_COMMAND) 
                                continue;
                            System.out.println(command.toString().toLowerCase());
                        }
                        break;

                    case QUIT:
                        keepReceivingCmds = false;
                        break;

                    case RENT:
                        String customerName = cmdLine.getParameter(0);
                        String movieTitle = cmdLine.getParameter(1);
                        Customer c = rentalService.findCustomerByName(customerName);
                        Movie m = rentalService.findMovieByTitle(movieTitle);
                        if (c != null && m != null) 
                            c.rentMovie(m);
                        else 
                            System.out.println("Customer or movie not found.");
                        break;

                    case RETURN:
                        String cn = cmdLine.getParameter(0);
                        String mt = cmdLine.getParameter(1);
                        Customer cust = rentalService.findCustomerByName(cn);
                        Movie mov = rentalService.findMovieByTitle(mt);
                        if (cust != null && mov != null) 
                            cust.returnMovie(mov);
                        else 
                            System.out.println("Customer or movie not found.");
                        break;

                    case ADDM:
                        String title = cmdLine.getParameter(0);
                        String genre = cmdLine.getParameter(1);
                        int year = Integer.parseInt(cmdLine.getParameter(2));
                        rentalService.addMovie(new Movie(title, genre, year));
                        System.out.println("Movie added to rental service: " + title);
                        break;

                    case ADDC:
                        String cName = cmdLine.getParameter(0);
                        rentalService.addCustomer(new Customer(cName));
                        System.out.println("Customer added: " + cName);
                        break;

                    case LIST:
                        List<Movie> availableMovies = rentalService.findAvailableMovies();
                        System.out.println("Available Movies:");
                        for (Movie movie : availableMovies)
                            System.out.println(movie.getTitle());
                        break;

                    case FINDT:
                        String findTitle = cmdLine.getParameter(0);
                        Movie foundMovie = rentalService.findMovieByTitle(findTitle);
                        if (foundMovie != null) 
                            System.out.println("Found movie: " + foundMovie.toString());
                        else 
                            System.out.println("Movie not found: " + findTitle);
                        break;

                    case FINDN:
                        String custName = cmdLine.getParameter(0);
                        Customer customer = rentalService.findCustomerByName(custName);
                        if (customer != null) {
                            List<Movie> rentedMovies = customer.getMovies();
                            System.out.println("Movies rented by " + custName + ":");
                            if (rentedMovies != null && !rentedMovies.isEmpty()) {
                                for (Movie rentedMovie : rentedMovies)
                                    System.out.println(rentedMovie.getTitle());
                            } 
                            else 
                                System.out.println("Customer hasn't rented any movies.");
                        } 
                        else 
                            System.out.println("Customer not found: " + custName);
                        break;

                    case GENRE:
                        String g = cmdLine.getParameter(0);
                        List<Movie> genreMovies = rentalService.findMoviesByGenre(g);
                        if (!genreMovies.isEmpty()) {
                            System.out.println(g + " movies: ");
                            for (Movie genreMovie : genreMovies) 
                                System.out.println(genreMovie.getTitle());
                        } 
                        else 
                            System.out.println("There are no movies of this genre");
                        break;

                    case YEAR:
                        int y = Integer.parseInt(cmdLine.getParameter(0));
                        List<Movie> yearMovies = rentalService.findMoviesByYear(y);
                        if (!yearMovies.isEmpty()) {
                            System.out.println("Movies from " + y + ": ");
                            for (Movie yearMovie : yearMovies) 
                                System.out.println(yearMovie.getTitle());
                        } 
                        else 
                            System.out.println("There are no movies from this year");
                        break;

                    case RENTED:
                        List<Movie> rented = rentalService.findUnavailableMovies();
                        System.out.println("Rented movies and renters:");
                        for (Movie rMovie : rented) {
                            Customer rentingCustomer = rentalService.findCustomerByMovie(rMovie);
                            System.out.println(rMovie.getTitle() + " rented by " + rentingCustomer.getName());
                        }
                        break;

                    default:
                        System.out.println("Illegal command");
                }
            } catch (Exception e) {
                System.out.println("Operation failed");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private String readNextLine() {
        System.out.print(PROMPT);
        return console.nextLine();
    }
}
