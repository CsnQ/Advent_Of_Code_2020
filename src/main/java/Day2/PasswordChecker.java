package Day2;


public class PasswordChecker {

    String pwdToCheck;
    String[] splitText;
    String[] integerSplit;
    char letterToCheck;
    int minInstance;
    int maxInstance;
    int instanceOfLetter;
    boolean isValidForPart1;
    boolean isValidForPart2;

    public PasswordChecker(String pwdData) {
        this.splitText = pwdData.split(" ");
        this.integerSplit = splitText[0].split("-");
        this.pwdToCheck = splitText[2];
        this.letterToCheck = splitText[1].charAt(0);
        this.minInstance = Integer.parseInt(integerSplit[0]);
        this.maxInstance = Integer.parseInt(integerSplit[1]);
        this.instanceOfLetter = countLetters(this.pwdToCheck);
        this.isValidForPart1 = checkpwd();
        this.isValidForPart2 = checkpwdForNewRequirements();
    }

    private int countLetters(String pwdString) {
        int letterCount = 0;
        for (int i = 0; i < pwdString.length(); i++) {
            if (pwdString.charAt(i) == this.letterToCheck) {
                letterCount++;
            }

        }
        return letterCount;
    }

    public boolean checkpwdForNewRequirements() {

        int startPoint = this.minInstance - 1;
        int endPoint = this.maxInstance - 1;
        char firstChar = this.pwdToCheck.charAt(startPoint);
        char secondChar = this.pwdToCheck.charAt(endPoint);
        if (firstChar != this.letterToCheck && secondChar != this.letterToCheck) {
            return false;
        } else if (firstChar == this.letterToCheck && secondChar == this.letterToCheck) {
            return false;
        } else if (firstChar == this.letterToCheck && secondChar != this.letterToCheck) {
            return true;
        } else if (firstChar != this.letterToCheck && secondChar == this.letterToCheck) {
            return true;
        }else {
            return false;
        }

    }

    public boolean checkpwd() {

        if (this.instanceOfLetter == 0) {
            return false;
        } else {
            if (this.instanceOfLetter >= this.minInstance && this.instanceOfLetter <= maxInstance) {
                return true;
            } else {
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

    public boolean isValidForPart1() {
        return isValidForPart1;
    }
}
