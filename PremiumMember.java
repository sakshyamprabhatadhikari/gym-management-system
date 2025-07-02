// PremiumMember.java
// Represents a premium gym member with a personal trainer

public class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String id, String name, String email, String dob, String startDate,
                         String location, String phone, String gender, double paidAmount,
                         String plan, String referralSource, String trainerName) {
        super(id, name, email, dob, startDate, location, phone, gender, paidAmount, plan, referralSource);
        this.trainerName = trainerName;
    }

    @Override
    public String getMemberType() {
        return "Premium Member";
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\nTrainer: " + trainerName + "\nMembership Type: Premium";
    }
}
