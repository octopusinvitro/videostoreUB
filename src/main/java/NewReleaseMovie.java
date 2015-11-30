public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String name) {
        super(name);
    }

    public double getRentalAmount(int daysRented) {
        return (double) (daysRented * 3);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
