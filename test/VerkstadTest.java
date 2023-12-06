import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.awt.*;
public class VerkstadTest {
    @Test
    public void testAddCarIfAllowed() {
        Verkstad<Volvo240> Volvo240Verkstad = new Verkstad<>(3);
        Volvo240 volvoCar = new Volvo240();
        Saab95 saabCar = new Saab95();
        Volvo240Verkstad.addCarIfAllowed(volvoCar);
        assertTrue(Volvo240Verkstad.getCarList().contains(volvoCar));
        // Try to add a disallowed car, which should print an error message
        //Volvo240Verkstad.addCarIfAllowed(saabCar);
        // Check that the disallowed car is not added
        assertFalse(Volvo240Verkstad.getCarList().contains(saabCar));
    }
    @Test
    public void testAddCarIfAllowedAndCheckOut() {
        Verkstad<Saab95> Saab95Verkstad = new Verkstad<>(2);
        Saab95 saabCar0 = new Saab95();
        Volvo240 volvoCar = new Volvo240();  // Assuming Volvo240 is not allowed
        Saab95 saabCar1 = new Saab95();     // Assuming Saab95 is allowed
        Saab95 saabCar2 = new Saab95();
        //Saab95Verkstad.addCarIfAllowed(volvoCar);
        Saab95Verkstad.addCarIfAllowed(saabCar1);
        Saab95Verkstad.addCarIfAllowed(saabCar0);
        Saab95Verkstad.addCarIfAllowed(saabCar2);
        assertFalse(Saab95Verkstad.getCarList().contains(volvoCar));
        assertTrue(Saab95Verkstad.getCarList().contains(saabCar0));
        assertTrue(Saab95Verkstad.getCarList().contains(saabCar1));
        assertFalse(Saab95Verkstad.getCarList().contains(saabCar2));
        Saab95Verkstad.checkOut(saabCar1);
        assertFalse(Saab95Verkstad.getCarList().contains(saabCar1));
    }
}