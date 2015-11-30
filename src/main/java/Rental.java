public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie      = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getRentalAmount() {
        double rentalAmount = 0;

        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }

        return rentalAmount;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public int getFrequentRenterPoints() {
        if (hasBonusPoints())
            return 2;
        return 1;
    }

    private boolean hasBonusPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1;
    }
}
