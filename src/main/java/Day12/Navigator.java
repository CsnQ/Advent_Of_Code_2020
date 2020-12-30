package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Navigator {
    List<String> rawInput;
    char shipOrientation;
    HashMap<Character, Integer> navCalculator;

    public Navigator(List<String> rawInput) {
        this.rawInput = rawInput;
        this.shipOrientation = 'E';
        this.navCalculator = new HashMap<>();
        initialiseShipCalculator();
    }

    private void initialiseShipCalculator() {
        navCalculator.put('N', 0);
        navCalculator.put('E', 0);
        navCalculator.put('S', 0);
        navCalculator.put('W', 0);
    }

    public HashMap<Character, Integer> getNavCalculator() {
        return navCalculator;
    }

    public void steerShip() {
        for (int i = 0; i < rawInput.size(); i++) {
            char direction = rawInput.get(i).charAt(0);
            int moves = Integer.parseInt(rawInput.get(i).substring(1));
            switch (direction) {
                case 'F':
                    navCalculator.put(shipOrientation, navCalculator.get(shipOrientation) + moves);
                    break;
                case 'N':
                    navCalculator.put('N', navCalculator.get('N') + moves);
                    break;
                case 'S':
                    navCalculator.put('S', navCalculator.get('S') + moves);
                    break;
                case 'E':
                    navCalculator.put('E', navCalculator.get('E') + moves);
                    break;
                case 'W':
                    navCalculator.put('W', navCalculator.get('W') + moves);
                    break;
                case 'R':
                    rotateShip('R', moves);
                    break;
            }
        }
    }

    public void rotateShip(char direction, int degrees) {
        int clockwiseOrAntiClockwise = 0;
        //1=moveToRight90Degrees
        //2=moveToRight180

        if (degrees == 90 && direction == 'R') {
            clockwiseOrAntiClockwise = 1;
        } else if (degrees == 180 && direction == 'R') {
            clockwiseOrAntiClockwise = 2;
        } else if (degrees == 90 && direction == 'L') {
            clockwiseOrAntiClockwise = -1;
        } else if (degrees == 180 && direction == 'L') {
            clockwiseOrAntiClockwise = 2;
        }

        switch (clockwiseOrAntiClockwise) {
            case (1):
                switch (shipOrientation) {
                    case ('N'):
                        shipOrientation = 'E';
                        break;
                    case ('E'):
                        shipOrientation = 'S';
                        break;
                    case ('S'):
                        shipOrientation = 'W';
                        break;
                    case ('W'):
                        shipOrientation = 'N';
                        break;
                }
                break;
            case (2):
                switch (shipOrientation) {
                    case ('N'):
                        shipOrientation = 'S';
                        break;
                    case ('E'):
                        shipOrientation = 'W';
                        break;
                    case ('S'):
                        shipOrientation = 'N';
                        break;
                    case ('W'):
                        shipOrientation = 'E';
                        break;
                }
                break;
            case (-1):
                switch (shipOrientation) {
                    case ('N'):
                        shipOrientation = 'W';
                        break;
                    case ('E'):
                        shipOrientation = 'N';
                        break;
                    case ('S'):
                        shipOrientation = 'E';
                        break;
                    case ('W'):
                        shipOrientation = 'S';
                        break;
                }
                break;
        }

    }

    public char getShipOrientation() {
        return shipOrientation;
    }
}
