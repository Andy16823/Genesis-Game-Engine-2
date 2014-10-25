package GGE.UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by Andreas on 14.08.14.
 */
public class UIContentManager {
    private String Name;
    private String Tag;
    private Vector<UIContent> Contents;

    public UIContentManager(String name) {
        Name = name;
        Contents = new Vector<UIContent>();
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

    public void addUIContent(UIContent content)
    {
        this.Contents.add(content);
    }

    public void renderContents(Graphics2D g)
    {
        for(UIContent content : Contents)
        {
            content.renderContent(g);
        }
    }

    public void updateContents()
    {
        for(UIContent content : Contents)
        {
            content.updateContent();
        }
    }

    public void mouseMove(MouseEvent e)
    {
        for(UIContent content : Contents)
        {
            content.contentMouseMove(e);
        }
    }

    public void mouseDown(MouseEvent e)
    {
        if(e.getButton() == e.BUTTON1)
        {
            for(UIContent content : Contents)
            {
                content.contentMouseDown(e);
            }
        }
    }

}
