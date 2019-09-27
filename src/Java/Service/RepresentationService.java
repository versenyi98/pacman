package Java.Service;

import static Java.Main.*;

import javafx.scene.input.KeyCode;
import Java.UI.Map;
import Java.UI.Model.Pacman;
import Java.UI.Model.Entity;

public class RepresentationService {

	public int[] keyCodeToVelocity(KeyCode code) {
		switch (code) {
            case LEFT:
                return new int[]{-1, 0};
            case RIGHT:
                return new int[]{ 1, 0};
            case UP:
                return new int[]{ 0,-1};
            case DOWN:
                return new int[]{ 0, 1};
			default:
				return null;
		}
	}
	
	public KeyCode velocityToKeyCode(int[] v) {
		if (v[0] == -1 && v[1] ==  0) return KeyCode.LEFT;
		if (v[0] ==  1 && v[1] ==  0) return KeyCode.RIGHT;
		if (v[0] ==  0 && v[1] == -1) return KeyCode.UP;
		if (v[0] ==  0 && v[1] ==  1) return KeyCode.DOWN;
		return null;
	}
	
	public KeyCode invertKeyCode(KeyCode code) {
		switch (code) {
            case LEFT:
                return KeyCode.RIGHT;
            case RIGHT:
                return KeyCode.LEFT;
            case UP:
                return KeyCode.DOWN;
            case DOWN:
                return KeyCode.UP;
			default:
				return null;
		}
	}
	
	public int canMove(Entity e, KeyCode code) {
		if (e instanceof Pacman) return canPacmanMove(code);

        int blockX = e.getBlockX();
		int blockY = e.getBlockY();
		int[] v = keyCodeToVelocity(code);
		int val = Map.get(blockX+v[0], blockY+v[1]);

		return val > 0 ? 1 : 0;
	}
	
	private int canPacmanMove(KeyCode code) {
		int[] v = keyCodeToVelocity(code);
		// Going to the opposite direction of the current movement direction is always allowed
        if (v[0] * pacman.getVelocityX() < 0 || v[1] * pacman.getVelocityY() < 0) {
            //pacman.setRotation(rotation);
            return 1;
        } else if (v[0] * pacman.getVelocityX() > 0 || v[1] * pacman.getVelocityY() > 0) {
            // Going to the same direction as pacman currently moving is unnecessary
            return 1;
        }

        // if the player wants to change direction it checks if there's free block next to pacman
        int currentBlock_x = coordsToBlock(pacman.getPositionX() + pacman.getWidth()/2);
        int currentBlock_y = coordsToBlock(pacman.getPositionY() + pacman.getHeight()/2);
        double dif = 6;

        if (Map.get(currentBlock_x + v[0],currentBlock_y + v[1]) > 0 &&
                Math.abs(pacman.getPositionY() - blockToCoords(currentBlock_y)) < dif) {
            return 2;
        }
		return 0;
	}

	public double blockToCoords(int b) {
        return BLOCK_SIZE*b;
    }

    public int coordsToBlock(double b) {
        return (int)(b/BLOCK_SIZE);
    }
}
