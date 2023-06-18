import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverTest {
    private Plateau plateau;
    private Rover rover;


    @ParameterizedTest
    @CsvSource({ "LMLMLMLMM, 1, 2, N, 1, 3, N", "MMRMMRMRRM, 3, 3, E, 5, 1, E", "LLRRMMRRLL, 2, 1, S, 2, 0, S" })
    public void testProcessInstructions(String instructions, int initialX, int initialY, char initialDirection, int finalX, int finalY, char finalDirection) {
        Rover rover = new Rover(initialX, initialY, initialDirection, new Plateau(5, 5));
        rover.processInstructions(instructions);
        Assertions.assertEquals(finalX + " " + finalY + " " + finalDirection, rover.getPosition());
    }
}
