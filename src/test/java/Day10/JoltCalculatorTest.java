package Day10;

import Utilities.ReadFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class JoltCalculatorTest {

    @Test
    public void getSortedInput() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10TestInput.txt");
        JoltCalculator jc = new JoltCalculator(input);
        List<Long> sortedlist = jc.getSortedInput();
        Long result1 = sortedlist.get(0);
        Long result2 = sortedlist.get(1);
        Long result3 = sortedlist.get(2);
        Long result4 = sortedlist.get(10);

        assertEquals(Long.valueOf(1L), result1);
        assertEquals(Long.valueOf(4L), result2);
        assertEquals(Long.valueOf(5L), result3);
        assertEquals(Long.valueOf(19L), result4);

        System.out.println(sortedlist);
    }

    // will take the sorted list and map the differences and count. i.e
    // for test data key 1 will have 7 (7 differences of 1) and 3 will have 5 (5 differences of 3)
    @Test
    public void testDifferenceMapHasRightKeys() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10TestInput.txt");
        JoltCalculator jc = new JoltCalculator(input);
        HashMap<Long, Long> result = jc.countDifferences();
        List<Long> keys = new ArrayList(result.keySet());
        assertEquals(2, keys.size());
        assertEquals(Long.valueOf(1L), keys.get(0));
        assertEquals(Long.valueOf(3L), keys.get(1));
    }

    @Test
    public void testDifferenceMapHasRightvalues() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10TestInput.txt");
        JoltCalculator jc = new JoltCalculator(input);
        HashMap<Long, Long> result = jc.countDifferences();
        assertEquals(Long.valueOf(7L), result.get(1L));
        assertEquals(Long.valueOf(5L), result.get(3L));
    }

    @Test
    public void testDifferenceMapHasRightvaluesForTestData2() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10TestInput2.txt");
        JoltCalculator jc = new JoltCalculator(input);
        HashMap<Long, Long> result = jc.countDifferences();
        assertEquals(Long.valueOf(22L), result.get(1L));
        assertEquals(Long.valueOf(10L), result.get(3L));
    }

    @Test
    public void testCalculationForPart1withTestData() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10TestInput2.txt");
        JoltCalculator jc = new JoltCalculator(input);
        Long result = jc.calculatePart1Answer();
        assertEquals(Long.valueOf(220L),result);
    }

    @Test
    public void testCalculationForPart1withRealData() {
        List<Long> input = ReadFile.readLinesFromFileAsLong("src/main/java/Day10/Day10Input.txt");
        JoltCalculator jc = new JoltCalculator(input);
        Long result = jc.calculatePart1Answer();
        assertEquals(Long.valueOf(2432L),result);
    }

}