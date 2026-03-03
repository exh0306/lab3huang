package huang.database.lab3.lab3model;

public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String phoneNumber;
    private String address;
    /**
     * Membership level (Silver, Gold, Platinum)
     */
    private String membershipLevel;
    private int rewardPoints;


    // Default constructor
    public Customer() {
    }
    public Customer(int customerID,
                    String firstName,
                    String lastName,
                    String email,
                    String age,
                    String phoneNumber,
                    String address,
                    String membershipLevel,
                    int rewardPoints) {

        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipLevel = membershipLevel;
        this.rewardPoints = rewardPoints;
    }


    // Getters and Setters

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    /**
     * Displays customer information
     */
    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Membership Level: " + membershipLevel);
        System.out.println("Reward Points: " + rewardPoints);
        System.out.println("-----------------------------");
    }
}

