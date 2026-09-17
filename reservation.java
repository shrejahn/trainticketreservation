import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private String transactionId;
    private Customer customer;
    private Train train;
    private LocalDate date;
    private int seats;
    private double amount;

    public Reservation(Customer customer,
                        Train train,
                        LocalDate date,
                        int seats) {

        this.transactionId = UUID.randomUUID().toString();
        this.customer = customer;
        this.train = train;
        this.date = date;
        this.seats = seats;
        this.amount = train.getFare() * seats;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Train getTrain() {
        return train;
    }

    public int getSeats() {
        return seats;
    }

    public double getAmount() {
        return amount;
    }

    public void displayReservation() {

        System.out.println("\n---------------------------------------");
        System.out.println("         RESERVATION DETAILS");
        System.out.println("---------------------------------------");

        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Passenger      : " + customer.getName());
        System.out.println("Train          : " + train.getTrainName());
        System.out.println("Train Number   : " + train.getTrainNumber());
        System.out.println("Route          : " +
                train.getFromStation() + " → " +
                train.getToStation());
        System.out.println("Journey Date   : " + date);
        System.out.println("Seats          : " + seats);
        System.out.printf("Total Amount   : ₹%.2f%n", amount);

        System.out.println("---------------------------------------");
    }
}
