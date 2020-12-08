package Day6;

import Utilities.ReadFile;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
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
            System.out.println("result: "+result);

        }

        //assertEquals("abc", result );
    }


    @Test
    public void TestDistinctAnswers() {
        String data = "ab\n" +
                "ac";
        String[] dataArray = new String[]{data};
        CustomsChecker cc = new CustomsChecker(dataArray);
        String parsedString = cc.parseDataForPart1(dataArray[0]);
        int result = cc.countDistinctAnswers(parsedString);
        assertEquals(3, result );
    }

    @Test
    public void testSolutionForDay1WithTestData() throws IOException {
        int counter =0;
        List<Integer> answers = new ArrayList<>();
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6TestInput.txt");
        for (int i = 0; i < dataArray.length; i++) {
            CustomsChecker cc = new CustomsChecker(dataArray);
            String parsedString = cc.parseDataForPart1(dataArray[i]);
            int result = cc.countDistinctAnswers(parsedString);
            counter = counter+result;
        }
        System.out.println(counter);
        assertEquals(11, counter );
    }

    @Test
    public void testSolutionForDay1WithRealData() throws IOException {
        int counter =0;
        List<Integer> answers = new ArrayList<>();
        String[] dataArray = ReadFile.getCustomsInfoFromFile("src/main/java/Day6/Day6Input.txt");
        for (int i = 0; i < dataArray.length; i++) {
            CustomsChecker cc = new CustomsChecker(dataArray);
            String parsedString = cc.parseDataForPart1(dataArray[i]);
            int result = cc.countDistinctAnswers(parsedString);
            counter = counter+result;
        }
        System.out.println(counter);
        //assertEquals(11, counter );
    }
}