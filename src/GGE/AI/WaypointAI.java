package GGE.AI;

        import GGE.Core.GameElement;

        import java.util.Vector;

/**
 * Created by Andreas on 16.08.14.
 */
public class WaypointAI {
    private GameElement GameElement;
    private Vector<Waypoint> Waypoints;
    private int WaypointIndex;
    private WaypointModes WaypointMode;
    private boolean Enable;
    private WaypointEvent WaypointListener;

    public WaypointAI(GGE.Core.GameElement gameElement, WaypointModes waypointMode) {
        GameElement = gameElement;
        WaypointMode = waypointMode;
        this.Waypoints = new Vector<Waypoint>();
    }

    public WaypointAI() {
        this.Waypoints = new Vector<Waypoint>();
    }

    public GameElement getGameElement() {
        return GameElement;
    }

    public void setGameElement(GameElement gameElement) {
        GameElement = gameElement;
    }

    public Vector<Waypoint> getWaypoints() {
        return Waypoints;
    }

    public void setWaypoints(Vector<Waypoint> waypoints) {
        Waypoints = waypoints;
    }

    public int getWaypointIndex() {
        return WaypointIndex;
    }

    public void setWaypointIndex(int waypointIndex) {
        WaypointIndex = waypointIndex;
    }

    public void addWaypoint(Waypoint Waypoint)
    {
        this.Waypoints.add(Waypoint);
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public WaypointModes getWaypointMode() {
        return WaypointMode;
    }

    public void setWaypointMode(WaypointModes waypointMode) {
        WaypointMode = waypointMode;
    }

    public WaypointEvent getWaypointListener() {
        return WaypointListener;
    }

    public void setWaypointListener(WaypointEvent waypointListener) {
        WaypointListener = waypointListener;
    }

    public void performStep()
    {
        if(this.Enable && WaypointIndex < this.Waypoints.size())
        {
            Waypoint waypoint = Waypoints.get(WaypointIndex);
            GameElement.setSize(waypoint.getSize());

            if(this.WaypointListener != null)
            {
                this.WaypointListener.onWaypointStepp(this, WaypointIndex);
            }

            if(GameElement.getLocation().getX() < waypoint.getLocation().getX())
            {
                GameElement.getLocation().setX(GameElement.getLocation().getX() + 1);
            }
            else if(GameElement.getLocation().getX() > waypoint.getLocation().getX())
            {
                GameElement.getLocation().setX(GameElement.getLocation().getX() - 1);
            }

            if(GameElement.getLocation().getY() < waypoint.getLocation().getY())
            {
                GameElement.getLocation().setY(GameElement.getLocation().getY() +1);
            }
            else if(GameElement.getLocation().getY() > waypoint.getLocation().getY())
            {
                GameElement.getLocation().setY(GameElement.getLocation().getY() -1);
            }

            if(GameElement.getLocation().getX() == waypoint.getLocation().getX() && GameElement.getLocation().getY() == waypoint.getLocation().getY())
            {
                WaypointIndex ++;

                if(this.WaypointListener != null)
                {
                    this.WaypointListener.waypointChange(this, WaypointIndex);
                }
            }

            if(this.WaypointIndex == this.Waypoints.size() && this.WaypointMode == WaypointModes.Random)
            {
                WaypointIndex = 0;

                if(this.WaypointListener != null)
                {
                    this.WaypointListener.onWaypointRandom(this, WaypointIndex);
                }
            }
        }
    }

    public void performStep(int Stepps)
    {
        for(int i = 0; i < Stepps; i++)
        {
            if(this.Enable && this.WaypointIndex < this.Waypoints.size())
            {
                Waypoint waypoint = this.Waypoints.get(this.WaypointIndex);
                GameElement.setSize(waypoint.getSize());

                if(this.WaypointListener != null)
                {
                    this.WaypointListener.onWaypointStepp(this, WaypointIndex);
                }

                if(GameElement.getLocation().getX() < waypoint.getLocation().getX())
                {
                    GameElement.getLocation().setX(GameElement.getLocation().getX() +1);
                }
                else if(GameElement.getLocation().getX() > waypoint.getLocation().getX())
                {
                    GameElement.getLocation().setX(GameElement.getLocation().getX() -1);
                }

                if(GameElement.getLocation().getY() < waypoint.getLocation().getY())
                {
                    GameElement.getLocation().setY(GameElement.getLocation().getY() + 1);
                }
                else if(GameElement.getLocation().getY() > waypoint.getLocation().getY())
                {
                    GameElement.getLocation().setY(GameElement.getLocation().getY() - 1);
                }

                if(GameElement.getLocation().getX() == waypoint.getLocation().getX() && GameElement.getLocation().getY() == waypoint.getLocation().getY())
                {
                    WaypointIndex ++;

                    if(this.WaypointListener != null)
                    {
                        this.WaypointListener.waypointChange(this, WaypointIndex);
                    }
                }

                if(this.WaypointIndex == this.Waypoints.size() && this.WaypointMode == WaypointModes.Random)
                {
                    WaypointIndex = 0;

                    if(this.WaypointListener != null)
                    {
                        this.WaypointListener.onWaypointRandom(this, WaypointIndex);
                    }
                }
            }
        }
    }

    public void stopAI()
    {
        this.Enable = false;
    }

    public void startAI()
    {
        this.Enable = true;
    }

}
