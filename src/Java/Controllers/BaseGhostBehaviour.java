package Java.Controllers;

import Java.UI.Map;
import Java.UI.Model.Ghost;

import static Java.Main.*;

public class BaseGhostBehaviour {

    private int randX;
    private int randY;

    public BaseGhostBehaviour() {}

    public void attachBehaviour(Ghost ghost) {
        ghost.init(e -> behaviour(ghost));
    }

    /**
     * Just checks for collision and if it happens replaces the ghost...
     * */
    protected void behaviour(Ghost ghost) {
        if (ghost.intersects(pacman)) {
            randX = (int)(Math.random()*100)%28;
            randY = (int)(Math.random()*100)%31;
            if (Map.get(randX,randY) > 0) {
                mapDrawer.renderEntities();
            } else {
                behaviour(ghost);
            }
        }
    }
}
