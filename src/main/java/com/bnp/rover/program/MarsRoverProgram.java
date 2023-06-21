package com.bnp.rover.program;

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
            System.out.println("Please specify the input file name.");
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
                char direction = scanner.next().charAt(0);
                scanner.nextLine();

                Rover rover = new Rover(x, y, direction, plateau);
                rovers.add(rover);

                // Reading rover instructions
                String instructions = scanner.nextLine();
                rover.processInstructions(instructions);
            }

            // Displaying the final positions of the rovers
            rovers.forEach(rover -> System.out.println(rover.getPosition()));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }
    }
}
