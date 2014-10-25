package GGE.Physik;

import GGE.Core.GameElement;
import GGE.Math.*;

import java.awt.*;
import java.awt.Rectangle;
import java.util.Vector;

/**
 * Created by Andreas on 13.08.14.
 */
public class IntersectCollider extends Collider {

    public IntersectCollider(boolean enable, GGE.Math.Rectangle boundBox) {
        super(enable, boundBox);
    }

    @Override
    public GameElement GetCollision(Vector<GameElement> Elements) {

        // define the rectangle from the base element
        Rectangle RectA = new Rectangle(this.getBoundBox().getX(),
                                        this.getBoundBox().getY(),
                                        this.getBoundBox().getWidth(),
                                        this.getBoundBox().getWidth());

        for(GameElement Element : Elements)
        {
            // has the gameelemnt an collider
            if(Element.getCollider().isEnable())
            {
                // then create the reference rect
                Rectangle RectB = new Rectangle(Element.getCollider().getBoundBox().getX(),
                                               Element.getCollider().getBoundBox().getY(),
                                               Element.getCollider().getBoundBox().getWidth(),
                                               Element.getCollider().getBoundBox().getHeight());

                // if the reference rect intersect with the base rect
                if(RectA.intersects(RectB))
                {
                    return Element;
                }
            }
        }
        return null;
    }
}
