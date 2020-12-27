package Day11;

import Utilities.ReadFile;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SeatMapperTest {

    @Test
    public void getRawInput() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day11/Day11TestInput.txt");
        String expected1 = "L.LL.LL.LL";
        String expected2 = "LLLLLLL.LL";
        assertEquals(expected1,input.get(0));
        assertEquals(expected2,input.get(1));
    }
}