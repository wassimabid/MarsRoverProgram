package com.bnp.rover.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MarsRoverProgramTest {

    @Test
    public void testMarsRoverProgram() {

        // Redirection de System.out pour capturer la sortie du programme (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Exécution du programme MarsRoverProgram en passant en parametre fichier de test
        MarsRoverProgram.main(new String[]{"src/test/resources/input.txt"});

        // Récupération de la sortie réelle du programme
        String actualOutput = outputStream.toString().trim();

        // Comparaison de la sortie réelle avec la sortie attendue
        String expectedOutput = "1 3 N"+System.lineSeparator()+"5 1 E";

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMain_NoInputFile() {
        // Redirection de System.out pour capturer la sortie du programme (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Exécution du programme com.bnp.rover.program.MarsRoverProgram sans arguments de ligne de commande
        MarsRoverProgram.main(new String[]{});

        // Récupération de la sortie réelle du programme
        String actualOutput = outputStream.toString().trim();

        // Comparaison de la sortie réelle avec le message d'erreur attendu
        String expectedOutput = "Veuillez spécifier le nom du fichier d'entrée.";
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}

