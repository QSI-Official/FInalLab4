
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {
    List<Vehicle> vehicleList;

    void moveit(int x, int y, Vehicle vehicle) {
        vehicle.setxPoint(x);
        vehicle.setyPoint(y);
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public BufferedImage readVehicleImage(Vehicle vehicle) throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : vehicleList) {
            try {
                g.drawImage(readVehicleImage(vehicle), vehicle.getxPoint(), vehicle.getyPoint(), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}