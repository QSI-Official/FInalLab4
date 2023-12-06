import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    VehicleController vehC;
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    void moveit(int x, int y, Vehicle vehicle){
        vehicle.setxPoint(x);
        vehicle.setyPoint(y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, VehicleController vehC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehC = vehC;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage=ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int extra = 0;
        for (Vehicle vehicle : vehC.vehicles) {
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
