import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class VehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    //private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern

    // A list of vehicles, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    /* Each step the TimerListener moves all the vehicles in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    // spawns a random vehicle
    public void addCar() {
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

    public void removeCar() {
        if (!vehicles.isEmpty()) {
            vehicles.removeLast();
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles){
            vehicle.brake((brake));
        }
    }
    void turboOn(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println("turboOn");
            }
        }
    }

    void turboOff(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void scaniaLift(){
        for(Vehicle vehicle: vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).raisePlatform(70);
            }
        }
    }
    void scaniaLower(){
        for(Vehicle vehicle: vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).lowerPlatform(70);
            }
        }
    }
    void startCars(){
        for (Vehicle vehicle: vehicles){
            vehicle.startEngine();
        }
    }

    void stopCars(){
        for (Vehicle vehicle: vehicles){
            vehicle.stopEngine();
        }
    }

}

