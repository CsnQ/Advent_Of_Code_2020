package Day9;

import Utilities.ReadFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class XmasCracker2Test {

    @Test
    public void addSequence() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker2 xc2 = new XmasCracker2(input,127L);
        List<Long> testValues = new ArrayList<>();
        testValues.add(35L);
        testValues.add(20L);
        testValues.add(15L);

        assertEquals(70L,xc2.addSequence(testValues));
    }

    @Test
    public void testReassignmentOfValues(){
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker2 xc2 = new XmasCracker2(input,127L);
        Long expected = 35L;
        Long expectedIteration = xc2.currentIteration.get(0);
        assertEquals(expected,expectedIteration );

        xc2.reAssignValues();

        expected = 20L;
        expectedIteration = xc2.currentIteration.get(0);
        assertEquals(expected,expectedIteration );
    }

    @Test
    public void testValidSequence(){
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day9/Day9TestInput.txt");
        XmasCracker2 xc2 = new XmasCracker2(input,127L);
        System.out.println(xc2.isValidSequence());
        assertEquals(false,xc2.isValidSequence());
        System.out.println(xc2.currentSequence);
    }
}