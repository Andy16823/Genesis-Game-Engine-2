package GGE.Core;

import GGE.Math.Size2;
import GGE.Math.Vector2;

import java.util.Vector;

/**
 * Created by Andreas on 13.08.14.
 */
public class Scene {
    private String Name;
    private String Tag;
    private boolean Enable;
    private Vector<GameElement> GameElements;
    private Vector2 Location;
    private Size2 Size;

    public Scene(String name, Vector2 location, Size2 size) {
        Name = name;
        Location = location;
        Size = size;
        GameElements = new Vector<GameElement>();
        Enable = true;
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

    public Size2 getSize() {
        return Size;
    }

    public void setSize(Size2 size) {
        Size = size;
    }

    public Vector<GameElement> getGameElements() {
        return GameElements;
    }

    public Vector<GameElement> getGameElementByTag(String Tag)
    {
        Vector<GameElement> Elements = new Vector<GameElement>();
        for(GameElement element : GameElements)
        {
            if(element.getTag() != null && element.getTag().equals(Tag))
            {
                Elements.add(element);
            }
        }
        return Elements;
    }

    public void addGameElement(GameElement Element)
    {
        this.GameElements.add(Element);
    }

    public void updateScene()
    {
        for(GameElement element : this.GameElements)
        {
            element.updateElement();
        }
    }

}
