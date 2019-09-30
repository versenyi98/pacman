package Java.Controllers;

import Java.UI.Map;
import Java.UI.Model.Ghost;

import java.util.ArrayList;


public class ClydeBehaviour extends BaseGhostBehaviour {

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

    @Override
    protected void behaviour(Ghost ghost) {
        int pacmanX = 0, pacmanY = 0;
        int ghostX = ghost.getBlockX();
        int ghostY = ghost.getBlockY();

        // Magic numbers explained: 31, 27 :the game Map has a fixed size.
        //                             2: Pacman
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 27; j++) {
                int currentEntity = Map.get(j, i);
                if (currentEntity != 0 && currentEntity % 2 == 0) {
                    pacmanY = i;
                    pacmanX = j;
                }
            }
        }

        int targetPositionX = -1;
        int targetPositionY = -1;
        if (Math.abs((ghostX - pacmanX) + (ghostY - pacmanY)) < 8) {
            targetPositionX = 1;
            targetPositionY = 1;
        } else {
            targetPositionX = pacmanX;
            targetPositionY = pacmanY;
        }

        ArrayList<ClydeBehaviour.State> opened = new ArrayList<ClydeBehaviour.State>();
        ArrayList<ClydeBehaviour.State> closed = new ArrayList<ClydeBehaviour.State>();

        opened.add(new ClydeBehaviour.State(ghostX, ghostY, null));

        while (!opened.isEmpty()) {

            if (isGoalState(opened.get(0), targetPositionX, targetPositionY)) {

                ClydeBehaviour.State state = opened.get(0);

                while (state.parent != null && state.parent.parent != null) {
                    state = state.parent;
                }

                ghost.setVelocity((state.getX() - ghostX) * 18, (state.getY() - ghostY) * 18);
                ghost.update();
                break;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) + Math.abs(j) == 1 && operatorRequirement(opened.get(0), i, j)) {
                        ClydeBehaviour.State state = new ClydeBehaviour.State(opened.get(0).getX() + i, opened.get(0).getY() + j, opened.get(0));

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
