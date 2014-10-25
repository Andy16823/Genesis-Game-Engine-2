package GGE.Physik;

import GGE.Core.GameElement;
import GGE.Math.Rectangle;

import java.util.Vector;

/**
 * Created by Andreas on 13.08.14.
 */
public abstract class Collider {
    private boolean Enable;
    private Rectangle BoundBox;

    public Collider() {
    }

    public Collider(boolean enable, Rectangle boundBox) {
        Enable = enable;
        BoundBox = boundBox;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public Rectangle getBoundBox() {
        return BoundBox;
    }

    public void setBoundBox(Rectangle boundBox) {
        BoundBox = boundBox;
    }

    public abstract GameElement GetCollision(Vector<GameElement> Elements);



}
