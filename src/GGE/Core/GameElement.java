package GGE.Core;

import GGE.Math.*;
import GGE.Math.Rectangle;
import GGE.Physik.Gravitation;
import GGE.Physik.Collider;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 13.08.14.
 */
public class GameElement {
    private String Name;
    private String Tag;
    private boolean Enable;
    private BufferedImage Texture;
    private Vector2 Location;
    private Size2 Size;
    private RenderModes RenderMode;
    private Gravitation Gravitation;
    private GameElemenEvent GameElementListener;
    private Collider Collider;
    private float Rotation;

    public GameElement(String name, BufferedImage texture, Vector2 location, Size2 size, Collider Collider) {
        Name = name;
        Texture = texture;
        Location = location;
        Size = size;
        RenderMode = RenderModes.OnSceneBuild;
        Gravitation = new Gravitation(0,0, false, false);
        Enable = true;
        this.Collider = Collider;
        this.Rotation = 0.0f;
    }

    public GameElement(String name, BufferedImage texture, Vector2 location, Size2 size, RenderModes renderMode, GGE.Physik.Gravitation gravitation,  Collider Collider) {
        Name = name;
        Texture = texture;
        Location = location;
        Size = size;
        RenderMode = renderMode;
        Gravitation = gravitation;
        Enable = true;
        this.Collider = Collider;
        this.Rotation = 0.0f;
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

    public BufferedImage getTexture() {
        return Texture;
    }

    public void setTexture(BufferedImage texture) {
        Texture = texture;
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

    public RenderModes getRenderMode() {
        return RenderMode;
    }

    public void setRenderMode(RenderModes renderMode) {
        RenderMode = renderMode;
    }

    public Gravitation getGravitation() {
        return Gravitation;
    }

    public void setGravitation(Gravitation gravitation) {
        Gravitation = gravitation;
    }

    public void setGameElementListener(GameElemenEvent gameElementListener) {
        GameElementListener = gameElementListener;
    }

    public Collider getCollider() {
        return this.Collider;
    }

    public void setCollider(Collider collider) {
        Collider = collider;
    }

    public float getRotation() {
        return Rotation;
    }

    public void setRotation(float Rotation) {
        this.Rotation = Rotation;
    }
    
    

    public void renderElement(Graphics2D g2d)
    {
        if(this.Enable)
        {
            BufferedImage DrawTexture = new BufferedImage(Texture.getWidth(), Texture.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D ImgG2d = DrawTexture.createGraphics();
            ImgG2d.rotate(Rotation, DrawTexture.getWidth() /2, DrawTexture.getHeight() / 2);
            ImgG2d.drawImage(Texture, 0, 0, Texture.getWidth(), Texture.getHeight(), null);
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                        
            g2d.drawImage(DrawTexture, this.Location.getX(), this.Location.getY(), this.Size.getWidth(), this.Size.getHeight(), null);
            if(this.GameElementListener != null)
            {
                this.GameElementListener.Render(this, g2d);
            }
        }
    }

    public void updateElement()
    {
        if(this.GameElementListener != null)
        {
            this.GameElementListener.Update(this);
        }

        if(this.Gravitation.isxEnable())
        {
            this.Location.setX(this.Location.getX() + this.Gravitation.getxValue());
        }

        if(this.Gravitation.isyEnable())
        {
            this.Location.setY(this.Location.getY() + this.Gravitation.getyValue());
        }
    }

    public GGE.Math.Rectangle getBounds()
    {
        return new Rectangle(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getWidth(), this.getSize().getHeight());
    }
    
    

}
