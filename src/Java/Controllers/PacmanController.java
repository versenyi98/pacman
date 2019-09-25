package Java.Controllers;

import Java.UI.Map;
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

    PacmanController() {
        pacmanTimeline.setCycleCount( Animation.INDEFINITE );
        setUpMovement();
    }

    void handleKeyPress(KeyEvent keyEvent) {
        int[] tmp = canMove(keyEvent.getCode());
        if(tmp != null) {
            input = tmp;
            pacmanTimeline.play();
        }
    }

    private void setPacmanStrait() {
        int newPosX = getBlockCoords(pacman.getPositionX() + pacman.getWidth()/2);
        int newPosY = getBlockCoords(pacman.getPositionY() + pacman.getHeight()/2);
        pacman.setPosition(newPosX * BLOCK_SIZE,newPosY * BLOCK_SIZE );
    }

    private int[] canMove(KeyCode code) {
        int[] retVal;
        int rotation;
        switch (code) {
            case LEFT:
                retVal = new int[]{-1, 0};
                rotation = 180;
                break;
            case RIGHT:
                retVal = new int[]{ 1, 0};
                rotation = 0;
                break;
            case UP:
                retVal = new int[]{ 0,-1};
                rotation = -90;
                break;
            case DOWN:
                retVal = new int[]{ 0, 1};
                rotation = 90;
                break;
            case W:
                blinky.setPosition(blinky.getPositionX(),blinky.getPositionY()-2);
                return null;
            case S:
                blinky.setPosition(blinky.getPositionX(),blinky.getPositionY()+2);
                return null;
            case D:
                blinky.setPosition(blinky.getPositionX()+2,blinky.getPositionY());
                return null;
            case A:
                blinky.setPosition(blinky.getPositionX()-2,blinky.getPositionY());
                return null;
            default:
                return null;
        }

        if (retVal[0] * pacman.getVelocityX() < 0 || retVal[1] * pacman.getVelocityY() < 0) {
            pacman.setRotation(rotation);
            return retVal;
        } else if (retVal[0] * pacman.getVelocityX() > 0 || retVal[1] * pacman.getVelocityY() > 0) {
            return null;
        }

        int currentBlock_x = getBlockCoords(pacman.getPositionX() + pacman.getWidth()/2);
        int currentBlock_y = getBlockCoords(pacman.getPositionY() + pacman.getHeight()/2);
        double dif = 6;

        if (Map.map[currentBlock_y + retVal[1]][currentBlock_x + retVal[0]] > 0 &&
                Math.abs(pacman.getPositionY() - getBlockCoords(currentBlock_y)) < dif) {
            pacman.setRotation(rotation);
            setPacmanStrait();
            return retVal;
        }
        return null;
    }

    private boolean canMove(double newX, double newY) {
        double addX = 0;
        double addY = 0;

        // Addition beacause of pacman's size
        if (pacman.getVelocityX() > 0) addX = pacman.getWidth();
        if (pacman.getVelocityY() > 0) addY = pacman.getHeight();

        // Next block coordinates
        int row = getBlockCoords(newX + addX);
        int col = getBlockCoords(newY + addY);

        // If pacman goes out of the map (2 sides)
        if ( row < 0 || row > 27) return true;

        return Map.map[col][row] > 0;
    }

    private double getBlockCoords(int b) {
        return BLOCK_SIZE*b;
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
