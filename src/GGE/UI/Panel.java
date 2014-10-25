package GGE.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 28.08.14.
 */
public class Panel extends Control{
    private Color BorderColor;

    @Override
    public void renderControl(Graphics2D g) {

        BufferedImage Control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) Control.getGraphics();

        if(this.getBackgroundColor() != null)
        {
            g2d.setColor(this.getBackgroundColor());
            g2d.fillRect(0,0,this.getSize().getWidth(), this.getSize().getHeight());
        }

        if(this.getBackgroundImage() != null)
        {
            g2d.drawImage(this.getBackgroundImage(), 0,0,this.getSize().getWidth(), this.getSize().getHeight(), null);
        }

        if(this.BorderColor != null)
        {
            g2d.setColor(this.BorderColor);
            g2d.drawRect(0,0,this.getSize().getWidth() -1, this.getSize().getHeight() -1);
        }

        g.drawImage(Control, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getWidth(), this.getSize().getHeight(), null);
    }

    @Override
    public void updateControl() {

    }

    @Override
    public void mouseMove(MouseEvent e) {
        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseMove(this, e);
        }
    }

    @Override
    public void mouseClick(int X, int Y) {
        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseClick(this);
        }
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }
}
