public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int code) {
        priceCode = code;
    }

    public String getTitle() {
        return title;
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
        if (hasBonusPoints(daysRented))
            return 2;
        return 1;
    }

    private boolean hasBonusPoints(int daysRented) {
        return getPriceCode() == Movie.NEW_RELEASE && daysRented > 1;
    }
}
