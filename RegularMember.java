// RegularMember.java
// Represents a regular gym member

public class RegularMember extends GymMember {

    public RegularMember(String id, String name, String email, String dob, String startDate,
                         String location, String phone, String gender, double paidAmount,
                         String plan, String referralSource) {
        super(id, name, email, dob, startDate, location, phone, gender, paidAmount, plan, referralSource);
    }

    @Override
    public String getMemberType() {
        return "Regular Member";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\nMembership Type: Regular";
    }
}
