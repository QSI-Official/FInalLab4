import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BilTransportTest {
    @Test
    void nr_doors() {
        BilTransport Mercedes = new BilTransport(0, 0);
        assertEquals(2, Mercedes.getNrDoors());
    }

    @Test
    void platFormDown(){
        BilTransport Mercedes = new BilTransport(0, 0);
        Mercedes.setPlatformDown(false);
        Mercedes.startEngine();
        Mercedes.gas(10);
        Mercedes.move();
        assertEquals(false, Mercedes.notMoving());

    }
    @Test
    public void platformDownOnlyIfStopped() {
        BilTransport mercedes = new BilTransport(0, 0);
        mercedes.startEngine();
        mercedes.gas(0.5);
        mercedes.move();
        mercedes.setPlatformDown(true);
        assertEquals(false, mercedes.isPlatformDown());
    }
    @Test
    public void testLoadCarWhenDistanceIsOKAndPlatformIsDown() {
        BilTransport bilTransport = new BilTransport(0, 0);
        Saab95 saab = new Saab95(0, 0);
        bilTransport.setPlatformDown(true);
        bilTransport.loadCar(saab);
        assertEquals(1, bilTransport.getCarStorageSize());
    }
    @Test
    public void testLoadCarWhenPlatformIsNotDown() {
        BilTransport bilTransport = new BilTransport(0, 0);
        Saab95 saab = new Saab95(0, 0);
        bilTransport.setPlatformDown(false);
        bilTransport.loadCar(saab);
        assertEquals(0, bilTransport.getCarStorageSize());
    }
    @Test
    public void testUnLoadCarWithLastCarInStorage() {
        BilTransport bilTransport = new BilTransport(0, 0);
        Saab95 saab = new Saab95(0, 0);
        Volvo240 volvo = new Volvo240(0, 0);
        bilTransport.setPlatformDown(true);
        bilTransport.loadCar(saab);
        bilTransport.loadCar(volvo);
        bilTransport.unLoadCar(volvo);
        // Check that the last car in storage is removed
        assertEquals(1, bilTransport.getCarStorageSize());
    }
}
