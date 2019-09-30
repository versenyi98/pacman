package Java.Controllers;

import static Java.Main.*;

import Java.UI.Map;
import Java.UI.Model.Entity;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainController {

    public MainController(Scene mainScene, Text scoreText) {
        mapDrawer = new MapDrawer(mainScene);
        mapDrawer.setScoreText(scoreText);
        BaseGhostController baseGhostController = new BaseGhostController();

        BlinkyBehaviour blinkyBehaviour = new BlinkyBehaviour();
        PinkyBehaviour pinkyBehaviour = new PinkyBehaviour();
        IncaBehaviour incaBehaviour = new IncaBehaviour();
        ClydeBehaviour clydeBehaviour= new ClydeBehaviour();


        pacman.setImage("resources/pacman.png");
        blinky.setImage("resources/ghost1.png");
        pinky.setImage("resources/ghost2.png");
        inky.setImage("resources/ghost3.png");
        clyde.setImage("resources/ghost4.png");

        mapDrawer.renderMap();

        baseGhostController.attachBehaviour(blinky);
        baseGhostController.attachBehaviour(pinky);
        baseGhostController.attachBehaviour(inky);
        baseGhostController.attachBehaviour(clyde);

        blinkyBehaviour.attachBehaviour(blinky);
        pinkyBehaviour.attachBehaviour(pinky);
        incaBehaviour.attachBehaviour(inky);
        clydeBehaviour.attachBehaviour(clyde);



        PacmanController pacmanController = new PacmanController();
        mainScene.setOnKeyPressed(pacmanController::handleKeyPress);

        // Temporary...  just prints out the current map representation
        mainScene.setOnMouseClicked(e -> {
            for (int c = 0; c < 31; c++) {
                System.out.print("{");
                for (int r = 0; r < 28; r++)  {
                    if (r != 0) System.out.print(",");
                    System.out.print(Map.get(r,c));
                }
                System.out.println("},");
            }
        });

        // Renders the entities and updates the map array
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
        // Get the current position in the map array from the real coords
        int posX = (int)(e.getPositionX() / BLOCK_SIZE);
        int posY = (int)(e.getPositionY() / BLOCK_SIZE);
        int oldX = e.getBlockX();
        int oldY = e.getBlockY();
        if (posX != oldX || posY != oldY) Map.move(e,oldX,oldY,posX,posY);
    }

    public void setScoreText(Text text) {
        mapDrawer.setScoreText(text);
    }
}