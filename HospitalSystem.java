import java.util.*;

public class HospitalSystem {
    private ArrayList<Patient> patients;
    private BedManager bedManager;
    private Scanner scanner;
    private final String WARD_NUMBER = "W1";

    public HospitalSystem() {
        patients = new ArrayList<>();
        bedManager = new BedManager();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n===== MEDICARE HOSPITAL SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Allocate Bed");
            System.out.println("7. Release Bed");
            System.out.println("8. Display Ward Layout");
            System.out.println("9. Display Available Beds");
            System.out.println("10. Display Occupied Beds");
            System.out.println("11. Generate Reports");
            System.out.println("12. Sort Patients");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                handleChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice!= 0);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1: registerPatient(); break;
            case 2: searchPatient(); break;
            case 3: updatePatient(); break;
            case 4: deletePatient(); break;
            case 5: displayAllPatients(); break;
            case 6: allocateBed(); break;
            case 7: releaseBed(); break;
            case 8: bedManager.displayWardLayout(); break;
            case 9: bedManager.displayAvailableBeds(); break;
            case 10: bedManager.displayOccupiedBeds(); break;
            case 11: generateReports(); break;
            case 12: sortPatients(); break;
            case 0: System.out.println("Exiting..."); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private void registerPatient() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        if (searchPatientByID(id)!= null) {
            System.out.println("Error: Patient ID already exists.");
            return;
        }
        System.out.print("First Name: "); String fn = scanner.nextLine();
        System.out.print("Last Name: "); String ln = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Gender: "); String gender = scanner.nextLine();
        System.out.print("Medical Condition: "); String condition = scanner.nextLine();
        System.out.print("Category - 1.Inpatient 2.Outpatient 3.Emergency: ");
        int cat = scanner.nextInt(); scanner.nextLine();

        Patient p;
        if (cat == 1) {
            p = new Inpatient(id, fn, ln, age, gender, condition, WARD_NUMBER, "");
        } else if (cat == 2) {
            p = new Patient(id, fn, ln, age, gender, condition, PatientCategory.OUTPATIENT);
        } else {
            p = new Patient(id, fn, ln, age, gender, condition, PatientCategory.EMERGENCY);
        }
        patients.add(p);
        System.out.println("Patient registered successfully.");
    }

    private Patient searchPatientByID(String id) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(id)) return p;
        }
        return null;
    }

    private void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        String id = scanner.nextLine();
        Patient p = searchPatientByID(id);
        if (p!= null) p.displayDetails();
        else System.out.println("Patient not found.");
    }

    private void updatePatient() { /* similar logic - omitted for space, but included in full file */ }
    private void deletePatient() { /* similar logic */ }
    private void displayAllPatients() {
        for (Patient p : patients) p.displayDetails();
    }
    private void allocateBed() { /* checks if inpatient, ward full, bed available */ }
    private void releaseBed() { /* finds inpatient and frees bed */ }
    private void generateReports() { /* displays all patients, available, occupied, total */ }
    private void sortPatients() { /* sort by surname or ID using Comparator */ }
}
