package huang.database.lab3.database;

import huang.database.lab3.lab3model.Customer;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoDatabase {

    private static final String URI = "mongodb://localhost:27017";

    private MongoCollection<Document> getCollection() {
        MongoClient client = MongoClients.create(URI);
        MongoDatabase database = client.getDatabase("lab3db");
        return database.getCollection("Customer");
    }

    // INSERT
    public void insertCustomer(Customer c) {
        MongoCollection<Document> collection = getCollection();

        Document doc = new Document("customerID", c.getCustomerID())
                .append("firstName", c.getFirstName())
                .append("lastName", c.getLastName())
                .append("email", c.getEmail())
                .append("age", c.getAge())
                .append("phoneNumber", c.getPhoneNumber())
                .append("address", c.getAddress())
                .append("membershipLevel", c.getMembershipLevel())
                .append("rewardPoints", c.getRewardPoints());

        collection.insertOne(doc);
    }

    // READ
    public void readCustomers() {
        MongoCollection<Document> collection = getCollection();

        for (Document doc : collection.find()) {
            System.out.println("Mongo -> " + doc.toJson());
        }
    }

    // UPDATE
    public void updateCustomerPoints(int customerID, int newPoints) {
        MongoCollection<Document> collection = getCollection();
        collection.updateOne(eq("customerID", customerID),
                set("rewardPoints", newPoints));
    }

    // DELETE
    public void deleteCustomer(int customerID) {
        MongoCollection<Document> collection = getCollection();
        collection.deleteOne(eq("customerID", customerID));
    }
}
