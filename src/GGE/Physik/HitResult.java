package GGE.Physik;

import GGE.Core.GameElemenEvent;
import GGE.Core.GameElement;

/**
 * Created by Andreas on 15.08.14.
 */
public class HitResult {
    private boolean Hit;
    private GameElement HitElement;

    public HitResult(boolean hit, GameElement hitElement) {
        Hit = hit;
        HitElement = hitElement;
    }

    public HitResult() {
    }

    public boolean isHit() {
        return Hit;
    }

    public void setHit(boolean hit) {
        Hit = hit;
    }

    public GameElement getHitElement() {
        return HitElement;
    }

    public void setHitElement(GameElement hitElement) {
        HitElement = hitElement;
    }
}
