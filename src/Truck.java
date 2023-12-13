import java.awt.*;

public class Truck extends Vehicle {
    private double angle;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double initX, double initY) {
        super(nrDoors, enginePower, color, modelName, initX, initY);
    }
    public void raisePlatform (double amount){
        if (notMoving() & amount > 0){
            angle = Math.min(angle + amount, 70);
        }
    }
    public void lowerPlatform (double amount){
        if (notMoving() & amount > 0) {
            angle = Math.max(angle - amount, 0);
        }
    }
    public double getAngle(){
        return angle;
    }

    @Override
    public void gas(double amount) {
        if (getAngle() == 0){
            super.gas(amount);
        }
    }
    @Override
    public void startEngine() {
        if (getAngle() == 0){
            super.startEngine();
        }
    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}