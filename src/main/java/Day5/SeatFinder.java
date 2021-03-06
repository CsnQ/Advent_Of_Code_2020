package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeatFinder {
    //128 seats
    //10 characters
    int numOfRows = 128;
    int numOfSeats = 8;
    List<Integer> allRows;
    List<Integer> allSeats;
    String input;
    String rowData;
    String seatData;
    List<Integer> rowInput;
    List<Integer> seatInput;
    int myRow;
    int mySeat;
    HashMap<String, Integer> seatInfo;


    public SeatFinder(String input) {
        this.input = input;
        this.seatData = input.substring(input.length() - 3);
        this.rowData = input.substring(0, 7);
        this.rowInput = transformData(rowData, 'F', 'B');
        this.seatInput = transformData(seatData, 'L', 'R');
        this.allRows = populateAllSeatsOrRows(numOfRows);
        this.allSeats = populateAllSeatsOrRows(numOfSeats);
        this.myRow = getMyRowOrSeat(this.rowInput,this.allRows);
        this.mySeat = getMyRowOrSeat(this.seatInput,this.allSeats);
        this.seatInfo = new HashMap<>();
        this.seatInfo.put("row", getMyRow());
        this.seatInfo.put("column", getMySeat());
        this.seatInfo.put("seat number", getMyRow()*8 + getMySeat());
    }

    public HashMap<String, Integer> getSeatInfo() {
        return seatInfo;
    }

    public List<Integer> transformData(String data, char firstLetter, char secondLetter) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == firstLetter) {
                input.add(0);
            } else if (data.charAt(i) == secondLetter) {
                input.add(1);
            }
        }

        return input;
    }

    public List<Integer> populateAllSeatsOrRows(int numOfSeatsOrRows) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < numOfSeatsOrRows; i++) {
            data.add(i);
        }

        return data;
    }

    public int getMyRowOrSeat(List<Integer> convertedInstructions,List <Integer> rowOrSeatData) {
        List<Integer> reducedList;
        List<Integer> rows = rowOrSeatData;
        while (rows.size()!=1){
        for (int i = 0; i < convertedInstructions.size(); i++) {
            switch (convertedInstructions.get(i)){
                case(0):
                    reducedList=rows.subList(0,rows.size()/2);
                    rows = reducedList;
                    break;

                case(1):
                    reducedList = rows.subList(rows.size()/2,rows.size());
                    rows=reducedList;
                    break;
            }
        }
        }
        return rows.get(0);

    }

    public String getRowData() {
        return rowData;
    }

    public String getSeatData() {
        return seatData;
    }

    public List<Integer> getAllRows() {
        return allRows;
    }

    public List<Integer> getAllSeats() {
        return allSeats;
    }

    public int getMyRow() {
        return myRow;
    }

    public int getMySeat() {
        return mySeat;
    }

    public int getSeatNumberFromMap(){
        return this.seatInfo.get("seat number");
    }

    @Override
    public String toString() {
        return "SeatFinder{" +
                "rowInput=" + rowInput +
                ", seatInput=" + seatInput +
                '}';
    }
}
