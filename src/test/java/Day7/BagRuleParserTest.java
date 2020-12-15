package Day7;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utilities.ReadFile.readLinesFromFile;
import static org.junit.Assert.*;

public class BagRuleParserTest extends TestCase {

    public void testExtractRulesProducesDesiredData() {
        String testData = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        List<String> data = new ArrayList<>();
        data.add(testData);

        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        System.out.println(data.get(0));
        bp.extractRules(data.get(0));
        HashMap<String, HashMap> rules = bp.getRules();

        for (Map.Entry<String, HashMap> entry : rules.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            assertTrue(key.equals("light red"));
            assertTrue(value.toString().contains("muted yellow=2, bright white=1"));
        }
    }

    public void testBagRuleParserConstructsHashMapCorrectly() {
        String filepath = "src/main/java/Day7/Day7TestInput.txt";
        List<String> data = readLinesFromFile(filepath);
        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        HashMap<String, HashMap> rules = bp.getRules();
        assertEquals(9, rules.size());
    }

    public void testBagRuleParserConstructsHashMapCorrectlyWithRealData() {
        String filepath = "src/main/java/Day7/Day7Input.txt";
        List<String> data = readLinesFromFile(filepath);
        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        HashMap<String, HashMap> rules = bp.getRules();
        assertEquals(594, rules.size());
    }

    public void testValidColoursWithTestData() {
        String filepath = "src/main/java/Day7/Day7TestInput.txt";
        List<String> data = readLinesFromFile(filepath);
        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        List<String> result = bp.getValidColours();
        assertEquals("muted yellow", result.get(0));
        assertEquals("bright white", result.get(1));
        assertEquals(2,result.size());
    }

    public void testExpectedNumberOfShinyGoldBagsForTestDataIs4() {
        //task is to identify how many bag colours can hold at least 1 shiny gold bag
        String filepath = "src/main/java/Day7/Day7TestInput.txt";
        List<String> data = readLinesFromFile(filepath);
        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        int result = bp.getNumberOfBagsThatCouldContainParticularColour();
        assertEquals(4,result);
    }

    public void testExpectedNumberOfShinyGoldBagsForRealData() {
        //task is to identify how many bag colours can hold at least 1 shiny gold bag
        String filepath = "src/main/java/Day7/Day7Input.txt";
        List<String> data = readLinesFromFile(filepath);
        BagRuleParser bp = new BagRuleParser(data, "shiny gold");
        int result = bp.getNumberOfBagsThatCouldContainParticularColour();
        System.out.println(result);
    }

}