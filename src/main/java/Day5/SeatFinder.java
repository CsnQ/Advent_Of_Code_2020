package Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeatFinder {
    //128 seats
    //10 characters
    int[] frontRowRange = new int[]{0, 63};
    int[] backRowRange = new int[]{64, 127};
    String input;
    String rowData;
    String seatData;
    List<Integer> rowInput;
    List<Integer> seatInput;


    public SeatFinder(String input) {
        this.input = input;
        this.seatData = input.substring(input.length() - 3);
        this.rowData = input.substring(0, 7);
        this.rowInput = transformData(rowData,'F','B' );
        this.seatInput = transformData(seatData, 'L','R');
    }

    public List<Integer> transformData(String data, char firstLetter, char secondLetter) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i)==firstLetter){
                input.add(0);
            }else if (data.charAt(i)==secondLetter){
                input.add(1);
            }
        }

        return input;
    }

    public String getRowData() {
        return rowData;
    }

    public String getSeatData() {
        return seatData;
    }

    public List<Integer> getRowInput() {
        return rowInput;
    }

    public List<Integer> getSeatInput() {
        return seatInput;
    }

    @Override
    public String toString() {
        return "SeatFinder{" +
                "rowInput=" + rowInput +
                ", seatInput=" + seatInput +
                '}';
    }
}
