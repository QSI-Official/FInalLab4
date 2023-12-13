import java.awt.*;

public class Volvo240 extends Car {

    public Volvo240(double initX, double initY){ //Constructor
        super(4, 100, Color.black, "Volvo240", initX, initY);
        stopEngine();
    }
    
    public double speedFactor(){
        double trimFactor = 1.25;
        return getEnginePower() * 0.01 * trimFactor;
    }
}
