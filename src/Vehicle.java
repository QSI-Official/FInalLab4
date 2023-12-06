import java.awt.*;

public abstract class Vehicle implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private double xCord;
    private double yCord;
    private Point point = new Point();    // tuple av två int
    private direction currentDir = direction.S; // Variable

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;                           // Car Constructor. Special method used to initialize objects
        this.enginePower = enginePower;                   // Called when an object of a class is created
        this.color = color;
        this.modelName = modelName;
    }
    public enum direction {  //Special class, represents a group of constants
        N, E, S, W
    }
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

    public void startEngine() {
        if (notMoving()) {
            currentSpeed = 0.1;
        }
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    } //If the getCurrentspeed exceeds enginepower the math.min will take the min which is the enginepower

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    } //If the getCurrentspeed is below 0 the math.max will choose 0


    public abstract double speedFactor();

    public void gas(double amount) { // Om amount är mindre eller lika med 1 OCH amount är större eller lika med 0
        if (amount <= 1 & amount >= 0)
            incrementSpeed(amount);
    }

    public void brake(double amount) { // Om amount är mindre eller lika med 1 OCH amount är större eller lika med 0
        if (amount <= 1 & amount >= 0)
            decrementSpeed(amount);
    }

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
}