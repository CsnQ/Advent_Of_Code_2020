package Day4;


import java.util.*;

public class PassportProcessor {
    String expectFieldsString = "byr,iyr,eyr,hgt,hcl,ecl,pid,cid";
    String[] passports;

    public String[] getPassports() {
        return passports;
    }

    public void setPassports(String[] passports) {
        this.passports = passports;
    }

    public List<String> getFieldsFromPassport(String passport) {
        List<String> fields = new ArrayList<>();
        String text = passport.replace("\n", " ").replace("\r", "");
        String[] passportInfo = text.split(" ");
        for (int i = 0; i < passportInfo.length; i++) {
            String field = passportInfo[i].substring(0, passportInfo[i].indexOf(":"));
            fields.add(field);
        }

        return fields;
    }

    public boolean checkIfValid(List<String> passportFields) {
        int validCounter = 0;
        boolean cidMissing = true;
        for (int i = 0; i < passportFields.size(); i++) {
            if (passportFields.get(i).equals("cid")) {

                cidMissing = false;
                System.out.println(cidMissing);
            }
            if (expectFieldsString.contains(passportFields.get(i))) {
                validCounter++;
            }
        }

        if (validCounter == 8) {
            return true;
        } else if (validCounter == 7 && cidMissing) {
            return true;
        } else {
            return false;
        }
    }

    public int processPassports(){
        System.out.println("number of Passports: "+ this.passports.length);
        int validPassports = 0;

        for (int i = 0; i < this.passports.length; i++) {
            List<String> fields = getFieldsFromPassport(this.passports[i]);
            if(checkIfValid(fields)){
                validPassports++;
            }else{
                System.out.println("Passport Num: " + i + " is not valid");
                System.out.println("details are: " + this.passports[i]);
            }
        }

        return validPassports;
    }


}
