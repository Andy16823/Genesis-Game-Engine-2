package GGE.UI;

import GGE.Math.Size2;
import GGE.Math.Vector2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Andreas on 14.08.14.
 */
public class UIContent {
    private String Name;
    private String Tag;
    private boolean Enable;
    private Vector<Control> Controls;
    private Vector2 Location;
    private Size2 Size;
    private Color BackgroundColor;
    private BufferedImage BackgroundImage;

    public UIContent(String name) {
        Name = name;
        Controls = new Vector<Control>();
        Enable = true;
    }

    public UIContent(String name, Vector2 location, Size2 size) {
        Name = name;
        Location = location;
        Size = size;
        Controls = new Vector<Control>();
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

    public Vector<Control> getControls() {
        return Controls;
    }

    public void setControls(Vector<Control> controls) {
        Controls = controls;
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

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public BufferedImage getBackgroundImage() {
        return BackgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public void addControl(Control control)
    {
        Controls.add(control);
    }

    public void renderContent(Graphics2D g)
    {
        if(this.Enable)
        {
            BufferedImage Content = new BufferedImage(Size.getWidth(), Size.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) Content.getGraphics();

            // Draw Background
            if(this.BackgroundColor != null)
            {
                g2d.setBackground(this.BackgroundColor);
                g2d.fillRect(0,0, Size.getWidth(), Size.getHeight());
            }

            // Daraw background image
            if(this.BackgroundImage != null)
            {
                g2d.drawImage(BackgroundImage, 0,0,Size.getWidth(), Size.getHeight(), null);
            }

            // Render content controls
            this.renderControls(g2d);

            // draw content
            g.drawImage(Content, Location.getX(), Location.getY(), Size.getWidth(), Size.getHeight(), null);
        }
    }

    public void renderControls(Graphics2D g2d)
    {
        for(Control control : Controls)
        {
            control.renderControl(g2d);
        }
    }

    public void updateContent()
    {
        for(Control control : Controls)
        {
            control.updateControl();
        }
    }

    public void contentMouseMove(MouseEvent e)
    {
        if(Enable)
        {
            if(e.getX() > Location.getX() && e.getY() > Location.getY() && e.getX() < Location.getX() + Size.getWidth() && e.getY() < Location.getY() + Size.getHeight())
            {
                for(Control control : Controls)
                {
                    int ControlX = Location.getX() + control.getLocation().getX();
                    int ControlY = Location.getY() + control.getLocation().getY();
                    if(e.getX() > ControlX && e.getY() > ControlY && e.getX() < ControlX + control.getSize().getWidth() && e.getY() < ControlY + control.getSize().getHeight())
                    {
                        if(control.isEnable())
                        {
                            control.mouseMove(e);
                        }
                    }
                }
            }
        }
    }

    public void contentMouseDown(MouseEvent e)
    {
        if(Enable)
        {
            if(e.getX() > Location.getX() && e.getY() > Location.getY() && e.getX() < Location.getX() + Size.getWidth() && e.getY() < Location.getY() + Size.getHeight())
            {
                for(Control control : Controls)
                {
                   int ControlX = Location.getX() + control.getLocation().getX();
                   int ControlY = Location.getY() + control.getLocation().getY();

                    if(e.getX() > ControlX && e.getY() > ControlY && e.getX() < ControlX + control.getSize().getWidth() && e.getY() < ControlY + control.getSize().getHeight())
                    {
                       if(control.isEnable())
                       {
                           control.mouseClick(e.getX() - ControlX, e.getY() - ControlY);
                       }
                    }
                }
            }
        }
    }

}
