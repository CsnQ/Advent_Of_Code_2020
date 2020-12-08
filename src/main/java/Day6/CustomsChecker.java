package Day6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomsChecker {

    String[] dataInput;
    List<List> groupedData;

    public List<List> getGroupedData() {
        return groupedData;
    }

    public CustomsChecker(String[] dataInput) {
        this.dataInput = dataInput;
        this.groupedData = new ArrayList<>();
        for (int i = 0; i < dataInput.length; i++) {
            String[] parsedData = getDataGroups(dataInput[i]);
            groupedData.add(Arrays.asList(parsedData));

        }
    }

    public String parseDataForPart1(String customsAnswers) {
        return customsAnswers.replace("\r\n", "");
    }

    public String[] getDataGroups(String customsAnswers){
        String[] result = customsAnswers.split("\n");
        return result;
    }

    public int countDistinctAnswers(String customsAnswers) {
        Set answers = new HashSet();
        for (int i = 0; i < customsAnswers.length(); i++) {
            answers.add(customsAnswers.charAt(i));
        }
        return answers.size();
    }
    public String buildStringFromGroup (List<String> dataGroup){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dataGroup.size(); i++) {
            sb.append(dataGroup.get(i));
        }

        String result = sb.toString();
        return result;

    }

    public HashMap<Character,Integer> getLetterFrequency (String datagroup){
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        Set answers = new HashSet();
        for (int i = 0; i < datagroup.length(); i++) {
            answers.add(datagroup.charAt(i));
        }

        Iterator<Character> it = answers.iterator();
        while(it.hasNext()){
           frequencyMap.put(it.next(),0);
        }

        for (Character key : frequencyMap.keySet()) {
            for (int i = 0; i < datagroup.length(); i++) {
                if (key==datagroup.charAt(i)){
                    frequencyMap.put(key,frequencyMap.get(key)+1);
                }
            }
        }

            return frequencyMap;
    }

    public int getPart2Answer(){
        int counter = 0;
        List<List> groupedData = getGroupedData();
        for (int i = 0; i < groupedData.size(); i++) {
            if (groupedData.get(i).size()==1){
                String data = (String) groupedData.get(i).get(0);
                counter=counter+data.length();
            }else {
                int lengthOfArray = groupedData.get(i).size();
                String answerString = buildStringFromGroup(groupedData.get(i));
                HashMap<Character,Integer> frequencies =getLetterFrequency(answerString);
                for (Integer value : frequencies.values()) {
                    if (value==lengthOfArray){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


}
