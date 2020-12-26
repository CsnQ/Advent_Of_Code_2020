package Day9;

import Utilities.ReadFile;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class XmasCrackerTest {

    @Test
    public void numIsSumOfNumInList() {
        List<Integer> input = ReadFile.readLinesFromFileAsInt("src/main/java/Day9/miniInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        assertEquals(true, xc.numIsSumOfNumInList(xc.getCurrentNum(), xc.getPreamble()));
    }

    @Test
    public void numIsSumOfNumInListFalse() {
        List<Integer> input = ReadFile.readLinesFromFileAsInt("src/main/java/Day9/miniInput2.txt");
        XmasCracker xc = new XmasCracker(input,5);
        assertEquals(false, xc.numIsSumOfNumInList(xc.getCurrentNum(), xc.getPreamble()));
    }

    @Test
    public void preAmbleAndPostAmble(){
        List<Integer> input = ReadFile.readLinesFromFileAsInt("src/main/java/Day9/miniInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        List<Integer> preAmble = xc.getPreamble();
        List<Integer> postAmble = xc.getPostAmble();
        int number = xc.getCurrentNum();

        assertEquals(4, preAmble.size());
        assertEquals(1,postAmble.size() );
        assertEquals(40,number);
    }
}