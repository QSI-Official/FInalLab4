import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class BilTransport extends Truck{
    private final List<Car> carStorage = new ArrayList<>();

    private static final int maxCarDistance = 5;
    private static final int platformFullRaiseAndLowerAngle = 70;

    //Constructor
    public BilTransport(double initX, double initY){
        super(2, 50, Color.white, "Mercedes", initX, initY);
    }

    public double calculateDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }
    public boolean isDistanceOK(Car car){
        double distanceMax = 5.0;
        double distance = calculateDistance(car.getxCord(), car.getyCord(), getxCord(), getyCord());
        return distance <= distanceMax;              // true if car if a maximum of 5 l.u away or less
    }
    public void loadCar(Car car){
        int maxLoad = 5;
        if (isDistanceOK(car) & isPlatformDown() & (getCarStorageSize()< maxLoad) & (!carStorage.contains(car))){
            carStorage.add(car);
        }
    }
    public void unLoadCar(Car car) {
        double newCarX, newCarY;
        car.setCurrentDir(getCurrentDir());
        if (carStorage.contains(car) & isPlatformDown() & (carStorage.indexOf(car) == getCarStorageSize()-1)) {
            if (getCurrentDir() == direction.N || getCurrentDir() == direction.E) {
                newCarX = getxCord() - maxCarDistance;
                newCarY = getyCord() - maxCarDistance;
            } else {
                newCarX = getxCord() + maxCarDistance;
                newCarY = getyCord() + maxCarDistance;
            }
            car.setX(newCarX);
            car.setY(newCarY);
            carStorage.remove(carStorage. size()-1);
        }
    }
    @Override
    public void move() {
        super.move();
        for (Car car : carStorage){
            car.setX(getxCord());
            car.setY(getyCord());
        }
    }

    ////////////////////////////////////////////////////
    //Getters and setters
    public boolean isPlatformDown(){
        return getAngle() == platformFullRaiseAndLowerAngle;
    }
    public void setPlatformDown(boolean platformDown){
        if(platformDown){
            raisePlatform(platformFullRaiseAndLowerAngle);
        }
        else {
            lowerPlatform(platformFullRaiseAndLowerAngle);
        }
    }
    public int getCarStorageSize() {
        return carStorage.size();
    }

}