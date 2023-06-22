package com.bnp.rover.utils;

import com.bnp.rover.model.Direction;
import com.bnp.rover.model.Instruction;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.Rover;
import com.bnp.rover.utils.RoverUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverUtilityTest {

    @Test
    void testParseInstructions() {
        String instructions = "LMLMLMLMM";
        Instruction[] expectedInstructions = {
                Instruction.L, Instruction.M, Instruction.L, Instruction.M,
                Instruction.L, Instruction.M, Instruction.L, Instruction.M,
                Instruction.M
        };

        Instruction[] parsedInstructions = RoverUtility.parseInstructions(instructions);
        Assertions.assertArrayEquals(expectedInstructions, parsedInstructions);
    }

    @Test
    void testApplyInstruction_turnLeft() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);

        RoverUtility.applyInstruction(Instruction.L, rover);
        Assertions.assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void testApplyInstruction_turnRight() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);

        RoverUtility.applyInstruction(Instruction.R, rover);
        Assertions.assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void testApplyInstruction_moveForward() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.N, plateau);

        RoverUtility.applyInstruction(Instruction.M, rover);
        Assertions.assertEquals(1, rover.getX());
        Assertions.assertEquals(3, rover.getY());
    }
}
