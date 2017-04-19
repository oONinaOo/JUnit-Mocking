import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class UnitTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testValidPath() throws MyExceptions {
        try {
            new FilePartReader("src/text.txt", 2, 2).readLines();

        } catch (Exception e) {
            throw new MyExceptions("No such file!");
        }
    }

    @Test
    public void testPath() throws MyExceptions {
        try {
            new FilePartReader("src/dontknowwhat.txt", 1, 2).readLines();

        } catch (Exception e) {
            throw new MyExceptions("No such file!");
        }
    }

    @Test
    public void testRowNumber1() throws MyExceptions {
        try {
            new FilePartReader("src/text.txt", 1, 20).readLines();

        } catch (Exception e) {
            throw new MyExceptions("Line numbers out of range!");
        }
    }

    @Test
    public void testRowNumber2() throws MyExceptions {
        try {
            new FilePartReader("src/text.txt", 0, 3).readLines();

        } catch (Exception e) {
            throw new MyExceptions("Line numbers out of range!");
        }
    }

    @Test
    public void testReadLine1() throws MyExceptions {
        try {
            String result = new FilePartReader("src/text.txt", 1, 3).readLines();
            result = result.replaceAll("\n", "");
            String fileContent = "Ez egy teszt fajl Irunk ide csak hogy legyen valami Legyen mostmar eleg ";
            assertEquals(fileContent, result);
        } catch (Exception e) {
            throw new MyExceptions("Text does not match!");
        }

    }

    @Test
    public void testReadLine2() throws MyExceptions {
        try {
            String result = new FilePartReader("src/text.txt", 1, 2).readLines();
            result = result.replaceAll("\n", "");
            String fileContent = "Ez egy teszt fajl Irunk ide csak hogy legyen valami ";
            assertEquals(fileContent, result);
        } catch (Exception e) {
            throw new MyExceptions("Text does not match!");
        }

    }

    @Test
    public void testReadLine3() throws MyExceptions {
        try {
            String result = new FilePartReader("src/text.txt", 3, 3).readLines();
            result = result.replaceAll("\n", "");
            String fileContent = "Legyen mostmar eleg ";
            assertEquals(fileContent, result);
        } catch (Exception e) {
            throw new MyExceptions("Text does not match!");
        }

    }
    @Test
    public void testReadLine4() throws MyExceptions {
        try {
            String result = new FilePartReader("src/text.txt", 2, 3).readLines();
            result = result.replaceAll("\n", "");
            String fileContent = "Totalisan nem ez van amugy benne";
            assertEquals(fileContent, result);
        } catch (Exception e) {
            throw new MyExceptions("Text does not match!");
        }

    }


}
