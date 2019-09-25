package Java.Controllers;

import static Java.Main.*;

import Java.UI.Map;
import Java.UI.Model.Block;
import Java.UI.Model.Entity;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.util.Duration;

public class MainController {

    public MainController(Scene mainScene) {
        mapDrawer = new MapDrawer(mainScene);
        BaseGhostBehaviour baseGhostBehaviour = new BaseGhostBehaviour();

        pacman.setImage("resources/pacman.png");

        blinky.setImage("resources/ghost1.png");
        pinky.setImage("resources/ghost2.png");
        inky.setImage("resources/ghost3.png");
        clyde.setImage("resources/ghost4.png");

        baseGhostBehaviour.attachBehaviour(blinky);
        baseGhostBehaviour.attachBehaviour(pinky);
        baseGhostBehaviour.attachBehaviour(inky);
        baseGhostBehaviour.attachBehaviour(clyde);

        mapDrawer.renderMap();

        PacmanController pacmanController = new PacmanController();
        mainScene.setOnKeyPressed(pacmanController::handleKeyPress);
        mainScene.setOnMouseClicked(e -> {
            for (int c = 0; c < 31; c++) {
                System.out.print("{");
                for (int r = 0; r < 28; r++)  {
                    if (r != 0) System.out.print(",");
                    System.out.print(Map.map[c][r]);
                }
                System.out.println("},");
            }
        });

        KeyFrame kf = new KeyFrame(Duration.seconds(1.0 / 30.0),e -> {
            mapDrawer.renderEntities();
            updateRepresentation();
        });

        Timeline mainLoop = new Timeline();
        mainLoop.getKeyFrames().add( kf );
        mainLoop.setCycleCount( Animation.INDEFINITE );
        mainLoop.play();
    }

    private void updateRepresentation() {
        updateRepresentation(pacman);
        updateRepresentation(blinky);
        updateRepresentation(pinky);
        updateRepresentation(inky);
        updateRepresentation(clyde);
    }

    private void updateRepresentation(Entity e) {
        int posX = (int)(e.getPositionX() / Block.SIZE);
        int posY = (int)(e.getPositionY() / Block.SIZE);
        if (posX < 0 || posX > 27 || posY < 0 || posY > 30) return;
        Map.map[e.getBlockY()][e.getBlockX()] /= e.getId();
        Map.map[posY][posX] *= e.getId();
        e.setBlockPos(posX,posY);
    }
}