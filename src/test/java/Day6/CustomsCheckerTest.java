package Day6;

import Utilities.ReadFile;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class CustomsCheckerTest {

    @Test
    public void parseDataWithSingleGroup() {
        String[] data = new String[]{"abc"};
        CustomsChecker cc = new CustomsChecker(data);
        String result = cc.parseDataForPart1(data[0]);
        assertEquals("abc", result);
    }

    @Test
    public void parseDataWithMultipleGroup() throws IOException {
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6TestInput.txt");
        CustomsChecker cc = new CustomsChecker(dataArray);
        for (String s : dataArray) {
            System.out.println(s);
            String result = cc.parseDataForPart1(s);
            System.out.println("result: " + result);

        }

        //assertEquals("abc", result );
    }

    @Test
    public void testSolutionForDay1WithTestData() throws IOException {
        int counter = 0;
        List<Integer> answers = new ArrayList<>();
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6TestInput.txt");
        for (int i = 0; i < dataArray.length; i++) {
            CustomsChecker cc = new CustomsChecker(dataArray);
            String parsedString = cc.parseDataForPart1(dataArray[i]);
            int result = cc.countDistinctAnswers(parsedString);
            counter = counter + result;
        }
        System.out.println(counter);
        assertEquals(11, counter);
    }

    @Test
    public void testSolutionForDay1WithRealData() throws IOException {
        int counter = 0;
        List<Integer> answers = new ArrayList<>();
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6Input.txt");
        for (int i = 0; i < dataArray.length; i++) {
            CustomsChecker cc = new CustomsChecker(dataArray);
            String parsedString = cc.parseDataForPart1(dataArray[i]);
            int result = cc.countDistinctAnswers(parsedString);
            counter = counter + result;
        }
        System.out.println(counter);
        //assertEquals(11, counter );
    }

    @Test
    public void testGetDataGroups() throws IOException {
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6TestInput.txt");
        CustomsChecker cc = new CustomsChecker(dataArray);
        List<List> groupedData = cc.getGroupedData();

        assertEquals(5, groupedData.size());
        assertEquals(3, groupedData.get(1).size());
        assertEquals(2, groupedData.get(2).size());

    }

    @Test
    public void checkLetterFrequency() {
        String[] data = new String[]{"abac"};
        String groupedData = "abac";
        CustomsChecker cc = new CustomsChecker(data);
        HashMap<Character, Integer> result = cc.getLetterFrequency(groupedData);
        assertEquals(2, (int) result.get('a'));
        assertEquals(1, (int) result.get('b'));
        assertEquals(1, (int) result.get('c'));

    }

    @Test
    public void testPart2AnswerWithTestData() throws IOException {
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6TestInput.txt");
        CustomsChecker cc = new CustomsChecker(dataArray);
        int result = cc.getPart2Answer();
        assertEquals(6, result);

    }

    @Test
    public void testPart2AnswerWithRealData() throws IOException {
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6Input.txt");
        CustomsChecker cc = new CustomsChecker(dataArray);
        int result = cc.getPart2Answer();
        assertEquals(3493, result);

    }
}