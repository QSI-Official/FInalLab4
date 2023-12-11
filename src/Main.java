import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        final int delay = 5;
        VehicleController vehC = new VehicleController();
        VehicleView frame = new VehicleView("CarSim 1.0", vehC);
        Timer timer = new Timer(delay, new TimeListener(vehC, frame));
        vehC.vehicles.add(new Volvo240());
        vehC.vehicles.add(new Saab95());
        vehC.vehicles.add(new Scania());

        // Start the timer
        timer.start();
    }
    //tess
}