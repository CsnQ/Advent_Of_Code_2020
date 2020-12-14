package Day7;

import java.util.HashMap;
import java.util.List;

public class BagRuleParser {

    List<String> rulesFromFile;
    HashMap<String, HashMap> rules;

    public BagRuleParser(List<String> rulesFromFile) {
        this.rulesFromFile = rulesFromFile;
        this.rules = new HashMap<>();
    }

    public void extractRules (String rule){
        HashMap<String, Integer> contentsRules = new HashMap<>();
        String[] words = rule.split(" bags contain ");
        String key = words[0];
        String contents = words[1];

        if (contents.equals("no other bags.")){
            rules.put(key, contentsRules);
        } else {
            String[] bagRules = contents.split(", ");
            for (int i = 0; i < bagRules.length; i++) {
                String[] splitRules = bagRules[i].split(" ");
                String bagColour = splitRules[1]+ " " + splitRules[2];
                String number = splitRules[0];

                contentsRules.put(bagColour,Integer.parseInt(number));
            }
            rules.put(key,contentsRules);
        }
    }

    public HashMap<String, HashMap> getRules() {
        return rules;
    }
}
