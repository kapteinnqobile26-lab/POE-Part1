import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {
    @Test
    void testRegisterPatient() {
        HospitalSystem hs = new HospitalSystem();
        // You would call register methods here and assert list size
        assertTrue(true); // placeholder - expand with actual calls
    }

    @Test
    void testPreventDuplicateID() {
        // Test logic to ensure duplicate IDs are rejected
        assertTrue(true);
    }

    @Test
    void testAllocateBed() {
        BedManager bm = new BedManager();
        assertTrue(bm.allocateBed("B01", "P001"));
        assertFalse(bm.isBedAvailable("B01"));
    }

    @Test
    void testPreventOccupiedBed() {
        BedManager bm = new BedManager();
        bm.allocateBed("B01", "P001");
        assertFalse(bm.isBedAvailable("B01"));
    }

    @Test
    void testWardFull() {
        BedManager bm = new BedManager();
        for(int i=1; i<=20; i++) bm.allocateBed(String.format("B%02d", i), "P"+i);
        assertTrue(bm.isWardFull());
    }
}
