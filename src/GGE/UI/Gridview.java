package GGE.UI;

import GGE.Math.Size2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Andreas on 31.08.14.
 */
public class Gridview extends Control {
    private Vector<Item> Items;
    private Size2 CellSize;
    private Color CellColor;
    private Color CellBorderColor;
    private Color BorderColor;
    private Color SelectedCellColor;
    private Color SelectedCellBorderColor;
    private int SelectedCellIndex;
    private int Cells;
    private int RowCells;
    private int Rows;
    private Vector<Rectangle> Matrix;

    public Gridview()
    {
        this.Items = new Vector<Item>();
        this.Matrix = new Vector<Rectangle>();
        this.CellSize = new Size2(24,24);
        this.RowCells = 8;
        this.Rows = 2;
        this.Cells = 14;
        this.setBackgroundColor(new Color(0,0,0,160));
        this.BorderColor = Color.BLACK;
        this.CellColor = new Color(0,0,0,160);
        this.CellBorderColor = Color.BLACK;
        this.SelectedCellColor = new Color(Color.WHITE.getRed(), Color.WHITE.getGreen(), Color.WHITE.getBlue(),160);
        this.SelectedCellBorderColor = Color.WHITE;
        this.setSize(new Size2(RowCells * CellSize.getWidth(), Rows * CellSize.getHeight()));
        this.buildMatrix();
    }

    public void buildMatrix()
    {
        this.getSize().setWidth(this.RowCells * this.CellSize.getWidth());
        this.getSize().setHeight(this.Rows * this.CellSize.getHeight());
        this.Matrix.clear();
        int row = 0;
        int z = 0;

        for(int i = 0; i < Cells; i++)
        {
            this.Matrix.add(new Rectangle(z * CellSize.getWidth(), row * CellSize.getHeight(), CellSize.getWidth(), CellSize.getHeight()));
            z++;
            if(z == RowCells)
            {
                row++;
                z = 0;
            }
        }
    }


    @Override
    public void renderControl(Graphics2D g) {
        BufferedImage control = new BufferedImage(this.getSize().getWidth(), this.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) control.getGraphics();

        // Background
        if(this.getBackgroundColor() != null)
        {
            g2d.setColor(this.getBackgroundColor());
            g2d.fillRect(0,0,this.getSize().getWidth(), this.getSize().getHeight());
        }

        // Border
        if(this.BorderColor != null)
        {
            g2d.setColor(this.BorderColor);
            g2d.drawRect(0,0,this.getSize().getWidth() -1, this.getSize().getHeight() -1);
        }

        // Cells
        for(int i = 0; i < this.Matrix.size(); i++)
        {
            Rectangle rect = this.Matrix.get(i);

            // Cellback
            if(this.CellColor != null)
            {
                g2d.setColor(this.CellColor);
                g2d.fillRect(rect.x, rect.y, rect.width,rect.height);
            }

            if(i < this.Items.size())
            {
                Item item = this.Items.get(i);
                if(item.getImage() != null)
                {
                    g2d.drawImage(item.getImage(), rect.x, rect.y, rect.width, rect.height, null);
                }
            }

            if(i == this.SelectedCellIndex && this.SelectedCellColor != null)
            {
                g2d.setColor(this.SelectedCellColor);
                g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
            }

            if(this.CellBorderColor != null && i != this.SelectedCellIndex)
            {
                g2d.setColor(this.CellBorderColor);
                g2d.drawRect(rect.x,rect.y,rect.width -1,rect.height -1);
            }
            else if(this.SelectedCellBorderColor != null && i == this.SelectedCellIndex)
            {
                g2d.setColor(this.SelectedCellBorderColor);
                g2d.drawRect(rect.x, rect.y, rect.width -1, rect.height -1);
            }
        }

        g.drawImage(control, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getWidth(), this.getSize().getHeight(), null);

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
            if(this.Matrix.get(i).contains(X,Y))
            {
                this.SelectedCellIndex = i;
                break;
            }
        }

        if(this.getMouseListener() != null)
        {
            this.getMouseListener().MouseClick(this);
        }
    }

    public void addItem(Item item)
    {
        this.Items.add(item);
    }

    public Vector<Item> getItems() {
        return Items;
    }

    public void setItems(Vector<Item> items) {
        Items = items;
    }

    public Size2 getCellSize() {
        return CellSize;
    }

    public void setCellSize(Size2 cellSize) {
        CellSize = cellSize;
        this.buildMatrix();
    }

    public Color getCellColor() {
        return CellColor;
    }

    public void setCellColor(Color cellColor) {
        CellColor = cellColor;
    }

    public Color getCellBorderColor() {
        return CellBorderColor;
    }

    public void setCellBorderColor(Color cellBorderColor) {
        CellBorderColor = cellBorderColor;
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }

    public Color getSelectedCellColor() {
        return SelectedCellColor;
    }

    public void setSelectedCellColor(Color selectedCellColor) {
        SelectedCellColor = selectedCellColor;
    }

    public Color getSelectedCellBorderColor() {
        return SelectedCellBorderColor;
    }

    public void setSelectedCellBorderColor(Color selectedCellBorderColor) {
        SelectedCellBorderColor = selectedCellBorderColor;
    }

    public int getSelectedCellIndex() {
        return SelectedCellIndex;
    }

    public void setSelectedCellIndex(int selectedCellIndex) {
        SelectedCellIndex = selectedCellIndex;
    }

    public int getCells() {
        return Cells;
    }

    public void setCells(int cells) {
        Cells = cells;
        this.buildMatrix();
    }

    public int getRowCells() {
        return RowCells;
    }

    public void setRowCells(int rowCells) {
        RowCells = rowCells;
        this.buildMatrix();
    }

    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        Rows = rows;
        this.buildMatrix();
    }
}
