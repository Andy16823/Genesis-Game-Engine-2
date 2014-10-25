package GGE.Physik;

import GGE.Core.GameElement;
import GGE.Math.Vector2;

import java.util.Vector;

/**
 * Created by Andreas on 17.08.14.
 */
public class ColliderLineHit extends Hit {

    public ColliderLineHit(Vector2 start, int width, HitDirections hitDirection) {
        super(start, width, hitDirection);
    }

    @Override
    public HitResult startHit(Vector<GameElement> HitElements) {
        int EndX;
        int EndY;

        if(this.getHitDirection() == HitDirections.North)
        {
            EndX = this.getStart().getX();
            EndY = this.getStart().getY() - this.getWidth();

            for(GameElement element : HitElements)
            {
                for(int i = this.getStart().getY(); i > EndY; i--)
                {
                    if(element.getCollider().getBoundBox().contains(this.getStart().getX(), i))
                    {
                        return new HitResult(true, element);
                    }
                }
            }
        }
        else if(this.getHitDirection() == HitDirections.South)
        {
            EndX = this.getStart().getX();
            EndY = this.getStart().getY() + this.getWidth();

            for(GameElement element : HitElements)
            {
                for(int i = this.getStart().getY(); i < EndY; i++)
                {
                    if(element.getCollider().getBoundBox().contains(this.getStart().getX(), i))
                    {
                        return new HitResult(true, element);
                    }
                }
            }
        }
        else if(this.getHitDirection() == HitDirections.East)
        {
            EndX = this.getStart().getX() - this.getWidth();
            EndY = this.getStart().getY();

            for(GameElement element : HitElements)
            {
                for(int i = this.getStart().getX(); i > EndX; i--)
                {
                    if(element.getCollider().getBoundBox().contains(i, this.getStart().getY()))
                    {
                        return new HitResult(true, element);
                    }
                }
            }
        }
        else if(this.getHitDirection() == HitDirections.West)
        {
            EndX = this.getStart().getX() + this.getWidth();
            EndY = this.getStart().getY();

            for(GameElement element : HitElements)
            {
                for(int i = this.getStart().getX(); i < EndX; i++)
                {
                    if(element.getCollider().getBoundBox().contains(i, this.getStart().getY()))
                    {
                        return new HitResult(true, element);
                    }
                }
            }
        }

        return new HitResult(false, null);
    }

}
