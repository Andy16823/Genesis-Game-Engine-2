/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GGE.Physik;

import GGE.Core.GameElement;
import java.util.Vector;

/**
 *
 * @author Andreas
 */
public class PointHit {
    
    public HitResult hit(int StartX, int StartY, int EndX, int EndY, Vector<GameElement> Elements)
    {
        HitResult Result = new HitResult();
        Result.setHit(false);
        Result.setHitElement(null);
        
        while(StartX != EndX || StartY != EndY)
        {
            if(StartX > EndX)
            {
                StartX--;
            }
            else if(StartX < EndX)
            {
                StartX++;
            }
            
            if(StartY > EndY)
            {
                StartY--;
            }
            else if(StartY < EndY)
            {
                StartY++;
            }
            
            for(GameElement element : Elements)
            {
                if(element.getBounds().contains(StartX, StartY))
                {
                    Result.setHit(true);
                    Result.setHitElement(element);
                    return Result;
                }
            }
        } 
        return Result;
    }
    
}
