import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        super(2, 125,Color.red, "Saab95");        // Constructor Special method used to initialize objects
	    turboOn = false;                            // Called when an object of a class is created
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
}
