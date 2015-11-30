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

    public String getTitle() {
        return movie.getTitle();
    }

    public double getRentalAmount() {
        return movie.getRentalAmount(daysRented);
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
