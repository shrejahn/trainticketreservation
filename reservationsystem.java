import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {

    private Scanner scanner;
    private TrainManager trainManager;
    private ArrayList<Customer> customers;
    private ArrayList<Reservation> reservations;

    public ReservationSystem() {

        scanner = new Scanner(System.in);

        trainManager = new TrainManager();

        customers = new ArrayList<>();

        reservations = new ArrayList<>();
    }

    public void start() {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("       TRAIN RESERVATION SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Register Customer");
            System.out.println("2. View All Trains");
            System.out.println("3. Search Train");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Reservations");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerCustomer();
                    break;

                case 2:
                    trainManager.displayAllTrains();
                    break;

                case 3:
                    searchTrain();
                    break;

                case 4:
                    bookTicket();
                    break;

                case 5:
                    viewReservations();
                    break;

                case 6:
                    cancelTicket();
                    break;

                case 7:
                    System.out.println("Thank you for using Train Reservation System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void registerCustomer() {

        System.out.println("\n========== CUSTOMER REGISTRATION ==========");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        long phone = scanner.nextLong();
        scanner.nextLine();

        Customer customer = new Customer(
                email,
                password,
                firstName,
                lastName,
                address,
                phone
        );

        customers.add(customer);

        System.out.println("\nCustomer registered successfully!");
    }

    private void searchTrain() {

        System.out.println("\n========== SEARCH TRAIN ==========");

        System.out.print("Enter Train Number: ");

        int trainNumber = scanner.nextInt();
        scanner.nextLine();

        Train train = trainManager.searchTrain(trainNumber);

        if (train != null) {

            System.out.println("\nTrain found:");

            train.displayTrain();

        } else {

            System.out.println("Train not found.");
        }
    }

    private void bookTicket() {

        if (customers.isEmpty()) {

            System.out.println(
                    "Please register a customer before booking."
            );

            return;
        }

        System.out.println("\n========== BOOK TICKET ==========");

        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        Customer customer = findCustomer(email);

        if (customer == null) {

            System.out.println("Customer not found.");

            return;
        }

        trainManager.displayAllTrains();

        System.out.print("\nEnter Train Number: ");
        int trainNumber = scanner.nextInt();

        Train train = trainManager.searchTrain(trainNumber);

        if (train == null) {

            System.out.println("Train not found.");

            return;
        }

        System.out.print("Enter number of seats: ");
        int seats = scanner.nextInt();

        if (seats <= 0) {

            System.out.println("Invalid number of seats.");

            return;
        }

        if (!train.bookSeats(seats)) {

            System.out.println("Not enough seats available.");

            return;
        }

        System.out.print("Enter journey date (YYYY-MM-DD): ");

        scanner.nextLine();

        String dateInput = scanner.nextLine();

        LocalDate date;

        try {

            date = LocalDate.parse(dateInput);

        } catch (Exception e) {

            System.out.println("Invalid date format.");

            train.cancelSeats(seats);

            return;
        }

        Reservation reservation =
                new Reservation(customer, train, date, seats);

        reservations.add(reservation);

        System.out.println("\nTicket booked successfully!");

        reservation.displayReservation();
    }

    private void viewReservations() {

        System.out.println("\n========== RESERVATION HISTORY ==========");

        if (reservations.isEmpty()) {

            System.out.println("No reservations found.");

            return;
        }

        for (Reservation reservation : reservations) {

            reservation.displayReservation();
        }
    }

    private void cancelTicket() {

        if (reservations.isEmpty()) {

            System.out.println("No reservations available.");

            return;
        }

        System.out.println("\n========== CANCEL TICKET ==========");

        System.out.print("Enter Transaction ID: ");

        String transactionId = scanner.nextLine();

        Reservation reservationToCancel = null;

        for (Reservation reservation : reservations) {

            if (reservation.getTransactionId()
                    .equals(transactionId)) {

                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {

            reservationToCancel.getTrain()
                    .cancelSeats(reservationToCancel.getSeats());

            reservations.remove(reservationToCancel);

            System.out.println("Ticket cancelled successfully.");

        } else {

            System.out.println("Transaction ID not found.");
        }
    }

    private Customer findCustomer(String email) {

        for (Customer customer : customers) {

            if (customer.getEmail()
                    .equalsIgnoreCase(email)) {

                return customer;
            }
        }

        return null;
    }
}
