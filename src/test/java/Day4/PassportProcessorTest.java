package Day4;

import Utilities.ReadFile;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class PassportProcessorTest extends TestCase {

    public void testIfPassportValidwithOnePassport(){
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        String[] passports = new String[]{passport};

       PassportProcessor passPro = new PassportProcessor();
       passPro.setPassports(passports);
       int result = passPro.processPassports();
       assertEquals(1,result);
    }

    public void testIfPassportValidwithMultiplePassport() throws IOException {
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4TestInput.txt");

        PassportProcessor passPro = new PassportProcessor();
        passPro.setPassports(passports);
        int result = passPro.processPassports();
        System.out.println(result);
    }

    public void testIfPassportValidwithRealInput() throws IOException {
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4Input.txt");

        PassportProcessor passPro = new PassportProcessor();
        passPro.setPassports(passports);
        int result = passPro.processPassports();
        System.out.println(result);
    }
}