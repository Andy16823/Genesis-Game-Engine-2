package GGE.Animation;

import GGE.Core.GameElement;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

/**
 * Created by Andreas on 17.08.14.
 */
public class Animation {
    private String Name;
    private String Tag;
    private boolean Enable;
    private int CellWidth;
    private int CellHeight;
    private int StartX;
    private int StartY;
    private int Cells;
    private int AnimationImageIndex;
    private GameElement AnimationTarget;
    private BufferedImage AnimationSheet;
    private List<BufferedImage> AnimationImages;
    private PlayModes PlayMode;
    private AsyncAnimationPlayer AnimationPlayer;

    public Animation(String name, int cellWidth, int cellHeight, int startX, int startY, int cells, BufferedImage animationSheet, PlayModes PlayMode, GameElement AnimationTarget) {
        Name = name;
        CellWidth = cellWidth;
        CellHeight = cellHeight;
        StartX = startX;
        StartY = startY;
        Cells = cells;
        AnimationSheet = animationSheet;
        this.Enable = true;
        this.AnimationImages = new Vector<BufferedImage>();
        this.parseParts();
        this.PlayMode = PlayMode;
        this.AnimationTarget = AnimationTarget;
    }

    public Animation(String name, GameElement AnimationTarget) {
        Name = name;
        this.Enable = true;
        this.AnimationImages = new Vector<BufferedImage>();
        this.AnimationTarget = AnimationTarget;
    }

    public Animation() {
        this.Enable = true;
        this.AnimationImages = new Vector<BufferedImage>();
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

    public int getCellWidth() {
        return CellWidth;
    }

    public void setCellWidth(int cellWidth) {
        CellWidth = cellWidth;
    }

    public int getCellHeight() {
        return CellHeight;
    }

    public void setCellHeight(int cellHeight) {
        CellHeight = cellHeight;
    }

    public int getStartX() {
        return StartX;
    }

    public void setStartX(int startX) {
        StartX = startX;
    }

    public int getStartY() {
        return StartY;
    }

    public void setStartY(int startY) {
        StartY = startY;
    }

    public int getCells() {
        return Cells;
    }

    public void setCells(int cells) {
        Cells = cells;
    }

    public int getAnimationImageIndex() {
        return AnimationImageIndex;
    }

    public void setAnimationImageIndex(int animationImageIndex) {
        AnimationImageIndex = animationImageIndex;
    }

    public BufferedImage getAnimationSheet() {
        return AnimationSheet;
    }

    public void setAnimationSheet(BufferedImage animationSheet) {
        AnimationSheet = animationSheet;
    }

    public PlayModes getPlayMode() {
        return PlayMode;
    }

    public void setPlayMode(PlayModes playMode) {
        PlayMode = playMode;
    }

    public List<BufferedImage> getAnimationImages() {
        return AnimationImages;
    }

    public GameElement getAnimationTarget() {
        return AnimationTarget;
    }

    public void setAnimationTarget(GameElement animationTarget) {
        AnimationTarget = animationTarget;
    }

    public void parseAnimationSheet(int CellWidth, int CellHeight, int Cells, int StartX, int StartY, BufferedImage AnimationSheet)
    {
        this.CellWidth = CellWidth;
        this.CellHeight = CellHeight;
        this.StartX = StartX;
        this.StartY = StartY;
        this.Cells = Cells;
        this.AnimationSheet = AnimationSheet;
        this.parseParts();
    }

    private void parseParts()
    {
        for(int i = 0; i < this.Cells; i++)
        {
            BufferedImage part = this.AnimationSheet.getSubimage((this.StartX + this.CellWidth)* i, this.StartY, this.CellWidth, this.CellHeight);
            this.AnimationImages.add(part);
        }
    }

    public void start()
    {
        if(AnimationPlayer != null && AnimationPlayer.isAllive())
        {
            AnimationPlayer.stopAnimation();
        }

        AnimationPlayer = new AsyncAnimationPlayer(this);
    }

    public void stop()
    {
        if(AnimationPlayer != null && AnimationPlayer.isAllive())
        {
            AnimationPlayer.stopAnimation();
        }
    }
}
