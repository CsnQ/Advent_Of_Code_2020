package Day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JoltCalculator {
    List<Long> rawInput;
    List<Long> sortedInput;

    public JoltCalculator(List<Long> rawInput) {
        this.rawInput = rawInput;
        int maxArrayIndex = rawInput.size();
        this.sortedInput = new ArrayList<>();
        sortedInput = rawInput;
        //add in the adapter on the plane
        sortedInput.add(0L);
        sortedInput.sort(null);
        //add in your adapter
        sortedInput.add(sortedInput.get(maxArrayIndex) + 3L);
    }

    public List<Long> getSortedInput() {
        return sortedInput;
    }

    public HashMap<Long, Long> countDifferences() {
        int arrayLength = sortedInput.size() - 1;

        HashMap<Long, Long> differenceMap = new HashMap<>();

        for (int i = 1; i < sortedInput.size(); i++) {
            Long currentNum = sortedInput.get(i - 1);
            Long nextNum = sortedInput.get(i);

            Long difference = nextNum - currentNum;
            if (differenceMap.containsKey(difference)) {
                Long currentVal = differenceMap.get(difference);
                differenceMap.put(difference, currentVal + 1L);
            } else {
                differenceMap.put(difference, 1L);
            }
        }

        return differenceMap;
    }

    public Long calculatePart1Answer(){
        HashMap<Long,Long> results = countDifferences();
        return results.get(1L)*results.get(3L);
    }
}
