package Day3;

import Utilities.ReadFile;
import junit.framework.TestCase;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MapReaderTest extends TestCase {

    public void testObjectCreationForMapReader() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day3/Day3TestInput");
        MapReader mr = new MapReader(data);
        String result = mr.getARow(0);
        assertEquals("..##.........##.........##.........##.........##.........##.......", result);
    }

    public void testJourneyDataWithTestInput() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day3/Day3TestInput");
        MapReader mr = new MapReader(data);
        int result = mr.getJourneyData(0, 0, 3, 1);
        assertEquals(7, result);
    }


    public void testJourneyDataWithRealInput() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day3/Day3Input.txt");
        MapReader mr = new MapReader(data);
        int result = mr.getJourneyData(0, 0, 3, 1);
        System.out.println(result);
    }


}