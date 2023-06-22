package com.bnp.rover.model;

import com.bnp.rover.constants.Constants;
import com.bnp.rover.utils.RoverUtility;

import java.util.StringJoiner;

public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Plateau plateau;

    public Rover(int x, int y, Direction direction, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    /**
     * Method to move the robot according to the provided instructions.
     * @param instructions List of instructions to move the robot.
     */
    public void processInstructions(String instructions) {
        Instruction[] parsedInstructions = RoverUtility.parseInstructions(instructions);
        for (Instruction instruction : parsedInstructions) {
            RoverUtility.applyInstruction(instruction, this);
        }
    }

    public String getPosition() {
        StringJoiner output = new StringJoiner(Constants.SPACE);
        output.add(String.valueOf(x))
                .add(String.valueOf(y))
                .add(direction.toString());
        return output.toString();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
