package Day5;

import junit.framework.TestCase;

import static org.junit.Assert.*;

public class SeatFinderTest extends TestCase {

    public void testSeatFinderObjectSplitsString() {
        String data = "FBFBBFFRLR";
        SeatFinder sf = new SeatFinder(data);
        assertEquals("FBFBBFF", sf.getRowData());
        assertEquals("RLR", sf.getSeatData());
        assertEquals("SeatFinder{rowInput=[0, 1, 0, 1, 1, 0, 0], seatInput=[1, 0, 1]}", sf.toString());
    }


}