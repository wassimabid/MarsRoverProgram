package com.bnp.rover.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class MarsRoverProgramTest {

    @Test
    void testMarsRoverProgram() {

        // Redirecting System.out to capture the program output (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Executing the MarsRoverProgram by passing the test file as a parameter
        MarsRoverProgram.main(new String[]{"src/test/resources/input.txt"});

        // Getting the actual output from the program
        String actualOutput = outputStream.toString().trim();

        // Comparing the actual output with the expected output
        String expectedOutput = "1 3 N"+System.lineSeparator()+"5 1 E";

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMain_InputFile_NotFound() {

        // Redirecting System.out to capture the program output (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Executing the MarsRoverProgram by passing the test file as a parameter
        MarsRoverProgram.main(new String[]{"src/test/resources/gostfile.txt"});

        // Getting the actual output from the program
        String actualOutput = outputStream.toString().trim();

        // Comparing the actual output with the expected output
        String expectedOutput = "File not found: src/test/resources/gostfile.txt";

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMain_NoInputFile() {
        // Redirecting System.out to capture the program output (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Executing the MarsRoverProgram without command-line arguments
        MarsRoverProgram.main(new String[]{});

        // Getting the actual output from the program
        String actualOutput = outputStream.toString();

        // Comparing the actual output with the expected error message
        String expectedOutput = "Please specify the input file name.";
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}

