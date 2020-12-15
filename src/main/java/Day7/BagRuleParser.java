package Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagRuleParser {

    List<String> rulesFromFile;
    HashMap<String, HashMap> rules;
    List<String> validColours;
    String colour;

    public BagRuleParser(List<String> rulesFromFile, String colourPhrase) {
        this.colour =colourPhrase;
        this.rulesFromFile = rulesFromFile;
        this.rules = new HashMap<>();
        this.validColours = new ArrayList<>();
        for (int i = 0; i < rulesFromFile.size() ; i++) {
            extractRules(rulesFromFile.get(i));
        }
        getListOfPossibleColours();


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

    //function to create a list of colours that contain a gold bag directly
    public void getListOfPossibleColours(){

        for (Map.Entry<String, HashMap> entry : rules.entrySet()) {
            String key = entry.getKey();
            if (key.equals(colour)){
                continue;
            }else{
                HashMap<String,Integer> currentRules = rules.get(key);
                for (Map.Entry<String, Integer> item : currentRules.entrySet()){
                    if (item.getKey().equals(colour)){
                        validColours.add(key);

                    }
                }

            }
        }
    }

    public boolean hasValidColour (String currentKey){

        for (int i = 0; i < validColours.size() ; i++) {
            if (currentKey.equals(validColours.get(i))){
                return true;
            }
        }
        return false;
    }

    public int getNumberOfBagsThatCouldContainParticularColour(){
        int counter = 0;
        for (Map.Entry<String, HashMap> entry : rules.entrySet()){
            String key = entry.getKey();
            if (entry.getValue().size()>0) {
                HashMap<String, Integer> currentRules = rules.get(key);
               for(Map.Entry<String, Integer> item : currentRules.entrySet()){
                   String currentKey = item.getKey();
                   if (hasValidColour(currentKey)){
                       counter++;
                       break;
                   }
               }
            }
        }
        System.out.println(counter);
        System.out.println(validColours);
        return counter;
    }

    public List<String> getValidColours() {
        return validColours;
    }

    public HashMap<String, HashMap> getRules() {
        return rules;
    }

}
