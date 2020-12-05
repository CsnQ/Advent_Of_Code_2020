import Day4.Passport;
import Utilities.ReadFile;
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
        assertEquals(true, pp2.passportHasAllRequiredDataForPart1());
    }

    @Test
    public void passportHasAllRequiredDataForinvalidPassport() {
        String passport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929";

        Passport p = new Passport(passport);
        HashMap<String, String> data = p.getAllPassportData();

        PassportProcessor2 pp2 = new PassportProcessor2(data);
        assertEquals(false, pp2.passportHasAllRequiredDataForPart1());
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
}