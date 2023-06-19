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
            System.out.println("Veuillez spécifier le nom du fichier d'entrée.");
            return;
        }
        String file = args[0];
        File inputFile = new File(file);

        try (Scanner scanner = new Scanner(inputFile)) {

            // Lecture des coordonnées du plateau
            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();
            scanner.nextLine();

            Plateau plateau = new Plateau(maxX, maxY);
            List<Rover> rovers = new ArrayList<>();

            // Lecture des informations des rovers
            while (scanner.hasNextLine()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char direction = scanner.next().charAt(0);
                scanner.nextLine();

                Rover rover = new Rover(x, y, direction, plateau);
                rovers.add(rover);

                // Lecture des instructions de rover
                String instructions = scanner.nextLine();
                rover.processInstructions(instructions);
            }

            // Affichage des positions finales des rovers
            rovers.forEach(rover -> System.out.println(rover.getPosition()));

        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable : " + file);
        }
    }



}
