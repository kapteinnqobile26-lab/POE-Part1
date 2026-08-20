public class BedManager {
    private String[][] beds; // 4x5 = 20 beds
    private final int ROWS = 4;
    private final int COLS = 5;

    public BedManager() {
        beds = new String[ROWS][COLS];
        int bedCount = 1;
        // Initialize beds B01 to B20
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                beds[i][j] = String.format("B%02d", bedCount++);
            }
        }
    }

    public void displayWardLayout() {
        System.out.println("\n--- WARD LAYOUT ---");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(beds[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean allocateBed(String bedID, String patientID) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (beds[i][j].equals(bedID)) {
                    beds[i][j] = bedID + "(" + patientID + ")"; // Mark as occupied
                    return true;
                }
            }
        }
        return false;
    }

    public boolean releaseBed(String bedID) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (beds[i][j].contains(bedID + "(")) {
                    beds[i][j] = bedID; // Make available again
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBedAvailable(String bedID) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (beds[i][j].equals(bedID)) return true;
            }
        }
        return false;
    }

    public boolean isWardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!beds[i][j].contains("(")) return false;
            }
        }
        return true;
    }

    public void displayAvailableBeds() {
        System.out.println("\n--- AVAILABLE BEDS ---");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!beds[i][j].contains("(")) System.out.print(beds[i][j] + " ");
            }
        }
        System.out.println();
    }

    public void displayOccupiedBeds() {
        System.out.println("\n--- OCCUPIED BEDS ---");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (beds[i][j].contains("(")) System.out.print(beds[i][j] + " ");
            }
        }
        System.out.println();
    }
}
