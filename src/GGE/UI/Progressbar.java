package GGE.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 27.08.14.
 */
public class Progressbar extends Control {
    private float Maximum;
    private float Value;
    private Color ProgressColor;
    private Color BorderColor;

    @Override
    public void renderControl(Graphics2D g) {
        float ProgProz = this.Value / this.Maximum * 100;
        float ProgWidth = this.getSize().getWidth() / 100 * ProgProz;

        BufferedImage Control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) Control.getGraphics();

        if(this.ProgressColor != null)
        {
            g2d.setColor(this.ProgressColor);
            g2d.fillRect(0,0,(int) ProgWidth, this.getSize().getHeight());
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

    public float getMaximum() {
        return Maximum;
    }

    public void setMaximum(float maximum) {
        Maximum = maximum;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }

    public Color getProgressColor() {
        return ProgressColor;
    }

    public void setProgressColor(Color progressColor) {
        ProgressColor = progressColor;
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }
}
