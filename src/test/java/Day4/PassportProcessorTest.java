package Day4;

import junit.framework.TestCase;

import static org.junit.Assert.*;

public class PassportProcessorTest extends TestCase {

    public void testIfPassportValid(){
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        PassportProcessor.isValidPassport(passport);
    }
}