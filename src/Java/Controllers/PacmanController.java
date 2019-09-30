package Java.Controllers;

import Java.UI.Map;
import Java.Service.RepresentationService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import static Java.Main.*;

class PacmanController {

    private int[] input;
    private Timeline pacmanTimeline = new Timeline();
	private RepresentationService representationService = new RepresentationService();

    PacmanController() {
        pacmanTimeline.setCycleCount( Animation.INDEFINITE );
        setUpMovement();
    }

    void handleKeyPress(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        if (representationService.invertKeyCode(code) == null) return;

		int canMove = representationService.canMove(pacman, keyEvent.getCode());
		if (canMove == 0) return;
		if (canMove == 2) setPacmanStrait();

        input = representationService.keyCodeToVelocity(code);
		pacman.setRotation(getRotation());
		pacmanTimeline.play();

    }

    /**
     * If the player changes direction too early or too late it will make pacman strait
     */
    private void setPacmanStrait() {
        int newPosX = getBlockCoords(pacman.getPositionX() + pacman.getWidth()/2);
        int newPosY = getBlockCoords(pacman.getPositionY() + pacman.getHeight()/2);
        pacman.setPosition(newPosX * BLOCK_SIZE,newPosY * BLOCK_SIZE );
    }
	
	private int getRotation() {
		return ((Math.abs(input[0])-input[0])+input[1])*90;
	}

    /**
     * Checks if pacman can move forward or it should stop moving
     */
    private boolean canMove(double newX, double newY) {
        double addX = 0;
        double addY = 0;

        // Addition because of pacman's size
        if (pacman.getVelocityX() > 0) addX = pacman.getWidth();
        if (pacman.getVelocityY() > 0) addY = pacman.getHeight();

        // Next block's coordinates
        int col = getBlockCoords(newX + addX);
        int row = getBlockCoords(newY + addY);

        // If pacman goes out of the map (2 sides)
        if ( col < 0 || col > 27) return true;

        return Map.get(col,row) > 0;
    }

    private int getBlockCoords(double b) {
        return (int)(b/BLOCK_SIZE);
    }

    private void setUpMovement() {
        KeyFrame kf = new KeyFrame(
                Duration.seconds(1.0 / 80.0),
                e -> {
                    pacman.setVelocity(input[0], input[1]);

                    if (pacman.getPositionX() < 0 ) {
                        pacman.setPosition(WINDOW_WIDTH, pacman.getPositionY());
                    }
                    if (pacman.getPositionX() > WINDOW_WIDTH) {
                        pacman.setPosition(0, pacman.getPositionY());
                    }

                    if (canMove(pacman.getPositionX() + pacman.getVelocityX(),
                            pacman.getPositionY() + pacman.getVelocityY())) {
                        pacman.update();
                    } else {
                        pacmanTimeline.stop();
                    }
                });
        pacmanTimeline.getKeyFrames().add(kf);
    }
}
