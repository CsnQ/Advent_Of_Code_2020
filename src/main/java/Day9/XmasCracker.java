package Day9;

import java.util.List;

public class XmasCracker {
    List<Integer> rawInput;
    List<Integer> preamble;
    List<Integer> postAmble;
    int preAmbleLength;
    int currentNum;

    public void splitList(){
        this.preamble= rawInput.subList(0, preAmbleLength-1);
        this.postAmble = rawInput.subList(5,rawInput.size());
        currentNum=postAmble.get(0);
    }

    public XmasCracker(List<Integer> rawInput, int preAmbleLength) {
        this.rawInput = rawInput;
        this.preAmbleLength = preAmbleLength;
        splitList();
    }

    public List<Integer> getPreamble() {
        return preamble;
    }

    public List<Integer> getPostAmble() {
        return postAmble;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public boolean numIsSumOfNumInList(int numToCheck, List<Integer> precedingValues){
        for (int i = 0; i < precedingValues.size() ; i++) {
            for (int j = 0; j < precedingValues.size(); j++) {
                //shouldn't be checking the same values
                if (i!=j){
                   int result = precedingValues.get(i)+precedingValues.get(j);
                    if (result==numToCheck){
                        return true;
                    }
                }
            }
        }

        return false;

    }
}
