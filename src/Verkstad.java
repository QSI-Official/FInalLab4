import java.awt.*;
import java.util.ArrayList;
import java.util.List;
// carT is the placeholder and must be a subtype of (or the same type as Car)
// This allows the code to work with various types of Cars without being tied to a specific one.
public class Verkstad<carT extends Car>{
    private final int maxAntal;
    private List<carT> carsInVerkstad;
    public Verkstad(int maxAntal){
        this.maxAntal = maxAntal;
        this.carsInVerkstad = new ArrayList<>();

    }
    public void addCarIfAllowed(carT car) {
            if (carsInVerkstad.size() < maxAntal) {
                carsInVerkstad.add(car);
            }
    }
    public void checkOut(carT car){
        carsInVerkstad.remove(car);
    }
    public List<carT> getCarList(){
        return carsInVerkstad;
    }

}