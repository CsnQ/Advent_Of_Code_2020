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

        SeatMapper seat = new SeatMapper(input);
        List<String> result = seat.getInput();
        assertEquals(expected1,result.get(0));
        assertEquals(expected2,result.get(1));
    }




}