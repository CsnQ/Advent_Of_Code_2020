package Day1;

public class Day1 {
    public static int findSum(int expectedTotal, int[] listOfNums){
        int arrayLength = listOfNums.length;
        int total=0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (listOfNums[i]+listOfNums[j]==expectedTotal){
                    total =  listOfNums[i]*listOfNums[j];
                }
            }
        }

        return total;
    }

    public static int findSumOfThree(int expectedTotal, int[] listOfNums){
        int arrayLength = listOfNums.length;
        int total=0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                for (int k = 0; k < arrayLength; k++) {
                    if (listOfNums[i]+listOfNums[j]+listOfNums[k]==expectedTotal){
                        total = listOfNums[i]*listOfNums[j]*listOfNums[k];
                    }
                }

            }
        }

        return total;
    }
}
