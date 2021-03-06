package Day2;

import Utilities.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void getAnswerForTestData() {
        int validCounter = 0;
        int validCounterpt2=0;

        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day2/Day2TestInput.txt");
        List<PasswordChecker> pwdData = new ArrayList<>();
        data.forEach(item -> {
            PasswordChecker pc = new PasswordChecker(item);
            pwdData.add(pc);
        });

        for (int i = 0; i < pwdData.size(); i++) {
            if (pwdData.get(i).isValidForPart1) {
                validCounter++;
            }

            if (pwdData.get(i).isValidForPart2){
                validCounterpt2++;
            }
        }

        System.out.println("number of Passwords: " + data.size());
        System.out.println("number of valid passwords: " + validCounter);
        System.out.println("*************************");
        System.out.println("Valid passwords with new requirements: "+validCounterpt2);
    }

    public static void getAnswerForRealData() {
        int validCounter = 0;
        int validCounterpt2=0;
        List<String> data = ReadFile.readLinesFromFile("src/main/java/Day2/Day2Input.txt");
        List<PasswordChecker> pwdData = new ArrayList<>();
        data.forEach(item -> {
            PasswordChecker pc = new PasswordChecker(item);
            pwdData.add(pc);
        });

        for (int i = 0; i < pwdData.size(); i++) {
            if (pwdData.get(i).isValidForPart1) {
                validCounter++;
            }

            if (pwdData.get(i).isValidForPart2){
                validCounterpt2++;
            }
        }

        System.out.println("number of Passwords: " + data.size());
        System.out.println("number of valid passwords: " + validCounter);
        System.out.println("*************************");
        System.out.println("Valid passwords with new requirements: "+validCounterpt2);

    }
}
