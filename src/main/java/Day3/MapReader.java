package Day3;

import Utilities.ReadFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapReader {
    List<String> mapRows;
    char tree = '#';
    char ground = '.';

    public MapReader(List<String> mapRows) {
        this.mapRows = mapRows;
    }

    public List<String> getMapRows() {
        return mapRows;
    }

    public String getARow(int rowNum) {
        return mapRows.get(rowNum);
    }

    public int getJourneyData(int startrow, int startposition, int latMove, int vertMove) {
        int treeCount = 0;
        int latposition = latMove;
        int width = mapRows.get(0).length();
        System.out.println("size of list: "+ mapRows.size());

        for (int i = startposition + vertMove; i < mapRows.size(); i = i + vertMove) {
//            System.out.println("current row: "+ i);
            char currentChar = mapRows.get(i).charAt(latposition);
//            System.out.println("current latPosition: "+ latposition);
            if (currentChar == tree) {
                treeCount++;
            }
            latposition = latposition + latMove;

            if (latposition >= width) {
                latposition = latposition - width;
            }


        }

        System.out.println("number of trees: "+treeCount);
        return treeCount;
    }
}
