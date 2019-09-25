package Java;

import Java.Controllers.*;
import Java.UI.Model.Block;
import Java.UI.Model.Ghost;
import Java.UI.Model.Pacman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {
    public static Pacman pacman = new Pacman(2);
    public static Ghost blinky = new Ghost(3);
    public static Ghost pinky = new Ghost(5);
    public static Ghost inky = new Ghost(7);
    public static Ghost clyde = new Ghost(11);
    public static MapDrawer mapDrawer;
    public static final double WINDOW_HEIGHT = 31 * Block.SIZE;
    public static final double WINDOW_WIDTH = 28 * Block.SIZE;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene mainScene = new Scene(root);
        mainScene.setFill(Paint.valueOf("121212"));

        primaryStage.setTitle("Pac - Man");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);

        MainController mainController = new MainController(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
