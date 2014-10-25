package GGE.Assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Andreas on 14.08.14.
 */
public class Asset {
    private String Name;
    private URL Path;
    private BufferedImage Image;

    public Asset(String name, URL path) {
        Name = name;
        Path = path;
        try {
            Image = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public URL getPath() {
        return Path;
    }

    public void setPath(URL path) {
        Path = path;
    }

    public BufferedImage getImage() {
        return Image;
    }

    public void setImage(BufferedImage image) {
        Image = image;
    }
}
