import java.awt.*;

public class Volvo240 extends Car {

    public Volvo240(){ //Constructor
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }
    
    public double speedFactor(){
        double trimFactor = 1.25;
        return getEnginePower() * 0.01 * trimFactor;
    }
}
