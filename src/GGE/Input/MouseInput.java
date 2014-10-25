package GGE.Input;

/**
 * Created by Andreas on 24.08.14.
 */
public class MouseInput {
    private int LocationX;
    private int LocationY;
    private int Button;

    public MouseInput(int locationX, int locationY, int button) {
        LocationX = locationX;
        LocationY = locationY;
        Button = button;
    }

    public MouseInput() {
    }

    public int getLocationX() {
        return LocationX;
    }

    public void setLocationX(int locationX) {
        LocationX = locationX;
    }

    public int getLocationY() {
        return LocationY;
    }

    public void setLocationY(int locationY) {
        LocationY = locationY;
    }

    public int getButton() {
        return Button;
    }

    public void setButton(int button) {
        Button = button;
    }

    public void releaseButton()
    {
        this.Button = 0;
    }

}
