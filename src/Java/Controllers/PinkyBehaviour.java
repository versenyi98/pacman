package Java.Controllers;

import Java.UI.Map;
import Java.UI.Model.Ghost;

import static Java.Main.*;

import java.util.ArrayList;

public class PinkyBehaviour extends BaseGhostBehaviour {

    private int pacmanX = -1, pacmanY = -1;
    private int pacmanLastX = -1, pacmanLastY = -1;
    private int pacmanDirectionX, pacmanDirectionY;

    public PinkyBehaviour() {}

    @Override
    protected void behaviour(Ghost ghost) {

        int distanceToWall = 0;

        int ghostX = ghost.getBlockX();
        int ghostY = ghost.getBlockY();

        pacmanLastX = pacmanX;
        pacmanLastY = pacmanY;

        pacmanX = -1;
        pacmanY = -1;

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 27 ; j++) {
                if (Map.get(j, i) > 0 && Map.get(j, i) % 2 == 0) {
                    pacmanY = i;
                    pacmanX = j;
                }
            }
        }

        if (pacmanX < 0 || pacmanY < 0) return;
/*
        System.out.println("pacman X = " + pacmanX + " pacman Y = " + pacmanY);
        System.out.println("pacman last X = " + pacmanLastX + " pacman last Y = " + pacmanLastY);
*/
        if (pacmanX != pacmanLastX) {
            pacmanDirectionX = pacmanX - pacmanLastX;
        }

        if (pacmanY != pacmanLastY) {
            pacmanDirectionY = pacmanY - pacmanLastY;
        }

        for (int i = 4; i >= 1; i--) {

            if (Map.get(pacmanX + i * pacmanDirectionX, pacmanY + i * pacmanDirectionY) > 0) {
                distanceToWall = i;
                break;
            }
        }

        ArrayList<State> opened = new ArrayList<State>();
        ArrayList<State> closed = new ArrayList<State>();

        opened.add(new State(ghostX, ghostY, null));

        while (!opened.isEmpty()) {

            if (isGoalState(opened.get(0), pacmanX + distanceToWall * pacmanDirectionX, pacmanY + distanceToWall * pacmanDirectionY)) {

                State state = opened.get(0);

                while (state.parent != null && state.parent.parent != null) {
                    state = state.parent;
                }

                Map.move(ghost,ghostX,ghostY,state.getX(),state.getY());
                break;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) + Math.abs(j) == 1 && operatorRequirement(opened.get(0), i, j)) {
                        State state = new State(opened.get(0).getX() + i, opened.get(0).getY() + j, opened.get(0));

                        if (!contains(opened, state) && !contains(closed, state)) {
                            opened.add(state);
                        }
                    }
                }
            }

            closed.add(opened.get(0));
            opened.remove(0);
        }
    }

    private boolean contains(ArrayList<State> arrayList, State state) {

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getX() == state.getX() && arrayList.get(i).getY() == state.getY()) {
                return true;
            }
        }

        return false;
    }

    private class State {
        State(int x, int y, State parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        State getParent() {
            return parent;
        }

        private int x;
        private int y;

        private State parent;
    }

    private boolean operatorRequirement(State state, int operatorX, int operatorY) {

        if (state.getX() + operatorX < 0 || state.getX() + operatorX >= 27) {
            return false;
        }

        if (state.getY() + operatorY < 0 || state.getY() + operatorY >= 31) {
            return false;
        }

        return Map.get(state.getX() + operatorX, state.getY() + operatorY) > 0;
    }

    private boolean isGoalState(State state, int goalX, int goalY) {
        return state.getX() == goalX && state.getY() == goalY;
    }
}
