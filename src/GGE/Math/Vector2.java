package GGE.Math;

/**
 * Created by Andreas on 13.08.14.
 */
public class Vector2 {
    private int X;
    private int Y;

    public Vector2() {
    }

    public Vector2(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
    
    public void addX(int Value)
    {
        X += Value;
    }
    
    public void addY(int Value)
    {
        Y += Value;
    }
}
