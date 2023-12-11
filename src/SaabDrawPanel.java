import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SaabDrawPanel{

    public BufferedImage readVehicleImage() throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
    }
}
