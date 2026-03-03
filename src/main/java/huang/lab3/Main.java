package huang.lab3;

import huang.lab3.database.MongoDatabase;
import huang.lab3.database.MySQLDatabase;
import huang.database.lab3.lab3model.Customer;

public class Main {

    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Emmi", "Li",
                "emmy@email.com", "22",
                "111-1111", "New York",
                "Gold", 100);

        Customer c2 = new Customer(2, "Allie", "Smith",
                "alice@email.com", "30",
                "222-2222", "Chicago",
                "Silver", 50);

        Customer c3 = new Customer(3, "Evan", "Brown",
                "elaine@email.com", "28",
                "333-3333", "Dallas",
                "Platinum", 200);

        MySQLDatabase mysql = new MySQLDatabase();
        MongoDatabase mongo = new MongoDatabase();

        try {

            // INSERT
            mysql.insertCustomer(c1);
            mysql.insertCustomer(c2);
            mysql.insertCustomer(c3);

            mongo.insertCustomer(c1);
            mongo.insertCustomer(c2);
            mongo.insertCustomer(c3);

            // READ
            mysql.readCustomers();
            mongo.readCustomers();

            // UPDATE
            mysql.updateCustomerPoints(1, 999);
            mongo.updateCustomerPoints(1, 999);

            // DELETE
            mysql.deleteCustomer(3);
            mongo.deleteCustomer(3);

            System.out.println("FULL CRUD COMPLETED");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}