package GGE.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 31.08.14.
 */
public class ListviewItem{
    private String Name;
    private String Tag;
    private String Text;
    private String Descryption;
    private BufferedImage ItemImage;

    public ListviewItem(String name, String descryption, BufferedImage itemImage) {
        Name = name;
        Text = name;
        Descryption = descryption;
        ItemImage = itemImage;
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

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getDescryption() {
        return Descryption;
    }

    public void setDescryption(String descryption) {
        Descryption = descryption;
    }

    public BufferedImage getItemImage() {
        return ItemImage;
    }

    public void setItemImage(BufferedImage itemImage) {
        ItemImage = itemImage;
    }
}
