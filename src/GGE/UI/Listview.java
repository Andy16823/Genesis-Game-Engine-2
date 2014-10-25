package GGE.UI;

import GGE.Math.Size2;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Andreas on 31.08.14.
 */
public class Listview extends Control {
    private Vector<ListviewItem> Items;
    private Color BorderColor;
    private Color ScrollBarColor;
    private Color ScrollIconColor;
    private Color ScrollBarBorderColor;
    private Color ItemBackgroundColor;
    private Color ItemBorderColor;
    private int ScrollYValue;
    private int SelectedItemIndex;
    private ListviewItemListener ItemListener;
    private ListviewItem SelectedItem;

    public Listview()
    {
        this.Items = new Vector<ListviewItem>();
        this.BorderColor = Color.WHITE;
        this.setBackgroundColor(new Color(0, 0, 0, 160));
        this.ScrollBarColor = new Color(0, 0, 0, 160);
        this.ScrollIconColor = Color.WHITE;
        this.ItemBackgroundColor = new Color(0,0,0, 160);
        this.ItemBorderColor = new Color(0,0,0);
        this.setFont(new Font("Arial", java.awt.Font.PLAIN, 12));
        this.setForegroundColor(Color.WHITE);
    }

    @Override
    public void renderControl(Graphics2D g) {

        BufferedImage control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        BufferedImage itemsImage = new BufferedImage(this.getSize().getWidth() -10, 64 * this.Items.size(), BufferedImage.TYPE_INT_ARGB);
        this.drawItems(itemsImage.createGraphics());
        Graphics2D g2d = (Graphics2D) control.getGraphics();

        // Background
        if(this.getBackgroundColor() != null)
        {
            g2d.setColor(this.getBackgroundColor());
            g2d.fillRect(0,0,this.getSize().getWidth(),this.getSize().getHeight());
        }

        // Border
        if(this.BorderColor != null)
        {
            g2d.setColor(this.BorderColor);
            g2d.drawRect(0,0,this.getSize().getWidth() -1,this.getSize().getHeight() -1);
        }

        // Scrollbar
        g2d.setColor(this.ScrollBarColor);
        g2d.fillRect(this.getSize().getWidth() - 10,0,10,this.getSize().getHeight());
        g2d.drawRect(this.getSize().getWidth() - 10,0, 9, this.getSize().getHeight() -1);

        // Scrollbutton Top
        Rectangle RectTop = new Rectangle(this.getSize().getWidth() - 10, 0, 10, 10);
        int ptX[] = {RectTop.x + 2, RectTop.x + 8, RectTop.x + 8};
        int ptY[] = {RectTop.y + 2, RectTop.y + 2, RectTop.y + 8};
        g2d.setColor(this.ScrollIconColor);
        g2d.fillPolygon(ptX, ptY, 3);

        // Scrollbutton bottom
        Rectangle RectBottom = new Rectangle(this.getSize().getWidth() - 10, this.getSize().getHeight() - 10, 10, 10);
        int pbX[] = {RectBottom.x + 2, RectBottom.x + 8, RectBottom.x + 8};
        int pbY[] = {RectBottom.y + 8, RectBottom.y + 8, RectBottom.y + 2};
        g2d.setColor(this.ScrollIconColor);
        g2d.fillPolygon(pbX, pbY, 3);

        // Items
        g2d.drawImage(itemsImage, 0, -this.ScrollYValue, this.getSize().getWidth() -10, 64 * this.Items.size(), null);


        g.drawImage(control, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getWidth(), this.getSize().getHeight(), null);
    }

    private void drawItems(Graphics2D g)
    {
        for(int i = 0; i < Items.size(); i++)
        {
            ListviewItem item = this.Items.get(i);
            BufferedImage itemImage = new BufferedImage(this.getSize().getWidth() -10, 64, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) itemImage.getGraphics();

            // Background
            if(this.ItemBackgroundColor != null)
            {
                g2d.setColor(this.ItemBackgroundColor);
                g2d.fillRect(0,0, this.getSize().getWidth() -10, 64);
            }

            // Border
            if (this.ItemBorderColor != null)
            {
                g2d.setColor(this.ItemBorderColor);
                g2d.drawRect(0,0,this.getSize().getWidth() -11 ,63);
            }

            // Item Image
            if(item.getItemImage() != null)
            {
                g2d.drawImage(item.getItemImage(), 2, 2, 60, 60, null);
            }
            if(this.getForegroundColor() != null && this.getFont() != null)
            {
                // Item Text
                if(item.getText() != null)
                {
                    g2d.setColor(this.getForegroundColor());
                    g2d.setFont(new Font(this.getFont().getFontName(), java.awt.Font.BOLD, this.getFont().getSize()));
                    g2d.drawString(item.getText(), 64, 15);
                }

                // Item Description
                if(item.getDescryption() != null)
                {
                    g2d.setColor(this.getForegroundColor());
                    g2d.setFont(this.getFont());
                    g2d.drawString(item.getDescryption(), 64, 30);
                }
            }

            g.drawImage(itemImage, 0, i * 64, this.getSize().getWidth() -10, 64, null);
        }
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
        Rectangle TopRect = new Rectangle(this.getSize().getWidth() -10, 0, 10, 10);
        Rectangle BottomRect = new Rectangle(this.getSize().getWidth() -10, this.getSize().getHeight() - 10, 10, 10);
        if(TopRect.contains(X,Y) && this.ScrollYValue > 0)
        {
            this.ScrollYValue -=5;
        }
        else if(BottomRect.contains(X,Y))
        {
            this.ScrollYValue += 5;
        }

        // Selecttion
        Rectangle SelectedRect;
        for(int i = 0; i < this.Items.size(); i++)
        {
            SelectedRect = new Rectangle(0, (i * 64) - this.ScrollYValue, this.getSize().getWidth() - 10, 64);
            if(SelectedRect.contains(X,Y))
            {
                this.SelectedItemIndex = i;
                this.SelectedItem = this.Items.get(i);
                if(this.ItemListener != null)
                {
                    this.ItemListener.selectedItemChange(this, this.SelectedItem);
                }
                break;
            }
        }

        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseClick(this);
        }
    }

    public void addItem(ListviewItem item)
    {
        this.Items.add(item);
    }

    public Vector<ListviewItem> getItems() {
        return Items;
    }

    public void setItems(Vector<ListviewItem> items) {
        Items = items;
    }

    public Color getItemBackgroundColor() {
        return ItemBackgroundColor;
    }

    public void setItemBackgroundColor(Color itemBackgroundColor) {
        ItemBackgroundColor = itemBackgroundColor;
    }

    public Color getItemBorderColor() {
        return ItemBorderColor;
    }

    public void setItemBorderColor(Color itemBorderColor) {
        ItemBorderColor = itemBorderColor;
    }

    public int getScrollYValue() {
        return ScrollYValue;
    }

    public void setScrollYValue(int scrollYValue) {
        ScrollYValue = scrollYValue;
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }

    public Color getScrollBarColor() {
        return ScrollBarColor;
    }

    public void setScrollBarColor(Color scrollBarColor) {
        ScrollBarColor = scrollBarColor;
    }

    public Color getScrollIconColor() {
        return ScrollIconColor;
    }

    public void setScrollIconColor(Color scrollIconColor) {
        ScrollIconColor = scrollIconColor;
    }

    public Color getScrollBarBorderColor() {
        return ScrollBarBorderColor;
    }

    public void setScrollBarBorderColor(Color scrollBarBorderColor) {
        ScrollBarBorderColor = scrollBarBorderColor;
    }

    public int getSelectedItemIndex() {
        return SelectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItem) {
        SelectedItemIndex = selectedItem;
        this.SelectedItem = this.Items.get(this.SelectedItemIndex);
    }

    public ListviewItemListener getItemListener() {
        return ItemListener;
    }

    public void setItemListener(ListviewItemListener itemListener) {
        ItemListener = itemListener;
    }

    public ListviewItem getSelectedItem() {
        return SelectedItem;
    }

    public void setSelectedItem(ListviewItem selectedItem) {
        SelectedItem = selectedItem;
    }
}
