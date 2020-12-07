package Day4;

import Utilities.ReadFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PassportProcessor2Test {

    @Test
    public void passportHasAllRequiredDataForPart1() {
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        Assert.assertEquals(true, pp2.passportHasAllRequiredDataForPart1());
    }

    @Test
    public void passportHasAllRequiredDataForinvalidPassport() {
        String passport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        Assert.assertEquals(false, pp2.passportHasAllRequiredDataForPart1());
    }

    @Test
    public void NewPassportProcesserProvidesSameNumberAsOldProcesserForTestData() throws IOException {
        int counter = 0;
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4TestInput.txt");
        for (int i = 0; i < passports.length; i++) {
            Passport p = new Passport(passports[i]);
            HashMap<String, String> data = p.getAllPassportData();

            PassportProcessor2 pp2 = new PassportProcessor2(data);

            if (pp2.passportHasAllRequiredDataForPart1()) {
                counter++;
            }
        }

        assertEquals(2, counter);
    }

    @Test
    public void NewPassportProcesserProvidesSameNumberAsOldProcesserForRealData() throws IOException {
        int counter = 0;
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4Input.txt");
        for (int i = 0; i < passports.length; i++) {
            Passport p = new Passport(passports[i]);
            HashMap<String, String> data = p.getAllPassportData();

            PassportProcessor2 pp2 = new PassportProcessor2(data);

            if (pp2.passportHasAllRequiredDataForPart1()) {
                counter++;
            }
        }

        assertEquals(237, counter);
    }

    @Test
    public void passportvalidatesDate() {
        String passport = "byr:1990";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.checkIntValid(data.get("byr"), pp2.byrMinMax[0], pp2.byrMinMax[1]);

        assertEquals(true, result);

    }

    @Test
    public void passportvalidatesDateFalse() {
        String passport = "byr:1900";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.checkIntValid(data.get("byr"), pp2.byrMinMax[0], pp2.byrMinMax[1]);

        assertEquals(false, result);

    }

    @Test
    public void passportvalidatesIssueYearTrue() {
        String passport = "iyr:2010";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.checkIntValid(data.get("iyr"), pp2.iyrMinMax[0], pp2.iyrMinMax[1]);

        assertEquals(true, result);

    }

    @Test
    public void passportvalidatesHeightTrue() {
        String passport = "hgt:60in";
        Passport p = new Passport(passport);

        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.heightIsValid(data.get("hgt"));
        assertEquals(true, result);

    }

    @Test
    public void passportvalidatesHeightTruecm() {
        String passport = "hgt:159cm";
        Passport p = new Passport(passport);

        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.heightIsValid(data.get("hgt"));
        assertEquals(true, result);

    }

    @Test
    public void passportvalidatesHeightfalsecm() {
        String passport = "hgt:149cm";
        Passport p = new Passport(passport);

        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.heightIsValid(data.get("hgt"));
        assertEquals(false, result);

    }

    @Test
    public void passportValidatesHairColourTrue(){
        String passport = "hcl:#123456";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.hairColourValid(data.get("hcl"));
        assertEquals(true, result);
    }

    @Test
    public void passportValidatesHairColourFalse(){
        String passport = "hcl:#123abz";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.hairColourValid(data.get("hcl"));
        assertEquals(false, result);
    }

    @Test
    public void passportValidatesEyeColourTrue(){
        String passport = "ecl:gry";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.eyeColourValid(data.get("ecl"));
        assertEquals(true, result);
    }

    @Test
    public void passportValidatesEyeColourFalse(){
        String passport = "ecl:wut";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.eyeColourValid(data.get("ecl"));
        assertEquals(false, result);
    }

    @Test
    public void passportValidatesPassportIDTrue(){
        String passport = "pid:000000001";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.passportIDisValid(data.get("pid"));
        assertEquals(true, result);
    }

    @Test
    public void passportValidatesPassportIDFalse(){
        String passport = "pid:0123456789";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.passportIDisValid(data.get("pid"));
        assertEquals(false, result);
    }

    @Test
    public void passportValidatesPassportforDay2Requirements(){
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";
        Passport p = new Passport(passport);

        HashMap<String,String> data = p.getAllPassportData();
        PassportProcessor2 pp2 = new PassportProcessor2(data);
        boolean result = pp2.passportHasAllRequiredDataForPart2();
        assertEquals(true, result);
    }

    @Test
    public void checkTestInputForDay2 () throws IOException {
        int validCounter = 0;
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4TestInput.txt");
        for (int i = 0; i < passports.length; i++) {
            Passport p = new Passport(passports[i]);
            HashMap<String,String> data = p.getAllPassportData();
            PassportProcessor2 pp2 = new PassportProcessor2(data);
            boolean isAvalidPassport = pp2.passportHasAllRequiredDataForPart2();
            if (isAvalidPassport){
                validCounter++;
            }


        }

        System.out.println(validCounter);
    }

    @Test
    public void checkTestInputForDay2RealInput () throws IOException {
        int validCounter = 0;
        String[] passports = ReadFile.getPassportInfoFromFile("src/main/java/Day4/Day4Input.txt");
        for (int i = 0; i < passports.length; i++) {
            System.out.println("index: "+i);
            System.out.println(passports[i]);
            Passport p = new Passport(passports[i]);
            HashMap<String,String> data = p.getAllPassportData();
            PassportProcessor2 pp2 = new PassportProcessor2(data);
            boolean isAvalidPassport = pp2.passportHasAllRequiredDataForPart2();
            if (isAvalidPassport){
                validCounter++;
            }


        }

        System.out.println(validCounter);
    }
}