import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaniaTest {

    @Test
    void nr_doors() {
        Scania scania = new Scania(0, 0);
        assertEquals(2, scania.getNrDoors());
    }
    @Test
    void raisePlatform(){
        Scania scania = new Scania(0, 0);
        scania.raisePlatform(20.0);
        assertEquals(20.0, scania.getAngle());
    }

    @Test
    void lowerPlatform(){
        Scania scania = new Scania(0, 0);
        scania.lowerPlatform(15.0);
        assertEquals(0.0, scania.getAngle());
    }

    @Test
    void notMoving(){
        Scania scania = new Scania(0, 0);
        scania.gas(0);
        assertEquals(true, scania.notMoving());
    }

    @Test
    void moving(){
        Scania scania = new Scania(0, 0);
        scania.gas(1);
        assertEquals(false, scania.notMoving());
    }

    @Test
    void whenMoving(){
        Scania scania = new Scania(0, 0);
        scania.gas(1);
        scania.raisePlatform(20.0);
        assertEquals(0.0, scania.getAngle());

    }

    @Test
    void negAmount(){
        Scania scania = new Scania(0, 0);
        scania.lowerPlatform(-3);
        assertEquals(0.0, scania.getAngle());
    }
}
