import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class BilTransport extends Truck{
    private final List<Car> carStorage = new ArrayList<>();

    private static final int maxCarDistance = 5;
    private static final int platformFullRaiseAndLowerAngle = 70;


    public BilTransport(){
        super(2, 50, Color.white, "Mercedes");
    }
    public boolean isPlatformDown(){
        return getAngle() == platformFullRaiseAndLowerAngle;
    }
    public void setPlatformDown(boolean platformDown){
        if(platformDown){
            raisePlatform(platformFullRaiseAndLowerAngle);          // if platform should be down, whatever the angle is, set it to 70
        }
        else {
            lowerPlatform(platformFullRaiseAndLowerAngle);
        }
    }
    public double calculateDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }
    public boolean isDistanceOK(Car car){
        double distanceMax = 5.0;
        double distance = calculateDistance(car.getxCord(), car.getyCord(), getxCord(), getyCord());
        return distance <= distanceMax;              // true if car if a maximum of 5 l.u away or less
    }
    public int getCarStorageSize() {
        return carStorage.size();
    }
    public void loadCar(Car car){
        if (isDistanceOK(car) & isPlatformDown()){
            carStorage.add(car);
        }
    }
    public void unLoadCar(Car car) {
        double newCarX, newCarY;
        // Set the direction of the car to the same as the BilTransport
        car.setCurrentDir(getCurrentDir());
        if (carStorage.contains(car) & isPlatformDown() & (carStorage.indexOf(car) == getCarStorageSize()-1)) {
            if (getCurrentDir() == direction.N || getCurrentDir() == direction.E) {
                newCarX = getxCord() - maxCarDistance;       // If direction is N or E, move car to left/up by 5 units
                newCarY = getyCord() - maxCarDistance;
            } else {                           //right/down by 5 units
                newCarX = getxCord() + maxCarDistance;
                newCarY = getyCord() + maxCarDistance;
            }
            car.setX(newCarX);      // Set the new coordinates for the car
            car.setY(newCarY);
            carStorage.remove(carStorage. size()-1);
        }
    }
    @Override
    public void move() {            //sets car and biltransport to same coords, even while moving
        super.move();
        for (Car car : carStorage){
            car.setX(getxCord());
            car.setY(getyCord());
        }
    }

}