public class Train {

    private int trainNumber;
    private String trainName;
    private String fromStation;
    private String toStation;
    private int seats;
    private double fare;

    public Train(int trainNumber, String trainName,
                 String fromStation, String toStation,
                 int seats, double fare) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.seats = seats;
        this.fare = fare;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public int getSeats() {
        return seats;
    }

    public double getFare() {
        return fare;
    }

    public boolean bookSeats(int numberOfSeats) {

        if (numberOfSeats <= seats) {
            seats -= numberOfSeats;
            return true;
        }

        return false;
    }

    public void cancelSeats(int numberOfSeats) {
        seats += numberOfSeats;
    }

    public void displayTrain() {

        System.out.printf(
            "%-10d %-20s %-15s %-15s %-10d ₹%.2f%n",
            trainNumber,
            trainName,
            fromStation,
            toStation,
            seats,
            fare
        );
    }
}
