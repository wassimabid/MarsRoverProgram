package com.bnp.rover.model;

import com.bnp.rover.constants.Constants;

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
        for (Instruction instruction : parseInstructions(instructions)) {
            if (instruction == Instruction.L) {
                turnLeft();
            } else if (instruction == Instruction.R) {
                turnRight();
            } else if (instruction == Instruction.M) {
                moveForward();
            }
        }
    }

    private void turnLeft() {
        if (direction == Direction.N) {
            direction = Direction.W;
        } else if (direction == Direction.W) {
            direction = Direction.S;
        } else if (direction == Direction.S) {
            direction = Direction.E;
        } else if (direction == Direction.E) {
            direction = Direction.N;
        }
    }

    private void turnRight() {
        if (direction == Direction.N) {
            direction = Direction.E;
        } else if (direction == Direction.E) {
            direction = Direction.S;
        } else if (direction == Direction.S) {
            direction = Direction.W;
        } else if (direction == Direction.W) {
            direction = Direction.N;
        }
    }

    private void moveForward() {
        int newX = x;
        int newY = y;

        if (direction == Direction.N) {
            newY++;
        } else if (direction == Direction.E) {
            newX++;
        } else if (direction == Direction.S) {
            newY--;
        } else if (direction == Direction.W) {
            newX--;
        }

        if (plateau.isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    private Instruction[] parseInstructions(String instructions) {
        Instruction[] parsedInstructions = new Instruction[instructions.length()];
        for (int i = 0; i < instructions.length(); i++) {
            char instructionChar = instructions.charAt(i);
            switch (instructionChar) {
                case 'L':
                    parsedInstructions[i] = Instruction.L;
                    break;
                case 'R':
                    parsedInstructions[i] = Instruction.R;
                    break;
                case 'M':
                    parsedInstructions[i] = Instruction.M;
                    break;
            }
        }
        return parsedInstructions;
    }

    public String getPosition() {
        StringJoiner output = new StringJoiner(Constants.SPACE);
        output.add(String.valueOf(x))
                .add(String.valueOf(y))
                .add(direction.toString());
        return output.toString();
    }
}
