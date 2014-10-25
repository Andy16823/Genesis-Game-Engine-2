package GGE.Core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Andreas on 13.08.14.
 */
public class SceneManager {
    private String Name;
    private String Tag;
    private boolean Enable;
    private Vector<Scene> Scenes;
    private BufferedImage MapBuffer;
    private int SceneIndex;

    public SceneManager(String name) {
        Name = name;
        this.Enable = true;
        Scenes = new Vector<Scene>();
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

    public int getSceneIndex() {
        return SceneIndex;
    }

    public void setSceneIndex(int sceneIndex) {
        SceneIndex = sceneIndex;
    }

    public BufferedImage getMapBuffer() {
        return MapBuffer;
    }

    public void setMapBuffer(BufferedImage mapBuffer) {
        MapBuffer = mapBuffer;
    }

    public Vector<Scene> getScenes() {
        return Scenes;
    }

    public void addScene(Scene Scene)
    {
        this.Scenes.add(Scene);
    }

    public void changeScene(int Index)
    {
        if(Scenes.size() > Index || Scenes.size() == Index)
        {
            this.SceneIndex = Index;
        }
    }

    public void buildMapBuffer()
    {
        Scene SelectedScene = Scenes.get(SceneIndex);
        BufferedImage MapBuffer = new BufferedImage(SelectedScene.getSize().getWidth(), SelectedScene.getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) MapBuffer.getGraphics();

        for(GameElement Element : SelectedScene.getGameElements())
        {
            if(Element.getRenderMode() == RenderModes.OnSceneBuild)
            {
                Element.renderElement(g2d);
            }
        }

        this.MapBuffer = MapBuffer;
    }

    public Scene getCurrentScene()
    {
        return this.Scenes.get(this.SceneIndex);
    }

}
