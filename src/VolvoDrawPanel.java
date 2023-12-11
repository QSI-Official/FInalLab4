import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VolvoDrawPanel {
    public BufferedImage readVehicleImage() throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
    }
}