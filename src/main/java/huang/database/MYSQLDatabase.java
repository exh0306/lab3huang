package huang.database.lab3.database;

import huang.database.lab3.lab3model.Customer;

import java.sql.*;

public class MySQLDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/lab3db";
    private static final String USER = "root";
    private static final String PASSWORD = "IST888IST888";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // INSERT
    public void insertCustomer(Customer c) throws SQLException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getCustomerID());
            stmt.setString(2, c.getFirstName());
            stmt.setString(3, c.getLastName());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getAge());
            stmt.setString(6, c.getPhoneNumber());
            stmt.setString(7, c.getAddress());
            stmt.setString(8, c.getMembershipLevel());
            stmt.setInt(9, c.getRewardPoints());

            stmt.executeUpdate();
        }
    }

    // READ
    public void readCustomers() throws SQLException {
        String sql = "SELECT * FROM Customer";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("MySQL -> " +
                        rs.getInt("customerID") + " " +
                        rs.getString("firstName") + " " +
                        rs.getString("lastName") + " Points: " +
                        rs.getInt("rewardPoints"));
            }
        }
    }

    // UPDATE
    public void updateCustomerPoints(int customerID, int newPoints) throws SQLException {
        String sql = "UPDATE Customer SET rewardPoints = ? WHERE customerID = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newPoints);
            stmt.setInt(2, customerID);
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deleteCustomer(int customerID) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customerID = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerID);
            stmt.executeUpdate();
        }
    }
}
