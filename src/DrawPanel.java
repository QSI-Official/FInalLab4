import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

public class DrawPanel extends JPanel{
    IVehicleController IvehC;

    void moveit(int x, int y, Vehicle vehicle){
        vehicle.setxPoint(x);
        vehicle.setyPoint(y);
    }

    public DrawPanel(int x, int y, IVehicleController IvehC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.IvehC = IvehC;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int extra = 0;
        for (Vehicle vehicle : IvehC.getVehicles()) {
            try {
                if (vehicle.getModelName() == "Volvo240") {
                    volvoDrawPanel volvo = new volvoDrawPanel();
                    g.drawImage(volvo.readVehicleImage(), vehicle.getxPoint() + extra, vehicle.getyPoint(), null);
                } else if (vehicle.getModelName() == "Saab95") {
                    SaabDrawPanel saab = new SaabDrawPanel();
                    g.drawImage(saab.readVehicleImage(), vehicle.getxPoint() + extra, vehicle.getyPoint(), null);
                } else if (vehicle.getModelName() == "Scania") {
                    scaniaDrawPanel scania = new scaniaDrawPanel();
                    g.drawImage(scania.readVehicleImage(), vehicle.getxPoint() + extra, vehicle.getyPoint(), null);
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
            extra += 100;
        }
    }
}
