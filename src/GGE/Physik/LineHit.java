package GGE.Physik;

import GGE.Core.GameElement;
import GGE.Math.Vector2;

import java.util.Vector;

/**
 * Created by Andreas on 15.08.14.
 */
public class LineHit extends Hit {

    public LineHit(Vector2 start, int width, HitDirections hitDirection) {
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

            for(GameElement Element : HitElements)
            {
                for(int i = getStart().getY(); i > EndY; i--)
                {
                    if(Element.getBounds().contains(this.getStart().getX(), i))
                    {
                        return new HitResult(true, Element);
                    }
                }
            }

        }
        else if(this.getHitDirection() == HitDirections.South)
        {
            EndX = this.getStart().getX();
            EndY = this.getStart().getY() + this.getWidth();

            for(GameElement Element : HitElements)
            {
                for(int i = this.getStart().getY(); i < EndY; i++)
                {
                    if(Element.getBounds().contains(this.getStart().getX(), i))
                    {
                        return new HitResult(true, Element);
                    }
                }
            }

        }
        else if(this.getHitDirection() == HitDirections.East)
        {
            EndX = this.getStart().getX() - this.getWidth();
            EndY = this.getStart().getY();

            for(GameElement Element : HitElements)
            {
                for(int i = this.getStart().getX(); i > EndX; i--)
                {
                    if(Element.getBounds().contains(i, this.getStart().getY()))
                    {
                        return new HitResult(true, Element);
                    }
                }
            }

        }
        else if(this.getHitDirection() == HitDirections.West)
        {
            EndX = this.getStart().getX() + this.getWidth();
            EndY = this.getStart().getY();

            for(GameElement Element : HitElements)
            {
                for(int i = this.getStart().getX(); i < EndX; i++)
                {
                    if(Element.getBounds().contains(i, this.getStart().getY()))
                    {
                        return new HitResult(true, Element);
                    }
                }
            }

        }

        return new HitResult(false, null);
    }

}
