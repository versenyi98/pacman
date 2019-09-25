package Java.UI.Model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Ghost extends Entity {

    private Timeline testLoop;

    public Ghost(int id) {
        super(id);
    }

    public void init(EventHandler<ActionEvent> e) {
        KeyFrame kf = new KeyFrame(Duration.seconds(1.0/10.0), e);

        testLoop = new Timeline();
        testLoop.getKeyFrames().add( kf );
        testLoop.setCycleCount( Animation.INDEFINITE );
        play();
    }

    public void play() {
        testLoop.play();
    }

    public void pause() {
        testLoop.pause();
    }

    public void stop() {
        testLoop.stop();
    }
}
