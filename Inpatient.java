public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String patientID, String firstName, String lastName, int age,
                     String gender, String medicalCondition, String wardNumber, String bedNumber) {
        super(patientID, firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public String getWardNumber() { return wardNumber; }
    public String getBedNumber() { return bedNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }
    public void setWardNumber(String wardNumber) { this.wardNumber = wardNumber; }

    @Override // Override superclass method
    public void displayDetails() {
        super.displayDetails();
        System.out.println(" -> Ward: " + wardNumber + " | Bed: " + bedNumber);
    }
}
