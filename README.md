# Train Ticket Reservation System
This is a website build for searching the Train Schedule , Seat Availability, Train Timings, Fare Enquiry, Trains Between Stations and Booking seats online.  

## **About:**

This project is about the Train-Ticket-Reservation-System which is used to view Train Schedule, search trains, Seat availability, Train timings. We can also enquire about fare of different trains. We can get information about train between two stations. We can book seats online. This provides a safe and secure seat reservation system.

## **Online Train Information and Reservation**

### This Website is built for following purpose:-
* View Trains Schedule
* Search Trains
* Seat Availability
* Train Timings
* Fare Enquiry
* Trains Between Stations
* Booking seats online.
* Login and Logout Security
* Password Changes
* Payment Gateway
* Ticket Booking History

### The Admin have the following access to this website:-

* Login
* Add Trains
* Update Trains
* Remove or cancle Trains
* View Trains
* Profile Edit
* Logout


### The Users have the following Access:-

* Register
* Login
* View Trains
* Check Seat Availability
* Search Trains
* Train Avaiablity and Fare Between Stations
* Books Tickets
* View Booking History
* View Profile
* Update Profile
* Change Password
* Logout


### Technologies used:-

Front-End Development:
* HTML
* CSS
* Bootstrap

Back-End Development
* Java [J2EE]
* JDBC
* Servlet
* Oracle ( SQL )


## ==== Software And Tools Required ======
* : Git [https://www.youtube.com/watch?v=gv7VPQ4LZ7g]
* : Java JDK 8+ [https://www.youtube.com/watch?v=O9PWH9SeTTE]
* : Eclipse EE [https://www.youtube.com/watch?v=8aDsEV7txXE]
* : Apache Maven [https://www.youtube.com/watch?v=jd2zx3dLjuw]
* : Tomcat v8.0+ [https://youtu.be/mLFPodZO8Iw?t=903]

  
## ========== Dummy Database Initialization ===========

STEP 1: Open Java

STEP 2: Login using your credentials

STEP 3 :Execute the below command first to create a new user:


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CreateOracleUser {

    public static void main(String[] args) {

        // Oracle database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "SYSTEM";
        String password = "your_system_password";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            // 1. Allow user creation in Oracle XE
            stmt.execute("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");

            // 2. Create user
            stmt.execute("CREATE USER RESERVATION IDENTIFIED BY MANAGER");

            // 3. Grant DBA privileges
            stmt.execute("GRANT DBA TO RESERVATION");

            // 4. Commit changes
            con.commit();

            System.out.println("User RESERVATION created successfully!");

            // Close connection
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
      }
    }
    
STEP 4: Now execute the below sql query in same terminal


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;

    public class ReservationDatabase {

    public static void main(String[] args) {

        // Oracle database details
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "RESERVATION";
        String password = "MANAGER";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            Statement stmt = con.createStatement();

            // ================= CUSTOMER TABLE =================
            String customerTable =
                    "CREATE TABLE CUSTOMER (" +
                    "MAILID VARCHAR2(40) PRIMARY KEY, " +
                    "PWORD VARCHAR2(20) NOT NULL, " +
                    "FNAME VARCHAR2(20) NOT NULL, " +
                    "LNAME VARCHAR2(20), " +
                    "ADDR VARCHAR2(100), " +
                    "PHNO NUMBER(12) NOT NULL" +
                    ")";

            stmt.executeUpdate(customerTable);


            // ================= ADMIN TABLE =================
            String adminTable =
                    "CREATE TABLE ADMIN (" +
                    "MAILID VARCHAR2(40) PRIMARY KEY, " +
                    "PWORD VARCHAR2(20) NOT NULL, " +
                    "FNAME VARCHAR2(20) NOT NULL, " +
                    "LNAME VARCHAR2(20), " +
                    "ADDR VARCHAR2(100), " +
                    "PHNO NUMBER(12) NOT NULL" +
                    ")";

            stmt.executeUpdate(adminTable);


            // ================= TRAIN TABLE =================
            String trainTable =
                    "CREATE TABLE TRAIN (" +
                    "TR_NO NUMBER(10) PRIMARY KEY, " +
                    "TR_NAME VARCHAR2(70) NOT NULL, " +
                    "FROM_STN VARCHAR2(20) NOT NULL, " +
                    "TO_STN VARCHAR2(20) NOT NULL, " +
                    "SEATS NUMBER(4) NOT NULL, " +
                    "FARE NUMBER(6,2) NOT NULL" +
                    ")";

            stmt.executeUpdate(trainTable);


            // ================= HISTORY TABLE =================
            String historyTable =
                    "CREATE TABLE HISTORY (" +
                    "TRANSID VARCHAR2(36) PRIMARY KEY, " +
                    "MAILID VARCHAR2(40), " +
                    "TR_NO NUMBER(10), " +
                    "DATE DATE, " +
                    "FROM_STN VARCHAR2(20) NOT NULL, " +
                    "TO_STN VARCHAR2(20) NOT NULL, " +
                    "SEATS NUMBER(3) NOT NULL, " +
                    "AMOUNT NUMBER(8,2) NOT NULL, " +
                    "FOREIGN KEY (MAILID) REFERENCES CUSTOMER(MAILID)" +
                    ")";

            stmt.executeUpdate(historyTable);


            // ================= INSERT ADMIN =================
            stmt.executeUpdate(
                    "INSERT INTO ADMIN VALUES " +
                    "('admin@demo.com','admin','System','Admin'," +
                    "'Demo Address 123 colony','9874561230')"
            );


            // ================= INSERT CUSTOMER =================
            stmt.executeUpdate(
                    "INSERT INTO CUSTOMER VALUES " +
                    "('shashi@demo.com','shashi','Shashi','Raj'," +
                    "'Kolkata, West Bengal',954745222)"
            );


            // ================= INSERT TRAINS =================
            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10001,'JODHPUR EXP','HOWRAH','JODHPUR',152,490.50)"
            );

            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10002,'YAMUNA EXP','GAYA','DELHI',52,550.50)"
            );

            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10003,'NILANCHAL EXP','GAYA','HOWRAH',92,451)"
            );

            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10004,'JAN SATABDI EXP','RANCHI','PATNA',182,550)"
            );

            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10005,'GANGE EXP','MUMBAI','KERALA',12,945)"
            );

            stmt.executeUpdate(
                    "INSERT INTO TRAIN VALUES " +
                    "(10006,'GARIB RATH EXP','PATNA','DELHI',1,1450.75)"
            );


            // ================= INSERT HISTORY =================
            stmt.executeUpdate(
                    "INSERT INTO HISTORY VALUES " +
                    "('BBC374-NSDF-4673','shashi@demo.com',10001," +
                    "TO_DATE('02-FEB-2024','DD-MON-YYYY')," +
                    "'HOWRAH','JODHPUR',2,981)"
            );

            stmt.executeUpdate(
                    "INSERT INTO HISTORY VALUES " +
                    "('BBC375-NSDF-4675','shashi@demo.com',10004," +
                    "TO_DATE('12-JAN-2024','DD-MON-YYYY')," +
                    "'RANCHI','PATNA',1,550)"
            );

            stmt.executeUpdate(
                    "INSERT INTO HISTORY VALUES " +
                    "('BBC373-NSDF-4674','shashi@demo.com',10006," +
                    "TO_DATE('22-JUL-2024','DD-MON-YYYY')," +
                    "'PATNA','DELHI',3,4352.25)"
            );


            // Commit changes
            con.commit();

            System.out.println("Database created successfully!");
            System.out.println("Tables and records inserted successfully.");

            // Close connection
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    

STEP 5: Now Execute the below query one by one to check if the tables are created successfully


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.Statement;

    public class DisplayReservationData {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "RESERVATION";
        String password = "MANAGER";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            Statement stmt = con.createStatement();

            // Display ADMIN table
            System.out.println("\n===== ADMIN TABLE =====");

            ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN");

            while (rs.next()) {
                System.out.println(
                    rs.getString("MAILID") + " | " +
                    rs.getString("PWORD") + " | " +
                    rs.getString("FNAME") + " | " +
                    rs.getString("LNAME") + " | " +
                    rs.getString("ADDR") + " | " +
                    rs.getLong("PHNO")
                );
            }


            // Display CUSTOMER table
            System.out.println("\n===== CUSTOMER TABLE =====");

            rs = stmt.executeQuery("SELECT * FROM CUSTOMER");

            while (rs.next()) {
                System.out.println(
                    rs.getString("MAILID") + " | " +
                    rs.getString("PWORD") + " | " +
                    rs.getString("FNAME") + " | " +
                    rs.getString("LNAME") + " | " +
                    rs.getString("ADDR") + " | " +
                    rs.getLong("PHNO")
                );
            }


            // Display TRAIN table
            System.out.println("\n===== TRAIN TABLE =====");

            rs = stmt.executeQuery("SELECT * FROM TRAIN");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("TR_NO") + " | " +
                    rs.getString("TR_NAME") + " | " +
                    rs.getString("FROM_STN") + " | " +
                    rs.getString("TO_STN") + " | " +
                    rs.getInt("SEATS") + " | " +
                    rs.getDouble("FARE")
                );
            }


            // Display HISTORY table
            System.out.println("\n===== HISTORY TABLE =====");

            rs = stmt.executeQuery("SELECT * FROM HISTORY");

            while (rs.next()) {
                System.out.println(
                    rs.getString("TRANSID") + " | " +
                    rs.getString("MAILID") + " | " +
                    rs.getInt("TR_NO") + " | " +
                    rs.getDate("DATE") + " | " +
                    rs.getString("FROM_STN") + " | " +
                    rs.getString("TO_STN") + " | " +
                    rs.getInt("SEATS") + " | " +
                    rs.getDouble("AMOUNT")
                );
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    
    

## ==== Importing and Running the Project Through Eclipse EE ====

Step 0: Open Eclipse Enterprise Edition. Install if not available

Step 1: Click On File > Import > Git > Projects From Git > Clone Uri > Paste The Repository Url: https://github.com/shashirajraja/Train-Ticket-Reservation-System.git > Next > Select Master Branch > Next > Finish

Step 2.A: Right Click on Project > Run as > Maven Build > In the goals field enter "clean install" > apply > run

Step 2.B: Right Click On Project > Build Path > Configure Build Path > Libraries > Remove And Update Any Libraries With Red Mark > Finish

Step 3: [Only if Tomcat v8.0 is not Configured in Eclipse]: Right Click On Project > Run As > Run On Server > Select Tomcat v8.0 > (Select Tomcat V8.0 Installation Location If Asked) Next > Add > Finish

Step 4: In The Server Tab > Double Click On Tomcat Server > Ports > Change The Port Number For Http/1.1 To 8083 > Close And Save

Step 5: Right Click On Project > Run As > Run On Server > Select Tomcat V8.0 > Next > Add All> Done

Step 6: Check Running The Site At http://localhost:8083/trainbook/

Step 7: Default Username And Password For Admin Is "admin@demo.com" And "admin"

Step 8: Default Username And Password For User Is "shashi@demo.com" And "shashi"

## The Screenshots of some of the webPages of this project are Here:
Login Page

<img width="1891" height="1006" alt="image" src="https://github.com/user-attachments/assets/96b4a355-e3d8-4135-8c5b-c8a3543b61b9" />

Register New User

<img width="1905" height="952" alt="image" src="https://github.com/user-attachments/assets/2ee8c43d-aa8c-4691-b2b0-008e0abf1b14" />

User Profile

<img width="1920" height="901" alt="image" src="https://github.com/user-attachments/assets/d0efe61a-0f72-4462-8ce0-ef089ad53dc2" />

Search Trains Between Stations

<img width="1903" height="993" alt="image" src="https://github.com/user-attachments/assets/ebfdb30a-71d0-4636-9180-23ac7fc27522" />

View Trains

<img width="1897" height="1006" alt="image" src="https://github.com/user-attachments/assets/63276f37-af03-4b0b-b20c-584603e4c08a" />

Book Trains

<img width="1920" height="903" alt="image" src="https://github.com/user-attachments/assets/754bc56c-d867-42a2-90b1-c22b987ef441" />

Payment Gateway

<img width="1891" height="1009" alt="image" src="https://github.com/user-attachments/assets/c05d0d91-2890-49a1-a392-26a68f357f78" />

Booked Ticket Information

<img width="1894" height="1002" alt="image" src="https://github.com/user-attachments/assets/05e49d6d-55e4-43d9-8d44-0e8960533d64" />

Ticket Booking History

<img width="1891" height="894" alt="image" src="https://github.com/user-attachments/assets/26894951-9010-4b0a-959a-1db4eaee7f81" />

Fare Enquiry

<img width="1000" height="562" alt="image" src="https://github.com/user-attachments/assets/c0bdd30a-88a8-4cff-b314-a8eca2430c38" />

Change Password

<img width="1000" height="562" alt="image" src="https://github.com/user-attachments/assets/0565d12f-f4db-4b2f-b53f-1959872c19a6" />

Add Trains By Admin

<img width="1000" height="562" alt="image" src="https://github.com/user-attachments/assets/8e5b4300-8c39-4cb5-a083-d81e06ddf7fa" />











