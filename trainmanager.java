import java.util.ArrayList;

public class TrainManager {

    private ArrayList<Train> trains;

    public TrainManager() {

        trains = new ArrayList<>();

        addDefaultTrains();
    }

    private void addDefaultTrains() {

        trains.add(new Train(
                10001,
                "JODHPUR EXP",
                "HOWRAH",
                "JODHPUR",
                152,
                490.50
        ));

        trains.add(new Train(
                10002,
                "YAMUNA EXP",
                "GAYA",
                "DELHI",
                52,
                550.50
        ));

        trains.add(new Train(
                10003,
                "NILANCHAL EXP",
                "GAYA",
                "HOWRAH",
                92,
                451.00
        ));

        trains.add(new Train(
                10004,
                "JAN SATABDI EXP",
                "RANCHI",
                "PATNA",
                182,
                550.00
        ));

        trains.add(new Train(
                10005,
                "GANGE EXP",
                "MUMBAI",
                "KERALA",
                12,
                945.00
        ));

        trains.add(new Train(
                10006,
                "GARIB RATH EXP",
                "PATNA",
                "DELHI",
                1,
                1450.75
        ));
    }

    public void displayAllTrains() {

        System.out.println("\n================ TRAIN LIST ================");

        System.out.printf(
            "%-10s %-20s %-15s %-15s %-10s %s%n",
            "Number",
            "Train Name",
            "From",
            "To",
            "Seats",
            "Fare"
        );

        System.out.println(
            "--------------------------------------------------------------------------"
        );

        for (Train train : trains) {
            train.displayTrain();
        }
    }

    public Train searchTrain(int trainNumber) {

        for (Train train : trains) {

            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }

        return null;
    }

    public void searchRoute(String from, String to) {

        boolean found = false;

        for (Train train : trains) {

            if (train.getFromStation().equalsIgnoreCase(from)
                    && train.getToStation().equalsIgnoreCase(to)) {

                train.displayTrain();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains found for this route.");
        }
    }
}
