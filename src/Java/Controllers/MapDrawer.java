package Java.Controllers;

import static Java.Main.*;

import Java.UI.Map;
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

	/**
     * Renders the walls and sets the positions of the entities
     * */
	void renderMap() {
	    background.getGraphicsContext2D().setFill(Color.color(0,0,0.8,0.8));
        for (int i = 0; i < 28; i++) {
            for (int n = 0; n < 31; n++) {
                int block = Map.get(i,n);
                // If its 0 means its a wall
                if (block == 0) {
                    background.getGraphicsContext2D().fillRect(BLOCK_SIZE*i, BLOCK_SIZE*n, BLOCK_SIZE, BLOCK_SIZE);
                    continue;
                }

                // If map[n][i] can be divided by xy means an entity is there
                // For example:
                // 3 - Blinky is there
                // 5 - Pinky is there
                // 15 - Blinky and Pinky are both there
                // Sets the its there pos in the BO
                if (block % pacman.getId() == 0) {
                    pacman.setBlockPos(i, n);
                    pacman.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (block % blinky.getId() == 0) {
                    blinky.setBlockPos(i, n);
                    blinky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (block % pinky.getId() == 0) {
                    pinky.setBlockPos(i, n);
                    pinky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (block % inky.getId() == 0) {
                    inky.setBlockPos(i, n);
                    inky.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                if (block % clyde.getId() == 0) {
                    clyde.setBlockPos(i, n);
                    clyde.setPosition(getBlockCoords(i), getBlockCoords(n));
                }
                renderEntities();
            }
        }
    }

    /**
     * Actually renders the entities
     * */
    public void renderEntities() {
        // Clears the canvas (there are 2 separated for the entities and the background)
        entities.getGraphicsContext2D().clearRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        pacman.render( entities.getGraphicsContext2D());
        blinky.render(entities.getGraphicsContext2D());
        pinky.render(entities.getGraphicsContext2D());
        inky.render(entities.getGraphicsContext2D());
        clyde.render(entities.getGraphicsContext2D());
    }

    private double getBlockCoords(int b) {
        return BLOCK_SIZE*b;
    }
}