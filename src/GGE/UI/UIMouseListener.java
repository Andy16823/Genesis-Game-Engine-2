package GGE.UI;

import java.awt.event.MouseEvent;

/**
 * Created by Andreas on 14.08.14.
 */
public interface UIMouseListener {
    void MouseMove(Control sender, MouseEvent event);
    void MouseClick(Control sender);
}
