import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        final int delay = 1;
        VehicleController vehC = new VehicleController();
        VehicleView frame = new VehicleView("CarSim 1.0", vehC);
        Timer timer = new Timer(delay, new TimeListener(vehC, frame));
        vehC.getVehicles().add(new Volvo240());
        vehC.getVehicles().add(new Saab95());
        vehC.getVehicles().add(new Scania());

        timer.start();
    }
}