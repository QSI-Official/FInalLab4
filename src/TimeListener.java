import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeListener implements ActionListener {
    private final VehicleController vehicleController;
    private final VehicleView frame;
    public TimeListener(VehicleController vehicleController, VehicleView frame){
        this.vehicleController = vehicleController;
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicleController.getVehicles()) {
            vehicle.boundariesCheck(vehicle);
            vehicle.move();
            int x = (int) Math.round(vehicle.getxCord());
            int y = (int) Math.round(vehicle.getyCord());
            frame.drawPanel.moveit(x, y, vehicle);
            frame.drawPanel.repaint();
        }
    }
}




