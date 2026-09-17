public class Customer {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private long phoneNumber;

    public Customer(String email, String password,
                    String firstName, String lastName,
                    String address, long phoneNumber) {

        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void displayCustomer() {

        System.out.println("Name    : " + getName());
        System.out.println("Email   : " + email);
        System.out.println("Address : " + address);
        System.out.println("Phone   : " + phoneNumber);
    }
}
