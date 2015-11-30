import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private double delta;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
        delta    = 0.01;
    }

    @Test
    public void singleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.statement();
        assertEquals(9.0, customer.getAmount(), delta);
        assertEquals(2, customer.getFrequentRenterPoints());

    }

    @Test
    public void dualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
        customer.statement();
        assertEquals(18.0, customer.getAmount(), delta);
        assertEquals(4, customer.getFrequentRenterPoints());
    }

    @Test
    public void singleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
        customer.statement();
        assertEquals(1.5, customer.getAmount(), delta);
        assertEquals(1, customer.getFrequentRenterPoints());
    }

    @Test
    public void multipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));
        customer.statement();
        assertEquals(7.5, customer.getAmount(), delta);
        assertEquals(3, customer.getFrequentRenterPoints());
    }

    @Test
    public void multipleRegularStatementFormat() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertEquals("Rental Record for Fred\n" +
                "\tPlan 9 from Outer Space\t2.0\n" +
                "\t8 1/2\t2.0\n\tEraserhead\t3.5\n" +
                "You owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
    }

    private Customer customer;
}