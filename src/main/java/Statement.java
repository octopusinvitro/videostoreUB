import java.util.Vector;
import java.util.Enumeration;

public class Statement {
    private String customerName;
    private Vector rentals;
    private double totalAmount;
    private int frequentRenterPoints;

    public Statement(String name) {
        this.customerName = name;
        rentals   = new Vector();
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String generate() {
        totalAmount = 0;
        frequentRenterPoints = 0;

        String statementText = header();
        statementText += rentalCalculation();
        statementText += footer();
        return statementText;
    }

    private String header() {
        return String.format("Rental Record for %s\n", customerName);
    }

    private String rentalCalculation() {
        String statementText = "";
        Enumeration rentals = this.rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            double thisAmount = rentalLine(each);

            frequentRenterPoints++;

            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1)
                frequentRenterPoints++;

            statementText += String.format("\t%s\t%.1f\n", each.getMovie().getTitle(), thisAmount);
            totalAmount += thisAmount;

        }
        return statementText;
    }

    private double rentalLine(Rental rental) {
        return getRentalAmount(rental);
    }

    private double getRentalAmount(Rental rental) {
        double rentalAmount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (rental.getDaysRented() > 2)
                    rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    private String footer() {
        return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
    }
}
