public class RegularMovie extends Movie {

    public RegularMovie(String name) {
        super(name);
    }

    public double getRentalAmount(int daysRented) {
        double rentalAmount = 2;
        if (daysRented > 2)
            rentalAmount += (daysRented - 2) * 1.5;
        return rentalAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
