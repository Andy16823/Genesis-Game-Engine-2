package GGE.UI;

import GGE.Core.GameElement;
import GGE.Math.Size2;
import GGE.Math.Vector2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 14.08.14.
 */
public abstract class Control {
    private String Name;
    private String Tag;
    private String Text;
    private boolean Enable;
    private Color BackgroundColor;
    private Color ForegroundColor;
    private Font Font;
    private Vector2 Location;
    private Size2 Size;
    private BufferedImage BackgroundImage;
    private UIMouseListener MouseListener;

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

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return ForegroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        ForegroundColor = foregroundColor;
    }

    public Font getFont() {
        return Font;
    }

    public void setFont(Font font) {
        Font = font;
    }

    public Vector2 getLocation() {
        return Location;
    }

    public void setLocation(Vector2 location) {
        Location = location;
    }

    public Size2 getSize() {
        return Size;
    }

    public void setSize(Size2 size) {
        Size = size;
    }

    public BufferedImage getBackgroundImage() {
        return BackgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public void setMouseListener(UIMouseListener mouseListener) {
        MouseListener = mouseListener;
    }

    public UIMouseListener getMouseListener() {
        return MouseListener;
    }

    public abstract void renderControl(Graphics2D g2d);

    public abstract void updateControl();

    public abstract void mouseMove(MouseEvent e);

    public abstract void mouseClick(int X, int Y);

}
