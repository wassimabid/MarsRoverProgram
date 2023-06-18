import java.util.StringJoiner;

class Rover {
    private int x;
    private int y;
    private char direction;
    private Plateau plateau;

    public Rover(int x, int y, char direction, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == Constants.LEFT) {
                turnLeft();
            } else if (instruction == Constants.RIGHT) {
                turnRight();
            } else if (instruction == Constants.MOVE) {
                moveForward();
            }
        }
    }

    private void turnLeft() {
        if (direction == Constants.NORTH) {
            direction = Constants.WEST;
        } else if (direction == Constants.WEST) {
            direction = Constants.SOUTH;
        } else if (direction == Constants.SOUTH) {
            direction = Constants.EAST;
        } else if (direction == Constants.EAST) {
            direction = Constants.NORTH;
        }
    }

    private void turnRight() {
        if (direction == Constants.NORTH) {
            direction = Constants.EAST;
        } else if (direction == Constants.EAST) {
            direction = Constants.SOUTH;
        } else if (direction == Constants.SOUTH) {
            direction = Constants.WEST;
        } else if (direction == Constants.WEST) {
            direction = Constants.NORTH;
        }
    }

    private void moveForward() {
        int newX = x;
        int newY = y;

        if (direction == Constants.NORTH) {
            newY++;
        } else if (direction == Constants.EAST) {
            newX++;
        } else if (direction == Constants.SOUTH) {
            newY--;
        } else if (direction == Constants.WEST) {
            newX--;
        }

        if (plateau.isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public String getPosition() {
        StringJoiner output = new StringJoiner(Constants.SPACE);
        output.add(String.valueOf(x))
                .add(String.valueOf(y))
                .add(String.valueOf(direction));
        return output.toString();
    }
}
