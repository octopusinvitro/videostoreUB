import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private Statement statement;
    private double delta;
    private Movie newRelease1;
    private Movie newRelease2;
    private Movie childrens;
    private Movie regular1;
    private Movie regular2;
    private Movie regular3;

    @Before
    public void setUp() {
        statement   = new Statement("Fred");
        delta       = 0.01;
        newRelease1 = new NewReleaseMovie("New Release 1");
        newRelease2 = new NewReleaseMovie("New Release 2");
        childrens   = new ChildrensMovie("Childrens");
        regular1    = new RegularMovie("Regular 1");
        regular2    = new RegularMovie("Regular 2");
        regular3    = new RegularMovie("Regular 3");
    }

    @Test
    public void singleNewReleaseStatement() {
        statement.addRental(new Rental(newRelease1, 3));
        statement.generate();
        assertEquals(9.0, statement.getTotalAmount(), delta);
        assertEquals(2, statement.getFrequentRenterPoints());

    }

    @Test
    public void dualNewReleaseStatement() {
        statement.addRental(new Rental(newRelease1, 3));
        statement.addRental(new Rental(newRelease2, 3));
        statement.generate();
        assertEquals(18.0, statement.getTotalAmount(), delta);
        assertEquals(4, statement.getFrequentRenterPoints());
    }

    @Test
    public void singleChildrensStatement() {
        statement.addRental(new Rental(childrens, 3));
        statement.generate();
        assertEquals(1.5, statement.getTotalAmount(), delta);
        assertEquals(1, statement.getFrequentRenterPoints());
    }

    @Test
    public void multipleRegularStatement() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));
        statement.generate();
        assertEquals(7.5, statement.getTotalAmount(), delta);
        assertEquals(3, statement.getFrequentRenterPoints());
    }

    @Test
    public void multipleRegularStatementFormat() {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));

        assertEquals("Rental Record for Fred\n" +
                "\tRegular 1\t2,0\n" +
                "\tRegular 2\t2,0\n" +
                "\tRegular 3\t3,5\n" +
                "You owed 7,5\nYou earned 3 frequent renter points\n", statement.generate());
    }
}