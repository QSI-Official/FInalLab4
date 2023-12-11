import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
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

        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage=ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int extra = 0;
        for (Vehicle vehicle : IvehC.getVehicles()) {
            if(vehicle.getModelName() == "Volvo240"){
                g.drawImage(volvoImage, vehicle.getxPoint() + extra,  vehicle.getyPoint(), null);
            }else if (vehicle.getModelName() == "Saab95"){
                g.drawImage(saabImage, vehicle.getxPoint() + extra,   vehicle.getyPoint(), null);
            }else if (vehicle.getModelName() == "Scania"){
                g.drawImage(scaniaImage, vehicle.getxPoint() + extra, vehicle.getyPoint(), null);
            }
            extra += 100;
        }
    }
}
