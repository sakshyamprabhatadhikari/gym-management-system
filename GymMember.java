// GymMember.java
// Abstract class to store common properties for all gym members

public abstract class GymMember {
    protected String id;
    protected String name;
    protected String email;
    protected String dob;
    protected String startDate;
    protected String location;
    protected String phone;
    protected String gender;
    protected double paidAmount;
    protected String plan;
    protected String referralSource;

    // Constructor for common attributes
    public GymMember(String id, String name, String email, String dob, String startDate,
                     String location, String phone, String gender, double paidAmount,
                     String plan, String referralSource) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.startDate = startDate;
        this.location = location;
        this.phone = phone;
        this.gender = gender;
        this.paidAmount = paidAmount;
        this.plan = plan;
        this.referralSource = referralSource;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getMemberType();

    // Common method to display member information
    public String displayInfo() {
        return "ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nDOB: " + dob +
                "\nMembership Start: " + startDate + "\nLocation: " + location +
                "\nPhone: " + phone + "\nGender: " + gender + "\nPaid: $" + paidAmount +
                "\nPlan: " + plan + "\nReferral: " + referralSource;
    }
}
