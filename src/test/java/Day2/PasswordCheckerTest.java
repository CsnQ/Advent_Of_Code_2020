package Day2;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//1-3 a: abcde
// pwdRequirements.put("minLetter", minLetter);
//         pwdRequirements.put("maxLetter", maxLetter);
//         pwdRequirements.put("letterToCheck", letterToCheck);
//         pwdRequirements.put("pwdToCheck", pwdToCheck);

public class PasswordCheckerTest extends TestCase{
    public void testPasswordCheckerObjectWithDoubleFigures () {
        String text = "11-13 t: tttttwtttttttttttt";
        PasswordChecker pc = new PasswordChecker(text);
        assertEquals(pc.getLetterToCheck(),'t');
        assertEquals(pc.getMaxInstance(),13);
        assertEquals(pc.getMinInstance(),11);
        assertEquals(pc.getPwdToCheck(),"tttttwtttttttttttt");
        assertEquals(pc.isValidPwd, false);

    }

    public void testPasswordCheckerObjectWithSingleFigures () {
        String text = "1-3 a: abcde";
        PasswordChecker pc = new PasswordChecker(text);
        System.out.println(pc.isValidPwd);
        assertEquals(pc.getLetterToCheck(),'a');
        assertEquals(pc.getMaxInstance(),3);
        assertEquals(pc.getMinInstance(),1);
        assertEquals(pc.getPwdToCheck(),"abcde");
        assertEquals(pc.isValidPwd, true);

    }



}
