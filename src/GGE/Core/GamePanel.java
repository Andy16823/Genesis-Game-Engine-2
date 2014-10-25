package GGE.Core;

import GGE.Input.KeyInput;
import GGE.Input.MouseInput;
import GGE.UI.UIContentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Andreas on 13.08.14.
 */
public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    private String Name;
    private SceneManager SceneManager;
    private Timer Gameloop;
    private long GameLoopIntervall;
    private UIContentManager UIManager;
    private BufferedImage BackgroundImage;
    private MouseInput MouseInput;
    private KeyInput KeyInput;


    public GamePanel(long gameLoopIntervall) {
        GameLoopIntervall = gameLoopIntervall;
        this.setBackground(new Color(101, 156, 239));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.MouseInput = new GGE.Input.MouseInput();
        this.KeyInput = new GGE.Input.KeyInput();
    }

    /**
     * get the game name
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the game name
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Get the scene manager
     * @return
     */
    public SceneManager getSceneManager() {
        return SceneManager;
    }

    /**
     * Set the scene manager
     * @param sceneManager
     */
    public void setSceneManager(SceneManager sceneManager) {
        SceneManager = sceneManager;
    }

    /**
     * Get the intervall time from the game loop
     * @return
     */
    public long getGameLoopIntervall() {
        return GameLoopIntervall;
    }

    /**
     * Set the intervall time from the game loop
     * @param gameLoopIntervall
     */
    public void setGameLoopIntervall(long gameLoopIntervall) {
        GameLoopIntervall = gameLoopIntervall;
    }

    /**
     * Get the UIManeger
     * @return
     */
    public UIContentManager getUIManager() {
        return UIManager;
    }

    /**
     * Set the UIManager
     * @param UIManager
     */
    public void setUIManager(UIContentManager UIManager) {
        this.UIManager = UIManager;
    }

    /**
     * get the Background Image
     * @return
     */
    public BufferedImage getBackgroundImage() {
        return BackgroundImage;
    }

    /**
     * Set the Background Image
     * @param backgroundImage
     */
    public void setBackgroundImage(BufferedImage backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public MouseInput getMouseInput() {
        return MouseInput;
    }

    public void setMouseInput(MouseInput mouseInput) {
        MouseInput = mouseInput;
    }

    public KeyInput getKeyInput() {
        return KeyInput;
    }

    public void setKeyInput(KeyInput keyInput) {
        KeyInput = keyInput;
    }

    /**
     * Start the game
     */
    public void StartGame()
    {
        this.Gameloop = new Timer(this.GameLoopIntervall, this);
        this.Gameloop.start();
    }

    /**
     * Stop the game
     */
    public void StopGame()
    {
        this.Gameloop.timerStop();
    }

    /**
     * Update the game
     */
    public void Update()
    {
        // call the update events from the game elements
        if(this.SceneManager.getCurrentScene() != null)
        {
            // Update the Scene Elements
            Scene SelectedScene = this.SceneManager.getCurrentScene();
            SelectedScene.updateScene();

            // Update the UIManager
            if(this.UIManager != null)
            {
                this.UIManager.updateContents();
            }
        }

    }

    /**
     * Render the game
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(this.SceneManager.getMapBuffer() != null)
        {
            // declare the selected scene
            Scene SelectedScene = this.SceneManager.getCurrentScene();

            // create the game image and get the graphic
            Graphics2D g2d = (Graphics2D) g;

            // Beginn Draw
            this.beginPaint(g2d);
            
            // Draw the Background Image
            if(this.BackgroundImage != null)
            {
                g2d.drawImage(this.BackgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
            }

            // draw the mapbuffer
            g2d.drawImage(this.SceneManager.getMapBuffer(), SelectedScene.getLocation().getX(), SelectedScene.getLocation().getY(), SelectedScene.getSize().getWidth(), SelectedScene.getSize().getHeight(), null);

            // draw the dynamic elements
            for(GameElement Element : SelectedScene.getGameElements())
            {
                if(Element.getRenderMode() == RenderModes.OnGameDraw)
                {
                    if(Element.getLocation().getX() > 0 && Element.getLocation().getY() > 0 && Element.getLocation().getX() < this.getWidth() && Element.getLocation().getY() < this.getHeight())
                    {
                        Element.renderElement(g2d);
                    }
                }
            }

            // draw the UI
            if(this.UIManager != null)
            {
                this.UIManager.renderContents(g2d);
            }
            
            // End Paint
            this.endPaint(g2d);
        }

    }

    public void beginPaint(Graphics2D g)
    {
        
    }
    
    public void endPaint(Graphics2D g)
    {
        
    }
    
    
    /**
     * MouseClick event
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
       this.MouseInput.setButton(e.getButton());
       if(this.UIManager != null)
       {
           this.UIManager.mouseDown(e);
       }
    }

    /**
     * MousePressed event
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Mouse Released event
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        this.MouseInput.releaseButton();
    }

    /**
     * Mouse entered event
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Mouse exit event
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Mouse dragged event
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Mouse moved event
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        this.MouseInput.setLocationX(e.getX());
        this.MouseInput.setLocationY(e.getY());
        if(this.UIManager != null)
        {
            this.UIManager.mouseMove(e);
        }
    }

    /**
     * Key tipped event
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Key pressed event
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        this.KeyInput.setKey(e.getKeyCode());
    }

    /**
     * Key Released event
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        this.KeyInput.releaseKey();
    }
}
