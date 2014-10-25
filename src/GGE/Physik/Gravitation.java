package GGE.Physik;

/**
 * Created by Andreas on 13.08.14.
 */
public class Gravitation {
    private int xValue;
    private int yValue;
    private boolean xEnable;
    private boolean yEnable;

    public Gravitation(int xValue, int yValue) {
        this.xValue = xValue;
        this.xEnable = true;
        this.yValue = yValue;
        this.yEnable = true;
    }

    public Gravitation(int xValue, int yValue, boolean xEnable, boolean yEnable) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.xEnable = xEnable;
        this.yEnable = yEnable;
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public boolean isxEnable() {
        return xEnable;
    }

    public void setxEnable(boolean xEnable) {
        this.xEnable = xEnable;
    }

    public boolean isyEnable() {
        return yEnable;
    }

    public void setyEnable(boolean yEnable) {
        this.yEnable = yEnable;
    }
}
