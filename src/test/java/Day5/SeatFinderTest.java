package Day5;

import Utilities.ReadFile;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SeatFinderTest extends TestCase {

    public void testSeatFinderObjectSplitsString() {
        String data = "FBFBBFFRLR";
        SeatFinder sf = new SeatFinder(data);
        assertEquals("FBFBBFF", sf.getRowData());
        assertEquals("RLR", sf.getSeatData());
        assertEquals("SeatFinder{rowInput=[0, 1, 0, 1, 1, 0, 0], seatInput=[1, 0, 1]}", sf.toString());
        assertEquals(128, sf.getAllRows().size());
        assertEquals(8, sf.getAllSeats().size());
    }


    public void testSeatFinderWithOneBitOfData() {
        String data = "FBFBBFFRLR";
        SeatFinder sf = new SeatFinder(data);
        int resultForRow = sf.getMyRow();
        int resultForSeat = sf.getMySeat();
        int answer = resultForRow * 8 + resultForSeat;
        assertEquals(44, resultForRow);
        assertEquals(5, resultForSeat);
        assertEquals(357, answer);
    }

    public void testSeatFinderGetAnswerForTestData() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day5/Day5TestInput.txt");
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            SeatFinder sf = new SeatFinder(data.get(i));
            int resultForRow = sf.getMyRow();
            int resultForSeat = sf.getMySeat();
            int answer = resultForRow * 8 + resultForSeat;
            answers.add(answer);
        }
        int maxSeatId = Collections.max(answers);
        System.out.println(maxSeatId);
        assertTrue(answers.get(0)==567);
        assertTrue(answers.get(1)==119);
        assertTrue(answers.get(2)==820);
    }



    public void testSeatFinderGetAnswerForRealData() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day5/Day5Input.txt");
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            SeatFinder sf = new SeatFinder(data.get(i));
            int resultForRow = sf.getMyRow();
            int resultForSeat = sf.getMySeat();
            int answer = resultForRow * 8 + resultForSeat;
            answers.add(answer);
        }
        int maxSeatId = Collections.max(answers);
        System.out.println(maxSeatId);

    }

    public void testSeatFinderHashMap() {
        String data = "FBFBBFFRLR";
       SeatFinder sf = new SeatFinder(data);
        HashMap<String, Integer> answers = sf.getSeatInfo();
        assertEquals(44, ((int) answers.get("row")));
        assertEquals(5, ((int) answers.get("column")));
        assertEquals(357, ((int) answers.get("seat number")));

    }


    public void testSeatFinderHashMapListForPart2Answer() {
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day5/Day5Input.txt");
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            SeatFinder sf = new SeatFinder(data.get(i));
            answers.add(sf.getSeatNumberFromMap());
        }
        int maxSeatId = Collections.max(answers);
        Collections.sort(answers);

        for (int i = 0; i < answers.size()-1; i++) {
            //System.out.println(answers.get(i));
            if (answers.get(i+1)- answers.get(i)!=1){
                System.out.println("*******************");
                System.out.println(answers.get(i));
                System.out.println(answers.get(i+1));
                System.out.println("My Seat Number is: " + (answers.get(i)+1));
                System.out.println("*******************");
            }

        }
        System.out.println(answers);
    }


}