#  Train Reservation System

> A modular, console-based railway ticket booking application developed entirely using Core Java.

##  Project Overview

The **Train Reservation System** is a Java-based console application that simulates the basic operations of a railway ticket booking platform.

The system provides a simple and interactive command-line interface through which users can register, view available trains, search for trains, book tickets, view their reservations, and cancel tickets.

The project is designed to demonstrate practical **Object-Oriented Programming (OOP)** and Core Java concepts through a real-world railway reservation scenario.

---

##  Problem Statement

Managing railway reservations manually can be time-consuming and error-prone, especially when handling train information, seat availability, passenger details, ticket booking, and cancellations.

The objective of this project is to develop a simple Java-based system that:

- Organizes train information.
- Allows customers to register.
- Provides train searching functionality.
- Checks seat availability.
- Books tickets based on available seats.
- Automatically calculates ticket fare.
- Generates a unique transaction ID.
- Maintains reservation history.
- Allows users to cancel tickets.
- Restores seats after cancellation.

---

##  Features

###  Customer Registration

Users can register by providing:

- Email ID
- Password
- First Name
- Last Name
- Address
- Phone Number

###  View Available Trains

Users can view available trains along with:

- Train Number
- Train Name
- Source Station
- Destination Station
- Available Seats
- Fare per Seat

###  Search Train

Users can search for a train using its train number.

The system displays the complete details if the train exists.

###  Book Ticket

The booking module allows users to:

1. Enter their registered email.
2. Select a train.
3. Enter the number of seats.
4. Enter the journey date.
5. Check seat availability.
6. Calculate the total fare.
7. Generate a unique transaction ID.
8. Confirm the booking.

###  View Reservations

Users can view their current reservation history, including:

- Transaction ID
- Train Number
- Train Name
- Route
- Journey Date
- Number of Seats
- Total Fare

###  Cancel Ticket

Users can cancel a ticket using the transaction ID.

When a ticket is cancelled:

- The reservation is removed.
- The booked seats are restored.
- A cancellation confirmation is displayed.

###  Input Validation

The system handles common invalid inputs such as:

- Invalid train numbers
- Invalid seat quantities
- Invalid dates
- Non-existing customers
- Non-existing transaction IDs
- Insufficient seats

---

##  Java Concepts Demonstrated

| Concept | Usage in Project |
|---|---|
| Classes & Objects | Train, Customer, Reservation |
| Encapsulation | Private data members and getters |
| Constructors | Initializing objects |
| Methods | Booking, searching and cancellation |
| ArrayList | Storing trains, customers and reservations |
| Loops | Searching and menu processing |
| Conditional Statements | Validation and decision making |
| Exception Handling | Handling invalid dates and input |
| Java Time API | Managing journey dates |
| UUID | Generating unique transaction IDs |
| Modular Programming | Separate classes for different responsibilities |

---

##  System Architecture

```text
                         ┌─────────────────────┐
                         │      Main.java      │
                         │ Application Entry   │
                         └──────────┬──────────┘
                                    │
                                    ▼
                    ┌───────────────────────────┐
                    │   ReservationSystem.java  │
                    │ Menu & User Operations    │
                    └─────────────┬─────────────┘
                                  │
                    ┌─────────────┴─────────────┐
                    │                           │
                    ▼                           ▼
          ┌──────────────────┐       ┌──────────────────┐
          │ TrainManager.java│       │ Reservation.java │
          │ Train Management │       │ Booking Details  │
          └────────┬─────────┘       └────────┬─────────┘
                   │                          │
                   ▼                          ▼
             ┌───────────┐             ┌────────────┐
             │ Train.java │             │ Customer   │
             │ Train Data │             │   .java    │
             └───────────┘             └────────────┘
```

---



##  Technologies / Tools Used

### Programming Language

**Java**

### Java Technologies

- Core Java
- Object-Oriented Programming
- Java Collections Framework
- Java Time API
- UUID

### Development Tools

- Eclipse
- IntelliJ IDEA
- Visual Studio Code
- Command Prompt / Terminal

### Version Control

**Git & GitHub**

---

##  System Requirements

Before running the project, make sure you have:

- Java JDK 8 or above
- Eclipse / IntelliJ IDEA / VS Code
- Git (optional, for GitHub)

Check Java installation:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

---

#  Installation & Run Instructions

## Method 1: Run Using Eclipse

1. Open Eclipse.
2. Select **File → New → Java Project**.
3. Name the project:

```text
TrainReservationSystem
```

4. Create the required Java classes.
5. Copy the source code into the respective files.
6. Right-click `Main.java`.
7. Select:

```text
Run As → Java Application
```

8. The Train Reservation System menu will appear in the console.

---

## Method 2: Run Using Command Prompt

Open Command Prompt inside the `src` directory.

Compile all Java files:

```bash
javac Main.java Train.java Customer.java Reservation.java TrainManager.java ReservationSystem.java
```

Run the application:

```bash
java Main
```

---

#  Application Workflow

```text
START
  │
  ▼
Display Main Menu
  │
  ├───────────────┐
  │               │
  ▼               ▼
Register       View Trains
Customer           │
  │                ▼
  ▼             Display
Store Data      Train List
  │
  └───────────────┐
                  │
                  ▼
             Search Train
                  │
                  ▼
             Display Details
                  │
                  ▼
              Book Ticket
                  │
                  ▼
          Validate Customer
                  │
                  ▼
            Check Train
                  │
                  ▼
          Check Seat Availability
                  │
                  ▼
           Calculate Fare
                  │
                  ▼
        Generate Transaction ID
                  │
                  ▼
          Confirm Booking
                  │
                  ▼
         View Reservations
                  │
                  ▼
          Cancel Ticket
                  │
                  ▼
           Restore Seats
                  │
                  ▼
                EXIT
```

---

#  Fare Calculation

The system automatically calculates the total ticket amount.

### Formula

```text
Total Fare = Number of Seats × Fare per Seat
```

### Example

```text
Fare per Seat = ₹490.50
Number of Seats = 2

Total Fare = 2 × ₹490.50

Total Fare = ₹981.00
```

This reduces manual calculation and minimizes booking errors.

---

#  Example Booking

```text
Customer Email : shreya@example.com

Train Number   : 10001
Train Name     : JODHPUR EXP

From           : HOWRAH
To             : JODHPUR

Journey Date   : 2026-10-15

Seats Booked   : 2
Fare/Seat      : ₹490.50

Total Amount   : ₹981.00

Status         : BOOKED
Transaction ID : Automatically Generated
```

---

#  Testing Instructions

The following test cases can be used to verify the system.

| Test Case | Input / Action | Expected Result |
|---|---|---|
| Customer Registration | Enter valid details | Customer registered successfully |
| View Trains | Select option 2 | Train list is displayed |
| Search Existing Train | Enter `10001` | Train details are displayed |
| Search Invalid Train | Enter `99999` | Train not found |
| Valid Booking | Select available train and seats | Ticket booked successfully |
| Excessive Booking | Request more seats than available | Booking rejected |
| Invalid Seat Count | Enter `0` or negative value | Invalid seat message |
| Invalid Date | Enter invalid date | Date error displayed |
| View Reservations | Select option 5 | Reservation history displayed |
| Valid Cancellation | Enter valid transaction ID | Ticket cancelled successfully |
| Invalid Cancellation | Enter invalid transaction ID | Transaction not found |
| Exit | Select option 7 | Application terminates |

---

# 📸 Screenshots

##  Main Menu

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/2b8ef8cc-feb2-4e79-b3ef-e917cbd9f24d" />


##  Customer Registration

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/3aa283a4-0b60-4030-b20e-9177a3849501" />


##  Available Trains

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/29216d4a-145c-4a42-ac99-39ec4e1d2247" />


The available trains are displayed along with their routes, seats and fares.

---

##  Search Train — Found

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/9a95e95a-422d-4bab-b581-24ac5ff56065" />


The system successfully retrieves details for an existing train.

---

##  Book Ticket

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/9fc22cf8-2b2c-4950-87af-4e7e2849d5d8" />


The user enters booking information including train number, seats and journey date.

---


##  Reservation History

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/b161ca60-d280-468b-bfd8-bcd83212844d" />


The user can view previously created reservations during the current application session.

---

##  Ticket Cancellation

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/beaba0ab-c45e-405a-b436-d6075ec0ccec" />


The system processes ticket cancellation using the transaction ID.

---


#  Data & Security Note

This project is intended for **educational and academic purposes**.

The current version uses in-memory Java collections, so the data is available only while the application is running.

For a production-level application, additional security and persistence mechanisms would be required, such as:

- Password hashing
- Secure authentication
- Role-based authorization
- Database storage
- Input sanitization
- Transaction management
- Secure payment processing

---

#  Future Enhancements

The current console application can be extended into a more complete railway reservation platform.

##  Database Integration

- Oracle Database
- MySQL
- JDBC
- Persistent customer records
- Persistent train information
- Persistent booking history

##  Authentication

- Customer login
- Admin login
- Password hashing
- Role-based access control

##  Admin Module

An administrator could:

- Add new trains
- Remove trains
- Update train information
- Update fares
- Update seat capacity
- View all reservations

##  Graphical User Interface

The console interface can be upgraded using:

- Java Swing
- JavaFX

##  Advanced Reservation Features

Future versions could include:

- PNR generation
- Multiple passenger details
- Seat/class selection
- Waiting list
- Refund calculation
- Train schedules
- Printable tickets
- PDF ticket generation
- Email notifications
- Online payment integration

---

#  Learning Outcomes

Through this project, the following practical skills are demonstrated:

- Designing classes for a real-world problem
- Applying Object-Oriented Programming
- Implementing encapsulation
- Working with Java collections
- Managing objects using `ArrayList`
- Implementing CRUD-style operations
- Validating user input
- Handling exceptions
- Working with dates
- Generating unique transaction IDs
- Organizing a multi-class Java project
- Testing application functionality
- Documenting a software project
- Using Git and GitHub

---

#  What Makes This Project Unique?

Rather than implementing the entire reservation system inside one large Java file, the application follows a **modular class-based design**.

Each class has a specific responsibility:

```text
Train.java
      ↓
Manages train information

Customer.java
      ↓
Manages customer information

Reservation.java
      ↓
Manages booking details

TrainManager.java
      ↓
Manages train search and display

ReservationSystem.java
      ↓
Controls application operations

Main.java
      ↓
Starts the application
```

This approach makes the project:

**Modular → Readable → Maintainable → Extensible**

The same architecture can later be connected to a database or graphical interface without redesigning the entire application.

---

#  Current Limitations

The current version is intentionally designed as a Core Java console application.

Therefore:

- Data is not permanently stored.
- There is no real online payment system.
- There is no live railway API.
- Authentication is basic.
- The application is not connected to a real railway reservation database.
- Multiple users cannot access the system simultaneously.

These limitations provide opportunities for future development.

---

#  Conclusion

The **Train Reservation System** demonstrates how Core Java concepts can be combined to solve a practical real-world problem.

The project provides essential reservation operations such as customer registration, train search, ticket booking, reservation history and ticket cancellation while maintaining a clean and modular code structure.

It also provides a strong foundation for future improvements such as **JDBC database connectivity, authentication, GUI development, admin management and persistent data storage**.

---

#  Author

**Shreya**

CSE Student

---












