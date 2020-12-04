package Day4;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.util.StringUtils;


import java.util.HashMap;
import java.util.List;

public class PassportProcessor {
    HashMap<String, String> fields = new HashMap<>();
    List<String> optionalFields;

    public PassportProcessor(HashMap<String, String> fields, List<String> optionalFields) {
        this.fields = fields;
        this.fields.put("Birth year", "byr");
        this.fields.put("Issue Year", "iyr");
        this.fields.put("Expiration Year", "eyr");
        this.fields.put("Height", "hgt");
        this.fields.put("Hair Color", "hcl");
        this.fields.put("Eye Color", "ecl");
        this.fields.put("Passport ID", "pid");
        this.fields.put("Country ID", "cid");

        this.optionalFields = optionalFields;
        optionalFields.add("cid");

    }

    public static boolean isValidPassport(String passport) {
        String text = passport.replace("\n", " ").replace("\r", "");
        String[] passportInfo = text.split(" ");
        for (int i = 0; i < passportInfo.length; i++) {
            System.out.println(passportInfo[i]);
            System.out.println(passportInfo[i].substring(0, passportInfo[i].indexOf(":")));
        }
        System.out.println(passportInfo.length);


        return true;
    }

// remove line breaks:
//        String text = result[0].replace("\n", " ").replace("\r", "");

}
