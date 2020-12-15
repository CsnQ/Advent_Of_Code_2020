package Day8;


import java.util.ArrayList;
import java.util.List;

public class HandheldVM {
    List<String> rawBootCode;
    int lengthOfRawDataList;
    List<String[]> processedData;
    int accumulator;


    public HandheldVM(List<String> rawBootCode) {
        this.rawBootCode = rawBootCode;
        this.lengthOfRawDataList = rawBootCode.size();
        this.processedData = new ArrayList<>();
        this.accumulator = 0;
        populateBootCodeList();
    }

    public void populateBootCodeList() {
        for (int i = 0; i < lengthOfRawDataList; i++) {
            String[] currentData = rawBootCode.get(i).split(" ");
            processedData.add(currentData);

        }
    }

    public List<String[]> getProcessedData() {
        return processedData;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public String[] getSteps(String executionStep) {

        char increment = executionStep.charAt(0);
        String result = executionStep.substring(executionStep.indexOf(increment) + 1);
        String[] steps = new String[]{String.valueOf(increment), result};
        return steps;
    }

    //to stop the infinite loop I cannot vist the same instruction twice. so by replacing the instruction name with DONE I am
    //effectively ticking off instructions as I visit. Once I revisit an instruction it will read done and break the loop
    public void executeBootCodeForPart1() {

        int currentIndex = 0;

        while (processedData.get(currentIndex)[0] != "DONE") {
            String[] currentInstruction = processedData.get(currentIndex);
            switch (currentInstruction[0]) {
                case ("nop"):
                    processedData.get(currentIndex)[0] = "DONE";
                    currentIndex++;
                    break;

                case ("acc"):
                    processedData.get(currentIndex)[0] = "DONE";
                    String[] steps = getSteps(currentInstruction[1]);
                    String operator = steps[0];
                    int increment = Integer.parseInt(steps[1]);
                    if (operator.equals("+")) {
                        int stepsToTake = accumulator + increment;
                        accumulator = stepsToTake;
                        if (currentIndex + 1 < processedData.size()) {
                            currentIndex++;
                        }


                    } else if (operator.equals("-")) {
                        int stepsToTake = accumulator - increment;
                        accumulator = stepsToTake;
                        if (currentIndex + 1 < processedData.size()) {
                            currentIndex++;
                        }
                    }
                    break;

                case ("jmp"):
                    processedData.get(currentIndex)[0] = "DONE";
                    String[] jumpSteps = getSteps(currentInstruction[1]);
                    String jumpOperator = jumpSteps[0];
                    int jumpIncrement = Integer.parseInt(jumpSteps[1]);

                    if (jumpOperator.equals("+")) {
                        if (currentIndex + jumpIncrement < processedData.size()) {
                            currentIndex = currentIndex + jumpIncrement;
                        }


                    } else if (jumpOperator.equals("-")) {

                        if (currentIndex - jumpIncrement > 0 && currentIndex - jumpIncrement < processedData.size()) {
                            currentIndex = currentIndex - jumpIncrement;
                        }
                    }
                    break;
            }


        }
    }
}

