import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        int X = 1000;
        int Y = 800;
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Volvo240(0, 0));
        vehicleList.add(new Saab95(100, 0));
        vehicleList.add(new Scania(200, 0));
        final int delay = 1;
        DrawPanel drawPanel = new DrawPanel(X, Y-240);
        drawPanel.setVehicleList(vehicleList);
        VehicleView frame = new VehicleView("CarSim 1.0", drawPanel, X, Y);
        VehicleController vehC = new VehicleController(frame, vehicleList);
        Timer timer = new Timer(delay, new TimeListener(vehC, frame));

        timer.start();
    }
}