package Day2;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

import static Utilities.ReadFile.*;

public class ReadFileTest extends TestCase{

    public void testFileReader(){
        String filePath = "src/main/java/Day2/Day2TestInput.txt";
        List<String> result = readLinesFromFile(filePath);
        assertEquals(result.get(0), "1-3 a: abcde");
        assertEquals(result.get(1),"1-3 b: cdefg");
        assertEquals(result.get(2),"2-9 c: ccccccccc");
    }

    public void testPassportFileReaderWithTestInput() throws IOException {
        String filepath = "src/main/java/Day4/Day4TestInput.txt";
        String[] result = getPassportInfoFromFile(filepath);
        assertEquals(4,result.length);
        assertTrue(result[0].contains("hgt:183cm"));

    }

    public void testPassportFileReaderWithRealInput() throws IOException {
        String filepath = "src/main/java/Day4/Day4Input.txt";
        String[] result = getPassportInfoFromFile(filepath);
        System.out.println(result.length);
        assertEquals(290,result.length);
        assertTrue(result[289].contains("iyr:2011 hcl:#866857 hgt:74in"));
    }

    public void testPassportFileReaderWithDay6Data() throws IOException {
        String filepath = "src/main/java/Day6/Day6TestInput.txt";
        String[] result = getCustomsInfoFromFile(filepath);

    }
}
