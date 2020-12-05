package Day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Passport {
    //String expectFieldsString = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;


    //String expectFieldsString = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";


    public Passport(String passport) {

        readDataFromPassport(passport);

    }


    public void readDataFromPassport(String passport) {
        List<String> fields = new ArrayList<>();
        String text = passport.replace("\n", " ").replace("\r", "");
        String[] passportInfo = text.split(" ");
        for (int i = 0; i < passportInfo.length; i++) {
            String[] fieldAndVal = passportInfo[i].split(":");
            populateProperties(fieldAndVal);
        }
    }

    // String expectFieldsString = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
    public void populateProperties(String[] fieldAndVal) {
        String field = fieldAndVal[0];
        String value = fieldAndVal[1];
        switch (field) {
            case "byr":
                this.byr = value;
                break;
            case "iyr":
                this.iyr = value;
                break;
            case "eyr":
                this.eyr = value;
                break;
            case "hgt":
                this.hgt = value;
                break;
            case "hcl":
                this.hcl = value;
                break;
            case "ecl":
                this.ecl = value;
                break;
            case "pid":
                this.pid = value;
                break;
            case "cid":
                this.cid = value;
                break;
        }
    }

    @Override
    public String toString() {
        return "Passport{" +
                "byr='" + byr + '\'' +
                ", iyr='" + iyr + '\'' +
                ", eyr='" + eyr + '\'' +
                ", hgt='" + hgt + '\'' +
                ", hcl='" + hcl + '\'' +
                ", ecl='" + ecl + '\'' +
                ", pid='" + pid + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public HashMap<String, String> getAllPassportData() {
        HashMap<String, String> passportData = new HashMap<>();
        passportData.put("byr", this.byr);
        passportData.put("iyr", this.iyr);
        passportData.put("eyr", this.eyr);
        passportData.put("hgt", this.hgt);
        passportData.put("hcl", this.hcl);
        passportData.put("ecl", this.ecl);
        passportData.put("pid", this.pid);
        passportData.put("cid", this.cid);
        return passportData;
    }
}
