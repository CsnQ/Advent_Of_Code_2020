package Day9;

import java.util.List;

public class XmasCracker {
    List<Long> rawInput;
    List<Long> preamble;
    List<Long> postAmble;
    int preAmbleLength;
    Long currentNum;
    int preAmbleStartIndex;
    int getPreAmbleEndIndex;
    int startingIndex;

    public void splitList(){
        this.preamble= rawInput.subList(preAmbleStartIndex,getPreAmbleEndIndex);
        this.postAmble = rawInput.subList(preAmbleLength,rawInput.size());
        this.currentNum= rawInput.get(getPreAmbleEndIndex+1);
    }

    public XmasCracker(List<Long> rawInput, int preAmbleLength) {
        this.rawInput = rawInput;
        this.preAmbleStartIndex=0;
        this.getPreAmbleEndIndex = preAmbleLength-1;
        this.preAmbleLength = preAmbleLength;
        this.startingIndex=preAmbleLength;
        splitList();
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public List<Long> getPreamble() {
        return preamble;
    }

    public List<Long> getPostAmble() {
        return postAmble;
    }

    public Long getCurrentNum() {
        return currentNum;
    }

    //shifts my list along to look at the new values;
    public void reAssignValues(){
        this.preAmbleStartIndex=preAmbleStartIndex+1;
        this.getPreAmbleEndIndex=getPreAmbleEndIndex+1;
        splitList();
    }

    //checks if currentNum is sum of one of the numbers in the preamble list
    public boolean numIsSumOfNumInList(){
        for (int i = 0; i < this.preamble.size() ; i++) {
            for (int j = 0; j < this.preamble.size(); j++) {
                //shouldn't be checking the same values
                if (i!=j){
                   Long result = this.preamble.get(i)+this.preamble.get(j);
                    if (result.equals(this.currentNum)){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public Long findWeaknessInSystem(){
        boolean numFound = false;
        int numberOfTries = rawInput.size()-preAmbleLength;
        while (!numFound){
            for (int i = 0; i < numberOfTries; i++) {
                if (numIsSumOfNumInList()==false){
                    numFound = true;
                    return getCurrentNum();
                }else{
                    reAssignValues();
                }
            }
        }
        return 0l;
    }



}
