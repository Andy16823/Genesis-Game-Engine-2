package GGE.AI;

/**
 * Created by Andreas on 07.09.14.
 */
public interface WaypointEvent {
    void waypointChange(Object Parent, int WaypointIndex);
    void onWaypointRandom(Object Parent, int WaypointIndex);
    void onWaypointStepp(Object Parent, int WaypointIndex);
}
