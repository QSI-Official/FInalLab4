import java.util.ArrayList;
import java.util.List;
public class Verkstad<carT extends Car>{
    private final int maxAntal;
    private final List<carT> carsInVerkstad;
    public Verkstad(int maxAntal){
        this.maxAntal = maxAntal;
        this.carsInVerkstad = new ArrayList<>();

    }
    public void addCarIfAllowed(carT car) {
            if ((carsInVerkstad.size() < maxAntal) & (!carsInVerkstad.contains(car))) {
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