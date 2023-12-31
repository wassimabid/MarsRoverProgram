package com.bnp.rover.utils;

import com.bnp.rover.model.Direction;
import com.bnp.rover.model.Instruction;
import com.bnp.rover.model.Rover;

public class RoverUtility {
    public static Instruction[] parseInstructions(String instructions) {
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

    public static void applyInstruction(Instruction instruction, Rover rover) {
        switch (instruction) {
            case L:
                turnLeft(rover);
                break;
            case R:
                turnRight(rover);
                break;
            case M:
                moveForward(rover);
                break;
        }
    }

    private static void turnLeft(Rover rover) {
        if (rover.getDirection() == Direction.N) {
            rover.setDirection(Direction.W);
        } else if (rover.getDirection() == Direction.W) {
            rover.setDirection(Direction.S);
        } else if (rover.getDirection() == Direction.S) {
            rover.setDirection(Direction.E);
        } else if (rover.getDirection() == Direction.E) {
            rover.setDirection(Direction.N);
        }
    }

    private static void turnRight(Rover rover) {
        if (rover.getDirection() == Direction.N) {
            rover.setDirection(Direction.E);
        } else if (rover.getDirection() == Direction.E) {
            rover.setDirection(Direction.S);
        } else if (rover.getDirection() == Direction.S) {
            rover.setDirection(Direction.W);
        } else if (rover.getDirection() == Direction.W) {
            rover.setDirection(Direction.N);
        }
    }

    private static void moveForward(Rover rover) {
        int newX = rover.getX();
        int newY = rover.getY();
        Direction direction=rover.getDirection();

        if (direction == Direction.N) {
            newY++;
        } else if (direction == Direction.E) {
            newX++;
        } else if (direction == Direction.S) {
            newY--;
        } else if (direction== Direction.W) {
            newX--;
        }

        if (rover.getPlateau().isValidPosition(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        }
    }
}