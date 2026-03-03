package huang.lab3;

import huang.lab3.database.MySQLDatabase;
import huang.lab3.database.MongoDatabase;
import huang.database.lab3.lab3model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // MySQL connection info
    private static final String URL = "jdbc:mysql://localhost:3306/lab3db";
    private static final String USER = "root";
    private static final String PASSWORD = "IST888IST888";

    public static void main(String[] args) {
        // Create customers
        Customer c1 = new Customer(1, "Emmi", "Li", "emmy@email.com", "22",
                "111-1111", "New York", "Gold", 100);
        Customer c2 = new Customer(2, "Allie", "Smith", "alice@email.com", "30",
                "222-2222", "Chicago", "Silver", 50);
        Customer c3 = new Customer(3, "Evan", "Brown", "elaine@email.com", "28",
                "333-3333", "Dallas", "Platinum", 200);

        // Initialize database handlers
        MySQLDatabase mysql = null;
        MongoDatabase mongo = null;
        try {
            mysql = new MySQLDatabase();
            mongo = new MongoDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error initializing databases.");
            return;
        }

        try {
            // --- CLEAR MySQL table first ---
            System.out.println("\n--- CLEARING MySQL TABLE ---");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("TRUNCATE TABLE Customer");
            }
            System.out.println("MySQL table cleared.\n");

            // --- CREATE ---
            System.out.println("--- INSERTING CUSTOMERS ---");
            mysql.insertCustomer(c1);
            mysql.insertCustomer(c2);
            mysql.insertCustomer(c3);

            mongo.insertCustomer(c1);
            mongo.insertCustomer(c2);
            mongo.insertCustomer(c3);
            System.out.println("Inserted 3 customers into MySQL and MongoDB.\n");

            // --- READ ---
            System.out.println("--- READ MySQL ---");
            mysql.readCustomers();

            System.out.println("\n--- READ MongoDB ---");
            mongo.readCustomers();

            // --- UPDATE ---
            System.out.println("\n--- UPDATE Customer Points (ID 1 -> 999) ---");
            mysql.updateCustomerPoints(1, 999);
            mongo.updateCustomerPoints(1, 999);

            System.out.println("Updated points for customerID 1.\n");

            // --- READ after UPDATE ---
            System.out.println("--- READ MySQL AFTER UPDATE ---");
            mysql.readCustomers();

            System.out.println("\n--- READ MongoDB AFTER UPDATE ---");
            mongo.readCustomers();

            // --- DELETE ---
            System.out.println("\n--- DELETE Customer (ID 3) ---");
            mysql.deleteCustomer(3);
            mongo.deleteCustomer(3);
            System.out.println("Deleted customerID 3.\n");

            // --- READ after DELETE ---
            System.out.println("--- READ MySQL AFTER DELETE ---");
            mysql.readCustomers();

            System.out.println("\n--- READ MongoDB AFTER DELETE ---");
            mongo.readCustomers();

            System.out.println("\nFULL CRUD COMPLETED");

        } catch (SQLException e) {
            System.out.println("MySQL error:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("MongoDB error:");
            e.printStackTrace();
        }
    }
}