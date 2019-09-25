package Java.Controllers;

import static Java.Main.*;

import Java.UI.Map;
import Java.UI.Model.Block;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class MapDrawer {
    private Canvas background;
    private Canvas entities;
	
	MapDrawer(Scene mainScene) {
        Group root = (Group) mainScene.getRoot();

        background = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT );
        entities = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT );

        root.getChildren().addAll(background, entities);
	}

	void renderMap() {
	    background.getGraphicsContext2D().setFill(Color.color(0,0,0.8,0.8));
        for (int i = 0; i < 28; i++) {
            for (int n = 0; n < 31; n++) {
                if (Map.map[n][i] == 0) {
                    background.getGraphicsContext2D().fillRect(Block.SIZE*i, Block.SIZE*n, Block.SIZE, Block.SIZE);
                    continue;
                }
                if (Map.map[n][i] % pacman.getId() == 0) {
                    pacman.setBlockPos(i, n);
                    pacman.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (Map.map[n][i] % blinky.getId() == 0) {
                    blinky.setBlockPos(i, n);
                    blinky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (Map.map[n][i] % pinky.getId() == 0) {
                    pinky.setBlockPos(i, n);
                    pinky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (Map.map[n][i] % inky.getId() == 0) {
                    inky.setBlockPos(i, n);
                    inky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (Map.map[n][i] % clyde.getId() == 0) {
                    clyde.setBlockPos(i, n);
                    clyde.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                renderEntities();
            }
        }
    }

    void renderEntities() {
        entities.getGraphicsContext2D().clearRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        for (int i = 0; i < 28; i++) {
            for (int n = 0; n < 31; n++) {

                int v = Map.map[n][i];
                if (v == 0) {
                    continue;
                }

                if (v % 2 == 0) pacman.render( entities.getGraphicsContext2D());
                if (v % blinky.getId() == 0) blinky.render(entities.getGraphicsContext2D() );
                if (v % pinky.getId() == 0) pinky.render(entities.getGraphicsContext2D() );
                if (v % inky.getId() == 0) inky.render(entities.getGraphicsContext2D() );
                if (v % clyde.getId() == 0) clyde.render(entities.getGraphicsContext2D() );
            }
        }
    }

    private double getBlockCoords(int b) {
        return Block.SIZE*b;
    }
}