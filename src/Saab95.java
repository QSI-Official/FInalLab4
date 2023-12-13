import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(double initX, double initY){
        super(2, 125,Color.red, "Saab95", initX, initY);
	    turboOn = false;
        stopEngine();
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    /////////////Setters/////////////
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
}
