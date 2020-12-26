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
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/miniInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        assertEquals(true, xc.numIsSumOfNumInList());
    }

    @Test
    public void numIsSumOfNumInListFalse() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/miniInput2.txt");
        XmasCracker xc = new XmasCracker(input,5);
        assertEquals(false, xc.numIsSumOfNumInList());
    }

    @Test
    public void preAmbleAndPostAmble(){
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/miniInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        List<Long> preAmble = xc.getPreamble();
        List<Long> postAmble = xc.getPostAmble();
        long number = xc.getCurrentNum();

        assertEquals(4, preAmble.size());
        assertEquals(1,postAmble.size() );
        assertEquals(40L,number);
        assertEquals(5,xc.getStartingIndex());
    }

    @Test
    public void testReAssignValues(){
        List<Long>input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        List<Long> preAmble = xc.getPreamble();
        List<Long> postAmble = xc.getPostAmble();
        long number = xc.getCurrentNum();

        assertEquals(4, preAmble.size());
        assertEquals(40L,number);

        xc.reAssignValues();

        preAmble=xc.getPreamble();
        long firstNum = preAmble.get(0);
        long currentNum = xc.getCurrentNum();
        assertEquals(4,preAmble.size());
        assertEquals(20, firstNum);
        assertEquals(62,currentNum);
    }

    @Test
    public void findWeaknessInTestData() {
        List<Long>input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        long result = xc.findWeaknessInSystem();
        assertEquals(127,result);
    }

    @Test
    public void findWeaknessInRealData(){
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker xc = new XmasCracker(input,5);
        long result = xc.findWeaknessInSystem();
    }
}