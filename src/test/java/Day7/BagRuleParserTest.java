package Day7;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utilities.ReadFile.readLinesFromFile;
import static org.junit.Assert.*;

public class BagRuleParserTest extends TestCase {

    public void testExtractRulesProducesDesiredData(){
        String filepath = "src/main/java/Day7/Day7TestInput.txt";
        List<String> data = readLinesFromFile(filepath);

        BagRuleParser bp = new BagRuleParser(data);
        System.out.println(data.get(0));
        bp.extractRules(data.get(0));
        HashMap<String, HashMap> rules = bp.getRules();

        for (Map.Entry<String, HashMap> entry : rules.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }
    }

}