/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GGE.AI;

import GGE.Math.Vector2;

/**
 *
 * @author Andreas
 */
public class WalkAt {
    private Vector2 TargetLocation;
    
    public WalkAt(Vector2 TargetLocation)
    {
        this.TargetLocation = TargetLocation;
    }
    
    public void performStepp(int Stepps, Vector2 Position)
    {
        for(int i = 0; i < Stepps; i++)
        {
            if(Position.getX() > this.TargetLocation.getX())
            {
                Position.addX(- 1);
            }
            else if(Position.getX() < this.TargetLocation.getX())
            {
                Position.addX(+ 1);
            }
            
            if(Position.getY() > this.TargetLocation.getY())
            {
                Position.addY(- 1);
            }
            else if (Position.getY() < this.TargetLocation.getY())
            {
                Position.addY(+ 1);
            }
        }   
    }

    public Vector2 getTargetLocation() {
        return TargetLocation;
    }

    public void setTargetLocation(Vector2 TargetLocation) {
        this.TargetLocation = TargetLocation;
    }
    
}
