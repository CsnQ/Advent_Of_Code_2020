package Day2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
//1-3 a: abcde
// pwdRequirements.put("minLetter", minLetter);
//         pwdRequirements.put("maxLetter", maxLetter);
//         pwdRequirements.put("letterToCheck", letterToCheck);
//         pwdRequirements.put("pwdToCheck", pwdToCheck);

public class PasswordCheckerTest extends TestCase {
    public void testPasswordCheckerObjectWithDoubleFigures() {
        String text = "11-13 t: tttttwtttttttttttt";
        PasswordChecker pc = new PasswordChecker(text);
        assertEquals(pc.getLetterToCheck(), 't');
        assertEquals(pc.getMaxInstance(), 13);
        assertEquals(pc.getMinInstance(), 11);
        assertEquals(pc.getPwdToCheck(), "tttttwtttttttttttt");
        assertEquals(pc.isValidForPart1, false);

    }

    public void testPasswordCheckerObjectWithSingleFigures() {
        String text = "1-3 a: abcde";
        PasswordChecker pc = new PasswordChecker(text);
        assertEquals(pc.getLetterToCheck(), 'a');
        assertEquals(pc.getMaxInstance(), 3);
        assertEquals(pc.getMinInstance(), 1);
        assertEquals(pc.getPwdToCheck(), "abcde");
        assertEquals(pc.isValidForPart1, true);
        assertEquals(true, pc.isValidForPart2);

    }


    public void testPasswordCheckerObjectWithdifferentResultsForPart1AndPart2() {
        String text = "2-9 c: ccccccccc";
        PasswordChecker pc = new PasswordChecker(text);
        System.out.println(pc.isValidForPart1);
        assertEquals(pc.getLetterToCheck(), 'c');
        assertEquals(pc.getMaxInstance(), 9);
        assertEquals(pc.getMinInstance(), 2);
        assertEquals(pc.getPwdToCheck(), "ccccccccc");
        assertEquals(true, pc.isValidForPart1);
        assertEquals(false, pc.isValidForPart2);

    }

    public void testWithListOfItems() {
        int validCounter = 0;
        int validCounterpt2 = 0;
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

        assertEquals(1, validCounterpt2);
    }
}
