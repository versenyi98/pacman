package Java.UI.Model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import static Java.Main.BLOCK_SIZE;

public class Ghost extends Entity {

    private Timeline behaviour = new Timeline();
    private Timeline movement = new Timeline();
    private final double tickSpeed = 0.25;

    public Ghost(int id) {
        super(id);
    }

    // Separate thread for the ghosts' custom behaviour
    public void init(EventHandler<ActionEvent> b) {
        behaviour.getKeyFrames().add( new KeyFrame(Duration.seconds(tickSpeed), b) );
        behaviour.setCycleCount( Animation.INDEFINITE );
        play();
    }

    public void setController(EventHandler<ActionEvent> controller) {
        movement.getKeyFrames().add( new KeyFrame(Duration.seconds(tickSpeed/BLOCK_SIZE), controller) );
        movement.setCycleCount( Animation.INDEFINITE );
    }

    public void play() {
        movement.play();
        behaviour.play();
    }

    public void pause() {
        behaviour.pause();
    }

    public void stop() {
        behaviour.stop();
    }
}
