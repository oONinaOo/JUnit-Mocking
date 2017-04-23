import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
    @Test
    public void testWordsByAbc() throws MyExceptions{
        try {
            Mocking getMocked = new Mocking("valami", 1, 3);
            FileWordAnalyzer fwa = new FileWordAnalyzer(getMocked);
            ArrayList<String> result = fwa.wordsByABC();

            fwa = mock(FileWordAnalyzer.class);
            when(fwa.wordsByABC()).thenReturn(result);

            String getResultString = "";
            for(String letter: result){
                getResultString += letter + ", ";
            }

            String expected = "elvileg!, fog, most, valamire, változni, ";

            assertEquals(expected, getResultString);

        } catch (Exception e) {
            throw new MyExceptions("Text does not match or not even the correct order!");
        }
    }

    @Test
    public void testWordsContainingSubString() throws MyExceptions {
        try{

            Mocking getMocked = new Mocking("valami", 1, 3);
            FileWordAnalyzer fwa = new FileWordAnalyzer(getMocked);
            String subs = "valami";
            ArrayList<String> result = fwa.wordsContainingSubString(subs);

            fwa = mock(FileWordAnalyzer.class);
            when(fwa.wordsContainingSubString(subs)).thenReturn(result);

            String getResultString = "";
            for(String letter: result){
                getResultString += letter + ", ";
            }

            String expected = "valamire, ";

            assertEquals(expected, getResultString);

        } catch (Exception e) {
            throw new MyExceptions("Text does not contain this substring");
        }
    }

}
