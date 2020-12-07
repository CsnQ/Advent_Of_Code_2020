package Day4;

import Day4.Passport;

import java.util.HashMap;

public class PassportProcessor2 {
    // String expectFieldsString = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
    HashMap<String, String> passport;
    int[] byrMinMax = new int[]{1920, 2020};
    int[] iyrMinMax = new int[]{2010, 2020};
    int[] eyrMinMax = new int[]{2020, 2030};
    int[] hgtInMinMax = new int[]{59, 76};
    int[] hgtCmMinMax = new int[]{150, 193};
    String[] eclValues = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    public PassportProcessor2(HashMap<String, String> passport) {
        this.passport = passport;
    }

    public boolean passportHasAllRequiredDataForPart1() {
        int validcounter = 0;
        boolean cidMissing = false;
        for (String name : passport.keySet()) {
            String key = name;
            String value = passport.get(name);
            if (key.equals("cid") && value == null) {
                cidMissing = true;
            } else if (value != null) {
                validcounter++;
            }
        }
        if (validcounter == 8) {
            return true;
        } else if (validcounter == 7 && cidMissing) {
            return true;
        } else {
            return false;
        }
    }


    //    ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
//    byr:1937 iyr:2017 cid:147 hgt:183cm
    public boolean passportHasAllRequiredDataForPart2() {
        boolean byrValid = checkIntValid(passport.get("byr"), byrMinMax[0], byrMinMax[1]);
        boolean iyrValid = checkIntValid(passport.get("iyr"), iyrMinMax[0], iyrMinMax[1]);
        boolean eyrValid = checkIntValid(passport.get("eyr"), eyrMinMax[0], eyrMinMax[1]);
        boolean hgtValid = heightIsValid(passport.get("hgt"));
        boolean hclValid = hairColourValid(passport.get("hcl"));
        boolean eclValid = eyeColourValid(passport.get("ecl"));
        boolean pidValid = passportIDisValid(passport.get("pid"));


        if (eclValid && pidValid && eyrValid && hclValid && byrValid && iyrValid && hgtValid) {
            return true;
        } else {
            return false;
        }

    }


    public boolean checkIntValid(String digits, int min, int max) {
        boolean isNumeric=false;
        if (digits!=null) {
             isNumeric = digits.chars().allMatch(Character::isDigit);
        }

        if (isNumeric && (Integer.parseInt(digits) >= min && Integer.parseInt(digits) <= max)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean heightIsValid(String height) {
        String unit;
        String value;
        boolean isNumeric;
        int valueAsInt;

        if (height != null && (height.length() > 3 && height.length() <= 5)) {
            unit = height.substring(height.length() - 2).toLowerCase();
            value = height.substring(0, height.length() - 2);
            isNumeric = value.chars().allMatch(Character::isDigit);
        } else {
            return false;
        }

        if (isNumeric) {
            valueAsInt = Integer.parseInt(value);
        } else {
            return false;
        }

        if (unit.equals("in") && (valueAsInt >= hgtInMinMax[0] && valueAsInt <= hgtInMinMax[1])) {
            return true;
        } else if ((unit.equals("cm") && (valueAsInt >= hgtCmMinMax[0] && valueAsInt <= hgtCmMinMax[1]))) {
            return true;
        } else {
            return false;
        }
    }

    //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    public boolean hairColourValid(String hairColour) {

        if (hairColour==null){
            return false;
        }
        System.out.println(hairColour);
        char requiredPunctuation = '#';
        String hairColourValue;
        boolean hasCorrectChar = (requiredPunctuation == hairColour.charAt(0));

        if ( hairColour.length() == 7) {
            hairColourValue = hairColour.substring(1);
        } else {
            return false;
        }

        if (hasCorrectChar && (hairColourValue.matches("[a-f0-9]*") )) {
            return true;
        } else {
            return false;
        }


    }

    //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    public boolean eyeColourValid(String eyeColour) {
        boolean isValid = false;

        if (eyeColour != null) {
            for (int i = 0; i < eclValues.length; i++) {
                if (eclValues[i].equals(eyeColour)) {
                    isValid = true;
                }

            }
        }
        return isValid;
    }

    public boolean passportIDisValid(String pid) {

        boolean isNumeric=false;
        if (pid!=null) {
            isNumeric = pid.chars().allMatch(Character::isDigit);
        }else{
            return false;
        }
        if (pid.length() == 9 && isNumeric) {
            return true;
        } else {
            return false;
        }
    }
}
