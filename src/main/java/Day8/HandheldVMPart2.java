package Day8;

import java.util.ArrayList;
import java.util.List;

public class HandheldVMPart2 {
    List<String> rawBootCode;
    int lengthOfRawDataList;
    List<String[]> processedData;
    List<String[]> copiedData;
    List<Integer> vistedInstructions;
    boolean hasRepeat;
    boolean reachedEnd;
    int accumulator;

    public HandheldVMPart2(List<String> rawBootCode) {
        this.rawBootCode = rawBootCode;
        this.lengthOfRawDataList = rawBootCode.size();
        this.processedData = new ArrayList<>();
        this.copiedData = processedData;
        this.accumulator = 0;
        this.vistedInstructions = new ArrayList<>();
        this.hasRepeat = false;
        this.reachedEnd = false;
        populateBootCodeList();
    }

    public void populateBootCodeList() {
        for (int i = 0; i < lengthOfRawDataList; i++) {
            String[] currentData = rawBootCode.get(i).split(" ");
            processedData.add(currentData);
        }
    }

    public boolean isRepeat(int currentIndex) {
        if (vistedInstructions.size() < 1) {
            return false;
        } else {
            for (int i = 0; i < vistedInstructions.size(); i++) {
                if (currentIndex == vistedInstructions.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasReachEnd(int nextIndex) {
        if (nextIndex > processedData.size()) {
            return true;
        } else {
            return false;
        }
    }

    public String[] getSteps(String executionStep) {

        char increment = executionStep.charAt(0);
        String result = executionStep.substring(executionStep.indexOf(increment) + 1);
        String[] steps = new String[]{String.valueOf(increment), result};
        return steps;
    }


    public void executeBootCodeForPart2(List<String[]> data) {
        int currentIndex = 0;
        while (!hasRepeat || !reachedEnd) {
            String[] currentInstruction = data.get(currentIndex);
            switch (currentInstruction[0]) {
                case ("nop"):
                    if (isRepeat(currentIndex)){
                        hasRepeat=true;
                    }else{
                        vistedInstructions.add(currentIndex);
                            if (hasReachEnd(currentIndex++)){
                                reachedEnd=true;
                            }
                        }

                    break;

                case ("acc"):
                  //do stuff


                case ("jmp"):
                   //do stuff
            }
        }

    }
}

