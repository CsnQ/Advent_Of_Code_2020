package Day4;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PassportTest {

    @Test
    public void readDataFromValidPassport() {
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        String result = p.toString();
        String expected = "Passport{byr='1937', iyr='2017', eyr='2020', hgt='183cm', hcl='#fffffd', ecl='gry', pid='860033327', cid='147'}";
        assertEquals(expected, result);

    }

    @Test
    public void checkHashMap() {
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        HashMap<String,String> data = p.getAllPassportData();
        data.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

    }

    @Test
    public void readDataFromInvalidPassport() {
        String passport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929";

        Passport p = new Passport(passport);
        String result = p.toString();
        String expected = "Passport{byr='1929', iyr='2013', eyr='2023', hgt='null', hcl='#cfa07d', ecl='amb', pid='028048884', cid='350'}";
        assertEquals(expected, result);

    }
}