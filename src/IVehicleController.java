import java.util.List;

public interface IVehicleController {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void scaniaLift();
    void scaniaLower();
    void startCars();
    void stopCars();
    void addVehicle();
    void removeVehicle();
    List<Vehicle> getVehicles();
}
