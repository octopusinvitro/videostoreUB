public class RegularMovie extends Movie {

    public RegularMovie(String name, int priceCode) {
        super(name, priceCode);
    }

    public double getRentalAmount(int daysRented) {
        double rentalAmount = 0;

        switch (getPriceCode()) {
            case REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }

        return rentalAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
