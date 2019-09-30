package Java.UI;

import Java.UI.Model.Entity;
import Java.UI.Model.Ghost;


public class Map {
    private static Integer[][] map = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,2,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {-1,-1,-1,-1,-1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,0,1,0,0,1,0,0,0,-1,-1,0,0,0,1,0,0,1,0,-1,-1,-1,-1,-1},
            {0,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0},
            {-1,-1,-1,-1,-1,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,-1,-1,-1,-1,-1},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,0,0,1,1,1,11,1,1,5,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,7,1,1,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public static int get(int x, int y) {
        if (isOut(x,y)) return -1;
        return map[y][x];
    }

    public static void move(Entity e, int from_x, int from_y, int to_x, int to_y) {
        if (isOut(from_x,from_y) || isOut(to_x,to_y)) return;

        int id = e.getId();

        if (e instanceof Ghost) {
            e.setVelocity(to_x-from_x, to_y-from_y);
        }

        e.setBlockPos(to_x,to_y);
        int from_val = get(from_x,from_y);
        set(from_x, from_y,from_val/id);

        int to_val = get(to_x,to_y);
        set(to_x, to_y,to_val*id);

    }

    private static void set(int x, int y, int val) {
        map[y][x] = val;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || x > 27 || y < 0 || y > 30;
    }
}
