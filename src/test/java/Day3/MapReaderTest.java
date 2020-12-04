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
        assertEquals(187, result);
    }

    public void testJourneyDataWithTestDataForPart2() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day3/Day3TestInput");
        MapReader mr = new MapReader(data);
        int check1 = mr.getJourneyData(0, 0, 1, 1);
        int check2 = mr.getJourneyData(0, 0, 3, 1);
        int check3 = mr.getJourneyData(0, 0, 5, 1);
        int check4 = mr.getJourneyData(0, 0, 7, 1);
        int check5 = mr.getJourneyData(0, 0, 1, 2);
        System.out.println(check1);
        assertEquals(2, check1);
        assertEquals(7, check2);
        assertEquals(3, check3);
        assertEquals(4, check4);
        assertEquals(2, check5);
        assertEquals(336,check1*check2*check3*check4*check5 );

    }

    //428316104 is too low
    //was too low because I had classed this as an Int and so at 32 bit there was overflow

    public void testJourneyDataWithRealDataForPart2() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day3/Day3Input.txt");
        MapReader mr = new MapReader(data);
        long check1 = mr.getJourneyData(0, 0, 1, 1);
        long check2 = mr.getJourneyData(0, 0, 3, 1);
        long check3 = mr.getJourneyData(0, 0, 5, 1);
        long check4 = mr.getJourneyData(0, 0, 7, 1);
        long check5 = mr.getJourneyData(0, 0, 1, 2);
        long result = check1*check2*check3*check4*check5;
        System.out.println(result);

    }

}