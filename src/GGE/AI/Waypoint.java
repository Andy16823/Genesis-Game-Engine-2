package GGE.AI;

import GGE.Math.Size2;
import GGE.Math.Vector2;

import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 16.08.14.
 */
public class Waypoint {
    private Vector2 Location;
    private Size2 Size;

    public Waypoint(Vector2 location, Size2 size) {
        Location = location;
        Size = size;
    }

    public Waypoint() {
    }

    public Size2 getSize() {
        return Size;
    }

    public void setSize(Size2 size) {
        Size = size;
    }

    public Vector2 getLocation() {
        return Location;
    }

    public void setLocation(Vector2 location) {
        Location = location;
    }

}
