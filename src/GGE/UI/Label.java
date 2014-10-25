package GGE.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 14.08.14.
 */
public class Label extends Control {

    public Label()
    {
        this.setEnable(true);
    }

    @Override
    public void renderControl(Graphics2D g) {

        if(this.isEnable())
        {
            // create control bitmap
            BufferedImage Control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) Control.getGraphics();

            // Anti Alias
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

            // Fill the background
            if(this.getBackgroundColor() != null)
            {
                g2d.setColor(this.getBackgroundColor());
                g2d.fillRect(0,0, this.getSize().getWidth(), this.getSize().getHeight());
            }

            // Draw the text
            if(this.getText() != null && this.getForegroundColor() != null)
            {
                g2d.setColor(this.getForegroundColor());
                g2d.setFont(this.getFont());
                g2d.drawString(this.getText(), 0, this.getSize().getHeight() / 2);
            }

            // Draw the Control
            g.drawImage(Control, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getWidth(), this.getSize().getHeight(), null);
        }
    }

    @Override
    public void updateControl() {

    }

    @Override
    public void mouseClick(int X, int Y) {
        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseClick(this);
        }
    }

    @Override
    public void mouseMove(MouseEvent e) {
        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseMove(this, e);
        }
    }
}
