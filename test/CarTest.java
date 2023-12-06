import org.junit.jupiter.api.Test;

        import java.awt.*;

        import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void testMoveSaab() {
        Car Saab = new Saab95();
        Saab.startEngine();
        Saab.move();
        assertEquals(0, Saab.getxCord());
        assertEquals(0.1, Saab.getyCord());
        Saab.turnRight();
        Saab.move();
        assertEquals(0.1, Saab.getxCord());
        assertEquals(0.1,Saab.getyCord());
        Saab.turnRight();
        Saab.turnRight();
        Saab.move();
        assertEquals(0, Saab.getxCord());
        assertEquals(0.1,Saab.getyCord());
    }
    @Test
    void nr_doorsSaab() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testTurnRightSaab() {
        Car Saab = new Saab95();
        Saab.turnRight();
        assertEquals(Car.direction.E, Saab.getCurrentDir());
    }
    @Test
    public void testTurnRightVolvo() {
        Car Volvo240 = new Volvo240();
        Volvo240.turnRight();
        assertEquals(Car.direction.E, Volvo240.getCurrentDir());
    }

    @Test
    public void testTurnLeftSaab() {
        Car Saab = new Saab95();
        Saab.turnLeft();
        assertEquals(Car.direction.W, Saab.getCurrentDir());
    }
    @Test
    public void testTurnLeftVolvo() {
        Car Volvo240 = new Volvo240();
        Volvo240.turnLeft();
        assertEquals(Car.direction.W, Volvo240.getCurrentDir());
    }

    @Test
    public void testTurningSaab() {
        Car Saab = new Saab95();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        assertEquals(Car.direction.N, Saab.getCurrentDir());
    }
    @Test
    public void testTurningVolvo() {
        Car Volvo240 = new Volvo240();
        Volvo240.turnRight();
        Volvo240.turnRight();
        Volvo240.turnRight();
        Volvo240.turnRight();
        assertEquals(Car.direction.N, Volvo240.getCurrentDir());
    }
    @Test
    public void testTurningS() {
        Car Saab = new Saab95();
        Saab.turnRight();
        Saab.turnLeft();
        Saab.turnRight();
        Saab.turnRight();
        assertEquals(Car.direction.S, Saab.getCurrentDir());
    }
    @Test
    public void testTurningW() {
        Car Saab = new Saab95();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnRight();
        Saab.turnRight();
        assertEquals(Car.direction.W, Saab.getCurrentDir());
    }
    @Test
    public void testTurning() {
        Car Saab = new Saab95();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        assertEquals(Car.direction.E, Saab.getCurrentDir());
    }

    @Test
    public void testingMoveAndTurnVolvo() {
        Car Volvo = new Volvo240();
        Volvo.startEngine();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.incrementSpeed(1);
        Volvo.move();
        assertEquals(0.0, Volvo.getxCord());
    }
    @Test
    public void testIncrementSpeedSaab() {
        Car Saab = new Saab95();
        Saab.startEngine();
        Saab.gas(0.4);
        Saab.incrementSpeed(1);
        Saab.move();
        assertEquals(0.0, Saab.getxCord());
    }
    @Test
    public void testIncrementSpeedVolvo() {
        Car Volvo = new Volvo240();
        Volvo.startEngine();
        Volvo.gas(0.4);
        Volvo.move();
        assertEquals(0.6, Volvo.getCurrentSpeed());
    }
    @Test
    public void testDecrementSpeedSaab(){
        Car Saab = new Saab95();
        Saab.startEngine();
        Saab.gas(0.4);
        Saab.move();
        Saab.brake(1);
        Saab.decrementSpeed(1.5);
        assertEquals(0, Saab.getCurrentSpeed());
    }
    @Test
    public void testDecrementSpeedVolvo(){
        Car Volvo = new Volvo240();
        Volvo.startEngine();
        Volvo.gas(0.4);
        Volvo.move();
        Volvo.brake(1);
        Volvo.decrementSpeed(1.5);
        assertEquals(0, Volvo.getCurrentSpeed());
    }
    @Test
    public void ColorSaab(){
        Car Saab = new Saab95();
        assertEquals(Color.red, Saab.getColor());
    }
    @Test
    public void ColorVolvo(){
        Car Volvo = new Volvo240();
        assertEquals(Color.black, Volvo.getColor());
    }
    @Test
    public void SetColorVolvo(){
        Car Volvo = new Volvo240();
        Volvo.setColor(Color.BLUE);
        assertEquals(Color.BLUE, Volvo.getColor());
    }
    @Test
    public void GetModelNameSaab(){
        Car Saab = new Saab95();
        assertEquals("Saab95", Saab.getModelName());
    }
    @Test
    public void GetModelNameVolvo(){
        Car Volvo = new Volvo240();
        assertEquals("Volvo240", Volvo.getModelName());
    }
    @Test
    public void GetCurrentSpeed(){
        Car Saab = new Saab95();
        Saab.startEngine();
        Saab.gas(0.4);
        assertEquals(0.6, Saab.getCurrentSpeed());
    }
    @Test
    public void GetEnginePowerSaab(){
        Car Saab = new Saab95();
        assertEquals(125, Saab.getEnginePower());
    }
    @Test
    public void GetEnginePowerVolvo(){
        Car Volvo = new Volvo240();
        assertEquals(100, Volvo.getEnginePower());
    }
    @Test
    public void StopEngineSaab(){
        Car Saab = new Saab95();
        Saab.stopEngine();
        assertEquals(0, Saab.getCurrentSpeed());
    }
    @Test
    public void StopEngineVolvo(){
        Car Volvo = new Volvo240();
        Volvo.stopEngine();
        assertEquals(0, Volvo.getCurrentSpeed());
    }
    @Test
    public void GasingMultipleTimes(){
        Car Volvo = new Volvo240();
        Volvo.startEngine();
        for(int i = 0; i < 150; i++){
            Volvo.gas(1);
        }
        assertEquals(Volvo.getCurrentSpeed(), Volvo.getEnginePower());
    }
}