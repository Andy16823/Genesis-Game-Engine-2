package GGE.Core;

import java.awt.*;

/**
 * Created by Andreas on 13.08.14.
 */
public interface GameElemenEvent {
    void Update(GameElement sender);
    void Render(GameElement sender, Graphics2D Graphics);
}
