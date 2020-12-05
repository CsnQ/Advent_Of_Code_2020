package Day4;

import Day4.Passport;

import java.util.HashMap;

public class PassportProcessor2 {

    HashMap<String,String> passport;

    public PassportProcessor2(HashMap<String, String> passport) {
        this.passport = passport;
    }

    public boolean passportHasAllRequiredDataForPart1(){
        int validcounter = 0;
        boolean cidMissing = false;
        for (String name: passport.keySet()){
            String key = name;
            String value = passport.get(name);
            if (key.equals("cid")&& value==null){
                cidMissing=true;
            }else if(value != null){
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
}
