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
    public void checkShipOrientationAntiClockwise() {
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

    @Test
    public void checkSteerShip() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12TestInput.txt");
        Navigator nav = new Navigator(input);
        int n = 3;
        int w = 0;
        int e = 17;
        int s = 11;

        HashMap<Character, Integer> navCalc = nav.getNavCalculator();

        int shipN = navCalc.get('N');
        int shipW = navCalc.get('W');
        int shipE = navCalc.get('E');
        int shipS = navCalc.get('S');


        assertEquals(n, shipN);
        assertEquals(w, shipW);
        assertEquals(e, shipE);
        assertEquals(s, shipS);

    }

    @Test
    public void checkPart1WithTestData() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12TestInput.txt");
        Navigator nav = new Navigator(input);
        int expectedResult = 25;
        assertEquals(expectedResult, nav.calculatePart1Answer());
    }

    //460 too low
    @Test
    public void checkPart1WithRealData() {
        List<String> input = ReadFile.readLinesFromFile("src/main/java/Day12/Day12Input.txt");
        Navigator nav = new Navigator(input);
        int expectedResult = 25;
        System.out.println(nav.calculatePart1Answer());
    }

}