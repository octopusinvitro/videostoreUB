public class ChildrensMovie extends Movie {

    public ChildrensMovie(String name) {
        super(name);
    }

    public double getRentalAmount(int daysRented) {
        double rentalAmount = 1.5;
        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;
        return rentalAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
