package com.bnp.rover.program;

import com.bnp.rover.model.Direction;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRoverProgram {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.print("Please specify the input file name.");
            return;
        }
        String file = args[0];
        File inputFile = new File(file);

        try (Scanner scanner = new Scanner(inputFile)) {

            // Reading the plateau coordinates
            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();
            scanner.nextLine();

            Plateau plateau = new Plateau(maxX, maxY);
            List<Rover> rovers = new ArrayList<>();

            // Reading rover information
            while (scanner.hasNextLine()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                String directionValue=scanner.next();
                Direction direction = parseDirection(directionValue);
                if (direction == null) {
                    System.out.print("Invalid direction value: " + directionValue);
                    return;
                }

                scanner.nextLine();

                Rover rover = new Rover(x, y, direction, plateau);

                // Reading rover instructions
                String instructions = scanner.nextLine();
                // Process instructions
                rover.processInstructions(instructions);

                rovers.add(rover);
            }

            // Displaying the final positions of the rovers
            rovers.forEach(rover -> System.out.println(rover.getPosition()));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }
    }
    private static Direction parseDirection(String directionStr) {
        try {
            return Direction.valueOf(directionStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
