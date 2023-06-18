import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;


public class MarsRoverProgramTest {

    @Mock
    private File inputFile;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMarsRoverProgram() throws Exception {

        // Redirection de System.out pour capturer la sortie du programme (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Exécution du programme MarsRoverProgram en passant en parametre fichier de test
        MarsRoverProgram.main(new String[]{"src/test/resources/input.txt"});

        // Restauration de System.out
        System.setOut(System.out);

        // Récupération de la sortie réelle du programme
        String actualOutput = outputStream.toString().trim();

        // Comparaison de la sortie réelle avec la sortie attendue
        String expectedOutput = "1 3 N\n5 1 E";

        // Résolution du problème d'encodage
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMain_NoInputFile() {
        // Redirection de System.out pour capturer la sortie du programme (System.out.println)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Exécution du programme MarsRoverProgram sans arguments de ligne de commande
        MarsRoverProgram.main(new String[]{});

        // Restauration de System.out
        System.setOut(System.out);

        // Récupération de la sortie réelle du programme
        String actualOutput = outputStream.toString().trim();

        // Comparaison de la sortie réelle avec le message d'erreur attendu
        String expectedOutput = "Veuillez spécifier le nom du fichier d'entrée.";
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}

