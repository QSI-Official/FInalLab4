import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleController implements IVehicleController{

    private final List<Vehicle> vehicles = new ArrayList<>();

    // spawns a random vehicle
    public void addVehicle() {
        if (vehicles.size() < 10) {
            Random random = new Random();
            int randomNumber = random.nextInt();
            int result = randomNumber % 2;
            if (result == 0)
                vehicles.add(new Saab95());
            else if (result == 1)
                vehicles.add(new Volvo240());
            else
                vehicles.add(new Scania());
        }
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty()) {
            vehicles.removeLast();
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles){
            vehicle.brake((brake));
        }
    }
    public void turboOn(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("turboOn");
            }
        }
    }

    public void turboOff(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void scaniaLift(){
        for(Vehicle vehicle: vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).raisePlatform(70);
            }
        }
    }
    public void scaniaLower(){
        for(Vehicle vehicle: vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).lowerPlatform(70);
            }
        }
    }
    public void startCars(){
        for (Vehicle vehicle: vehicles){
            vehicle.startEngine();
        }
    }

    public void stopCars(){
        for (Vehicle vehicle: vehicles){
            vehicle.stopEngine();
        }
    }

}

