package Day2;

import junit.framework.TestCase;

import java.util.List;

import static Utilities.ReadFile.readLinesFromFile;

public class ReadFileTest extends TestCase{

    public void testFileReader(){
        String filePath = "src/main/java/Day2/Day2TestInput.txt";
        List<String> result = readLinesFromFile(filePath);
        assertEquals(result.get(0), "1-3 a: abcde");
        assertEquals(result.get(1),"1-3 b: cdefg");
        assertEquals(result.get(2),"2-9 c: ccccccccc");
    }
}
