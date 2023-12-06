import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimeListener implements ActionListener {
    private final VehicleController vehicleController;
    VehicleView frame;
    public TimeListener(VehicleController vehicleController, VehicleView frame){
        this.vehicleController = vehicleController;
        this.frame = frame;
    }

    /* Each step the TimerListener moves all the vehicles in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < vehicleController.getVehicles().size(); i++) {
            Vehicle vehicle = vehicleController.getVehicles().get(i);
            boundariesCheck(vehicle);
            vehicle.move();
            int x = (int) Math.round(vehicle.getxCord());
            int y = (int) Math.round(vehicle.getyCord());
            frame.drawPanel.moveit(x, y, vehicle);
        }
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }

    private void boundariesCheck(Vehicle vehicle) {
        if (vehicle.getyCord() > 500) {
            vehicle180(vehicle);
            vehicle.setY(500);
        } else if (vehicle.getyCord() < 0) {
            vehicle180(vehicle);
            vehicle.setY(0);
        }
    }

    void vehicle180(Vehicle vehicle){
        vehicle.stopEngine();
        vehicle.turnRight();
        vehicle.turnRight();
        vehicle.startEngine();
    }
}




