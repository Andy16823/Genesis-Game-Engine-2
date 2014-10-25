package GGE.UI;

import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 28.08.14.
 */
public class Item {
    private String Name;
    private String Tag;
    private boolean Enable;
    private BufferedImage Image;

    public Item(String name) {
        Name = name;
        Enable = true;
    }

    public Item(String name, BufferedImage image) {
        Name = name;
        Image = image;
        Enable = true;
    }

    public Item(String name, String tag, BufferedImage image) {
        Name = name;
        Tag = tag;
        Image = image;
        Enable = true;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public BufferedImage getImage() {
        return Image;
    }

    public void setImage(BufferedImage image) {
        Image = image;
    }
}
