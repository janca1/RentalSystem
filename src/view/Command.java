package view;

public enum Command {
    // Rent a movie (RENT name title)
    RENT,
    // Return a movie (RETURN name title)
    RETURN,
    // Add new movie to rental service (ADDM title genre year)
    ADDM,
    // Add new customer (ADDC name)
    ADDC,
    // List all available movies
    LIST,
    // Find movie by title (FINDT title)
    FINDT,
    // Find customer by name (FINDN name)
    FINDN,
    // Find all movies by genre (GENRE genre)
    GENRE,
    // Find all movies by year (YEAR 1994)
    YEAR,
    // Find all rented movies and who rented them
    RENTED,
    // List all commands
    HELP,
    // End
    QUIT,
    // Invalid command
    ILLEGAL_COMMAND
}
