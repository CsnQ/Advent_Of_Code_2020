package Day11;

import java.util.ArrayList;
import java.util.List;

//a given seat (one of the eight positions immediately up, down, left, right, or diagonal from the seat). The following rules are applied to every seat simultaneously:
//
//        If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
//        If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
//        Otherwise, the seat's state does not change.

//
//        #.##.##.##
//        #######.##
//        #.#.#..#..
//        ####.##.##
//        #.##.##.##
//        #.#####.##
//        ..#.#.....
//        ##########
//        #.######.#
//        #.#####.##

//        #.LL.L#.##
//        #LLLLLL.L#
//        L.L.L..L..
//        #LLL.LL.L#
//        #.LL.LL.LL
//        #.LLLL#.##
//        ..L.L.....
//        #LLLLLLLL#
//        #.LLLLLL.L
//        #.#LLLL.##

//TODO finish the darn puzzle!
public class SeatMapper {
    List<String> input;
    List<String> currentIteration;
    List<List> iterations;
    final char emptySeat = 'L';
    final char occupiedSeat = '#';
    final char floor = '.';

    public SeatMapper(List<String> input) {
        this.input = input;
        this.currentIteration = input;
        iterations.add(currentIteration);
    }

    public boolean SeatingAreaIsEmpty() {
        int seatCounter = 0;
        for (int i = 0; i < currentIteration.size(); i++) {
            if (currentIteration.get(i).contains("#")) {
                seatCounter++;
            }
        }

        if (seatCounter == 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> fillSeatingArea(){
        List<String> newSeating = new ArrayList<>();
        for (int i = 0; i < currentIteration.size(); i++) {
           String seatingChange = currentIteration.get(i).replace(emptySeat,occupiedSeat);
           newSeating.add(seatingChange);

        }
        return newSeating;
    }

    public void goThroughIterations(){
        if (SeatingAreaIsEmpty()){
            currentIteration=fillSeatingArea();
            iterations.add(currentIteration);
        }
    }

    public List<String> getInput() {
        return input;
    }
}
