package GGE.Math;

import GGE.Core.GameElement;
import GGE.Core.Scene;

import java.util.Vector;

/**
 * Created by Andreas on 31.08.14.
 */
public class CameraManager {
    private String Name;
    private String Tag;
    private boolean Enable;
    private Scene TargetScene;
    private Vector<Camera> Cameras;
    private Size2 DisplaySize;

    public CameraManager(String name, Scene targetScene, Size2 DisplaySize) {
        this.Cameras = new Vector<Camera>();
        Name = name;
        TargetScene = targetScene;
        this.Enable = true;
        this.DisplaySize = DisplaySize;
    }

    public void addCamera(Camera camera)
    {
        this.Cameras.add(camera);
    }

    public Vector<Camera> getCamerasByTag(String Tag)
    {
        Vector<Camera> cams = new Vector<Camera>();
        for(Camera camera : this.Cameras)
        {
            if(camera.getTag().equals(Tag))
            {
                cams.add(camera);
            }
        }
        return cams;
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

    public Scene getTargetScene() {
        return TargetScene;
    }

    public void setTargetScene(Scene targetScene) {
        TargetScene = targetScene;
    }

    public Vector<Camera> getCameras() {
        return Cameras;
    }

    public void setCameras(Vector<Camera> cameras) {
        Cameras = cameras;
    }

    public Size2 getDisplaySize() {
        return DisplaySize;
    }

    public void setDisplaySize(Size2 displaySize) {
        DisplaySize = displaySize;
    }

    public void changeCamera(int Index)
    {
        if(this.Cameras.size() > Index)
        {
            int OffsetX = this.TargetScene.getLocation().getX();
            int OffsetY = this.TargetScene.getLocation().getY();

            // Restet the Scene of the 0 / 0 Position
            if(OffsetX < 0)
            {
                OffsetX = Math.abs(OffsetX);
                this.TargetScene.getLocation().setX(this.TargetScene.getLocation().getX() + OffsetX);
                for(GameElement element : this.TargetScene.getGameElements())
                {
                    element.getLocation().setX(element.getLocation().getX() + OffsetX);
                }
            }
            else if(OffsetX > 0)
            {
                this.TargetScene.getLocation().setX(this.TargetScene.getLocation().getX() - OffsetX);
                for(GameElement element : this.TargetScene.getGameElements())
                {
                    element.getLocation().setX(element.getLocation().getX() - OffsetX);
                }
            }

            if(OffsetY < 0)
            {
                OffsetY = Math.abs(OffsetY);
                this.TargetScene.getLocation().setY(this.TargetScene.getLocation().getY() + OffsetY);
                for(GameElement element : this.TargetScene.getGameElements())
                {
                    element.getLocation().setY(element.getLocation().getY() + OffsetY);
                }
            }
            else if(OffsetY > 0)
            {
                this.TargetScene.getLocation().setY(this.TargetScene.getLocation().getY() - OffsetY);
                for(GameElement element : this.TargetScene.getGameElements())
                {
                    element.getLocation().setY(element.getLocation().getY() - OffsetY);
                }
            }

            // Set the camera in the center
            Camera SelectedCam = this.Cameras.get(Index);
            OffsetX = SelectedCam.getLocation().getX();
            OffsetY = SelectedCam.getLocation().getY();

            this.TargetScene.getLocation().setX(this.TargetScene.getLocation().getX() - OffsetX);
            this.TargetScene.getLocation().setY(this.TargetScene.getLocation().getY() - OffsetY);
            for(GameElement element : this.TargetScene.getGameElements())
            {
                element.getLocation().setX(element.getLocation().getX() - OffsetX);
                element.getLocation().setY(element.getLocation().getY() - OffsetY);
            }

        }
    }

}
