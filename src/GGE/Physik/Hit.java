package GGE.Physik;

import GGE.Core.GameElement;
import GGE.Math.Rectangle;
import GGE.Math.Vector2;

import java.util.Vector;

/**
 * Created by Andreas on 15.08.14.
 */
public abstract class Hit {
    private Vector2 Start;
    private int Width;
    private HitDirections HitDirection;

    protected Hit(Vector2 start, int width, HitDirections hitDirection) {
        Start = start;
        Width = width;
        HitDirection = hitDirection;
    }

    public Vector2 getStart() {
        return Start;
    }

    public void setStart(Vector2 start) {
        Start = start;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public HitDirections getHitDirection() {
        return HitDirection;
    }

    public void setHitDirection(HitDirections hitDirection) {
        HitDirection = hitDirection;
    }

    public abstract HitResult startHit(Vector<GameElement> HitElements);

}
