import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaniaDrawPanel {
    public BufferedImage readVehicleImage() throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
    }
}
