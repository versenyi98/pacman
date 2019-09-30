package Java.Controllers;

import Java.UI.Model.Ghost;

public class BaseGhostController {


    public void attachBehaviour(Ghost ghost) {
        ghost.setController(e -> move(ghost));
    }

    public void move(Ghost ghost) {
        double ghostX = ghost.getPositionX();
        double ghostY = ghost.getPositionY();
        ghost.setPosition(ghostX + ghost.getVelocityX(),ghostY + ghost.getVelocityY());
    }
}
