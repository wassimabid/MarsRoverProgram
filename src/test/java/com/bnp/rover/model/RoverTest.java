package com.bnp.rover.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoverTest {
    @ParameterizedTest
    @CsvSource({
            "1, 2, N, LMLMLMLMM, 1 3 N",
            "3, 3, E, MMRMMRMRRM, 5 1 E",
    })
    void testProcessInstructions(int startX, int startY, Direction startDirection, String instructions, String expectedPosition) {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(startX, startY, startDirection, plateau);

        rover.processInstructions(instructions);
        Assertions.assertEquals(expectedPosition, rover.getPosition());
    }
}
