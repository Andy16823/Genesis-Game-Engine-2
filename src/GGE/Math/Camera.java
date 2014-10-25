package GGE.Math;

/**
 * Created by Andreas on 31.08.14.
 */
public class Camera {
    private String Name;
    private String Tag;
    private boolean Enable;
    private Vector2 Location;

    public Camera(String name, Vector2 location) {
        Name = name;
        Location = location;
        this.Enable = true;
    }

    public Camera() {
        this.Enable = true;
    }

    public Camera(String Name, int X, int Y)
    {
        this.Name = Name;
        this.Location = new Vector2(X, Y);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public Vector2 getLocation() {
        return Location;
    }

    public void setLocation(Vector2 location) {
        Location = location;
    }
}
