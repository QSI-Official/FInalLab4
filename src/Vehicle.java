import java.awt.*;

public abstract class Vehicle implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private Color color;
    private final String modelName;

    private double currentSpeed;
    private double xCord;
    private double yCord;
    private final Point point;
    private direction currentDir;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double initX, double initY) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        point = new Point();
        currentDir = direction.S;

        setX(initX);
        setY(initY);
    }

    public enum direction {
        N, E, S, W;
    }
    public abstract double speedFactor();

    public void startEngine() {
        if (notMoving()) {
            currentSpeed = 0.1;
        }
    }
    public void stopEngine() {
        currentSpeed = 0;
    }

    public void gas(double amount) {
        if (amount <= 1 & amount >= 0)
            incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount <= 1 & amount >= 0)
            decrementSpeed(amount);
    }

    ////////////////////Getters and Setters///////////////
    public int getNrDoors() {
        return nrDoors;
    }

    public boolean notMoving(){
        return !(getCurrentSpeed() > 0.0);
    }
    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color Clr) {
        color = Clr;
    }

    public String getModelName() {
        return modelName;
    }
    public int getxPoint(){
        return point.x;
    }

    public int getyPoint(){
        return point.y;
    }

    public void setxPoint(int x){
        point.x = x;
    }

    public void setyPoint(int y){
        point.y = y;
    }


    public double getxCord() {
        return xCord;
    }

    public double getyCord() {
        return yCord;
    }

    public void setX(double newX) {
        xCord = newX;
    }

    public void setY(double newY) {
        yCord = newY;
    }

    public direction getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(direction newDirection) {
        currentDir = newDirection;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    //////////////Move methods//////////////

    @Override
    public void move() {
        switch (currentDir) {
            case N -> yCord -= currentSpeed;
            case S -> yCord += currentSpeed;
            case E -> xCord -= currentSpeed;
            case W -> xCord += currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (currentDir) {
            case N:
                currentDir = direction.W;
                break;
            case S:
                currentDir = direction.E;
                break;
            case E:
                currentDir = direction.N;
                break;
            case W:
                currentDir = direction.S;
                break;
        }
    }
    @Override
    public void turnRight() {
        switch (currentDir) {
            case N:
                currentDir = direction.E;
                break;
            case S:
                currentDir = direction.W;
                break;
            case E:
                currentDir = direction.S;
                break;
            case W:
                currentDir = direction.N;
                break;
        }
    }

    public void boundariesCheck(Vehicle vehicle) {
        if (vehicle.getyCord() > 500) {
            vehicle180(vehicle);
            vehicle.setY(500);
        } else if (vehicle.getyCord() < 0) {
            vehicle180(vehicle);
            vehicle.setY(0);
        }
    }

    public void vehicle180(Vehicle vehicle){
        vehicle.stopEngine();
        vehicle.turnRight();
        vehicle.turnRight();
        vehicle.startEngine();
    }
}