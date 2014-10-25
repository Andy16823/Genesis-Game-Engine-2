package GGE.UI;

import GGE.Math.Size2;
import GGE.Math.Vector2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Andreas on 28.08.14.
 */
public class Toolbar  extends Control{
    private Vector<Item> Toolitems;
    private int SelectedIndex;
    private Size2 ItemSize;
    private int DisplayItems;
    private Color BorderColor;
    private Color SelectedColor;
    private Vector<Rectangle> Matrix;

    public Toolbar(Vector2 Location, int DisplayItems,  Size2 ItemSize) {
        this.Toolitems = new Vector<Item>();
        this.Matrix = new Vector<Rectangle>();
        this.setLocation(Location);
        this.ItemSize = ItemSize;
        this.DisplayItems = DisplayItems;
        this.setSize(new Size2(this.ItemSize.getWidth() * this.DisplayItems,this.ItemSize.getHeight()));
        this.calcSize();
    }

    @Override
    public void renderControl(Graphics2D g) {
        BufferedImage Control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) Control.getGraphics();

        if(this.getBackgroundColor() != null)
        {
            g2d.setColor(this.getBackgroundColor());
            g2d.fillRect(0,0,this.getSize().getWidth(), this.getSize().getHeight());
        }

        for(int i = 0; i < this.Matrix.size(); i++)
        {
            Rectangle rect = this.Matrix.get(i);

            if(!this.Toolitems.isEmpty() && i < this.Toolitems.size())
            {
                Item item = this.Toolitems.get(i);
                g2d.drawImage(item.getImage(),rect.x, rect.y, rect.width, rect.height, null);
            }

            if(this.BorderColor != null)
            {
                g2d.setColor(this.BorderColor);
                g2d.drawRect(rect.x, rect.y, rect.width -1, rect.height -1);
            }
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
        for(int i = 0; i < this.Matrix.size(); i++)
        {
            Rectangle rect = this.Matrix.get(i);
            if(rect.contains(X,Y))
            {
                this.SelectedIndex = i;
                break;
            }
        }
        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseClick(this);
        }
    }

    public Vector<Item> getToolitems() {
        return Toolitems;
    }

    public int getSelectedIndex() {
        return SelectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        SelectedIndex = selectedIndex;
    }

    public Size2 getItemSize() {
        return ItemSize;
    }

    public void setItemSize(Size2 itemSize) {
        ItemSize = itemSize;
        this.calcSize();
    }

    public int getDisplayItems() {
        return DisplayItems;
    }

    public void setDisplayItems(int displayItems) {
        DisplayItems = displayItems;
        this.calcSize();
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }

    public Color getSelectedColor() {
        return SelectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        SelectedColor = selectedColor;
    }

    public void addItem(Item item)
    {
        this.Toolitems.add(item);
    }

    private void calcSize()
    {
        this.getSize().setWidth(this.ItemSize.getWidth() * this.DisplayItems);
        this.getSize().setHeight(this.ItemSize.getHeight());
        this.Matrix.clear();

        for(int x = 0; x < this.DisplayItems; x++)
        {
            Rectangle rect = new Rectangle(x * this.getItemSize().getWidth(), 0, this.getItemSize().getWidth(), this.getItemSize().getHeight());
            this.Matrix.add(rect);
        }

    }

}
