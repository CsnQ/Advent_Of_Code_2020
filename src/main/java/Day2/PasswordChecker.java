package Day2;


import java.util.List;

public class PasswordChecker {

    String pwdToCheck;
    String[] splitText;
    String[] integerSplit;
    char letterToCheck;
    int minInstance;
    int maxInstance;
    int instanceOfLetter;
    boolean isValidPwd;

    public PasswordChecker(String pwdData) {
        this.splitText = pwdData.split(" ");
        this.integerSplit = splitText[0].split("-");
        this.pwdToCheck = splitText[2];
        this.letterToCheck = splitText[1].charAt(0);
        this.minInstance = Integer.parseInt(integerSplit[0]);
        this.maxInstance = Integer.parseInt(integerSplit[1]);
        this.instanceOfLetter = countLetters();
        this.isValidPwd = checkpwd();
    }

    private int countLetters() {
        int letterCount = 0;
        for (int i = 0; i < this.pwdToCheck.length() ; i++) {
            if(pwdToCheck.charAt(i)==this.letterToCheck){
                letterCount ++;
            }

        }
        return letterCount;
    }

    public boolean checkpwd (){

        if(this.instanceOfLetter == 0){
            return false;
        }else{
            if (this.instanceOfLetter>=this.minInstance && this.instanceOfLetter<=maxInstance){
                return true;
            }else{
                return false;
            }
        }

    }

    public String getPwdToCheck() {
        return pwdToCheck;
    }

    public char getLetterToCheck() {
        return letterToCheck;
    }

    public int getMinInstance() {
        return minInstance;
    }

    public int getMaxInstance() {
        return maxInstance;
    }

    public boolean isValidPwd() {
        return isValidPwd;
    }
}
