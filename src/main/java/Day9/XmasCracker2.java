package Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class XmasCracker2 {
    List<Long> rawInput;
    List<Long> currentIteration;
    List<Long> currentSequence;
    Long expectedNumber;
    int currentStartIndex;

    public XmasCracker2(List<Long> rawInput, Long expectedNumber) {
        this.rawInput = rawInput;
        this.expectedNumber = expectedNumber;
        this.currentIteration = rawInput;
        this.currentSequence = new ArrayList<>();
        this.currentStartIndex=0;
    }

    public void reAssignValues(){
        this.currentStartIndex=currentStartIndex+1;
        this.currentIteration = rawInput.subList(currentStartIndex,rawInput.size());
        this.currentSequence = new ArrayList<>();
    }

    public long addSequence(List<Long> currentSequence) {
        long result = currentSequence.stream().reduce(0L, (a, b) -> a + b);
        return result;
    }

    public boolean isValidSequence(){
        long currentTotal = 0;
        currentSequence.add(currentIteration.get(0));
        for (int i = 1; i <currentIteration.size() ; i++) {
            currentSequence.add(currentIteration.get(i));
            if (currentSequence.size()>2){
                 currentTotal = addSequence(currentSequence);
                if (currentTotal>expectedNumber){
                    return false;
                }else if(currentTotal==expectedNumber){
                    return true;
                }
            }

        }
        return false;
    }

    public List<Long> findSequence (){

        while (true){
            if (!isValidSequence()){
                isValidSequence();
                reAssignValues();
            }else{
                return currentSequence;
            }

        }

    }



}


