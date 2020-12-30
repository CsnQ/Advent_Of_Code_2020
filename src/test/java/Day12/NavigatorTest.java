package Day12;

import Utilities.ReadFile;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class NavigatorTest {

    @Test
    public void testInitialiseShipCalculator() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12TestInput.txt");
        Navigator nav = new Navigator(input);
        HashMap<Character, Integer> result = nav.getNavCalculator();
        int north = result.get('N');
        assertEquals(0, north);
    }

    @Test
    public void checkShipOrientationClockWise() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12TestInput.txt");
        Navigator nav = new Navigator(input);
        assertEquals('E', nav.getShipOrientation());

        nav.rotateShip('R', 90);
        assertEquals('S', nav.getShipOrientation());

        nav.rotateShip('R', 90);
        assertEquals('W', nav.getShipOrientation());

        nav.rotateShip('R', 180);
        assertEquals('E', nav.getShipOrientation());

    }

    @Test
    public void checkShipOrientationAntiClock() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12TestInput.txt");
        Navigator nav = new Navigator(input);
        assertEquals('E', nav.getShipOrientation());

        nav.rotateShip('L', 90);
        assertEquals('N', nav.getShipOrientation());

        nav.rotateShip('L', 90);
        assertEquals('W', nav.getShipOrientation());

        nav.rotateShip('L', 180);
        assertEquals('E', nav.getShipOrientation());

    }


}