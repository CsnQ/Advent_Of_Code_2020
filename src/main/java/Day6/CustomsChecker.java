package Day6;

import java.util.HashSet;
import java.util.Set;

public class CustomsChecker {

    String[] dataInput;


    public CustomsChecker(String[] dataInput) {
        this.dataInput = dataInput;

    }

    public String parseDataForPart1(String customsAnswers) {
        return customsAnswers.replace("\r\n", "");
    }

    public int countDistinctAnswers(String customsAnswers) {
        Set answers = new HashSet();
        for (int i = 0; i < customsAnswers.length(); i++) {

            answers.add(customsAnswers.charAt(i));

        }
        return answers.size();
    }
}
