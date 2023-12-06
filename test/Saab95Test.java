import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    @Test
    void nr_doors() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    void setTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor());
    }
    @Test
    void setTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.startEngine();
        assertEquals(1.25, saab.speedFactor());
    }
    @Test
    void SpeedFactorWithNoTurbo () {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.startEngine();
        saab.gas(0.4);
        assertEquals(1.25, saab.speedFactor());
    }
    @Test
    void SpeedFactorWithTurbo () {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        saab.startEngine();
        saab.gas(0.4);
        assertEquals(1.625, saab.speedFactor());
    }
}