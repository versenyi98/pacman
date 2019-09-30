package Java;

import Java.Controllers.*;
import Java.UI.Model.Ghost;
import Java.UI.Model.Pacman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static final Pacman pacman = new Pacman(2);
    public static final Ghost blinky = new Ghost(3);
    public static final Ghost pinky = new Ghost(5);
    public static final Ghost inky = new Ghost(7);
    public static final Ghost clyde = new Ghost(11);
    public static MapDrawer mapDrawer;
    public static final int BLOCK_SIZE = 18;
    public static final double WINDOW_HEIGHT = 31 * BLOCK_SIZE;
    public static final double WINDOW_WIDTH = 28 * BLOCK_SIZE;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene mainScene = new Scene(root);
        mainScene.setFill(Paint.valueOf("121212"));
        Text scoreText = new Text(WINDOW_WIDTH / 2 - BLOCK_SIZE, BLOCK_SIZE * 5 + BLOCK_SIZE / 2, "Score: ");
        scoreText.setFill(Color.YELLOW);
        root.getChildren().add(scoreText);

        primaryStage.setTitle("Pac - Man");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);



        MainController mainController = new MainController(mainScene, scoreText);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
