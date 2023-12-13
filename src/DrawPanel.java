
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {
    List<Vehicle> vehicle;

    void moveit(int x, int y, Vehicle vehicle) {
        vehicle.setxPoint(x);
        vehicle.setyPoint(y);
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    public void getCars(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public BufferedImage readVehicleImage(Vehicle vehicle1) throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle1.getModelName() + ".jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle1 : vehicle) {
            try {
                g.drawImage(readVehicleImage(vehicle1), vehicle1.getxPoint(), vehicle1.getyPoint(), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}