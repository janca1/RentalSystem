package test;

import model.Customer;
import model.Movie;
import model.RentalService;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RentalServiceTest {
    private RentalService rs;
    private Customer c1, c2;
    private Movie m1, m2, m3;

    @Before
    public void setUp() {
        rs = new RentalService();
        m1 = new Movie("The Godfather", "Crime", 1972);
        m2 = new Movie("The Dark Knight", "Action", 2008);
        m3 = new Movie("Angry Men", "Crime", 1957);
        c1 = new Customer("Ines");
        c2 = new Customer("Kendra");

        rs.addMovie(m1);
        rs.addMovie(m2);
        rs.addMovie(m3);
        rs.addCustomer(c1);
        rs.addCustomer(c2);
    }

    @Test
    public void testRentMovie() {
        c1.rentMovie(m1);  
        assertTrue(m1.getStatus());  
        assertTrue(c1.getMovies().contains(m1));  
    }

    @Test
    public void testReturnMovie() {
        c1.rentMovie(m1); 
        c1.returnMovie(m1);  
        assertFalse(m1.getStatus());  
        assertFalse(c1.getMovies().contains(m1));  
    }

    @Test
    public void testAddMovie() {
        Movie m4 = new Movie("Pulp Fiction", "Crime", 1994);
        rs.addMovie(m4);
        assertEquals(4, rs.findAvailableMovies().size());
    }

    @Test
    public void testAddCustomer() {
        Customer c3 = new Customer("Leonardo");
        rs.addCustomer(c3);
        assertNotNull(rs.findCustomerByName("Leonardo"));
    }

}
