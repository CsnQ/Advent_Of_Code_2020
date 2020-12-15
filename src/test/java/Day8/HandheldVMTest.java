package Day8;

import Utilities.ReadFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HandheldVMTest {
    //nop
//+0
    @Test
    public void setProcessedBootCode() {
        String filepath = "src/main/java/Day8/Day8TestInput.txt";
        List<String> data = ReadFile.readLinesFromFile(filepath);
        HandheldVM hv = new HandheldVM(data);
        List<String[]> result = hv.getProcessedData();
        assertEquals("nop", result.get(0)[0]);
        assertEquals("+0", result.get(0)[1]);
    }

    @Test
    public void testGetSteps() {
        String filepath = "src/main/java/Day8/Day8TestInput.txt";
        List<String> data = ReadFile.readLinesFromFile(filepath);
        HandheldVM hv = new HandheldVM(data);
        String[] steps = hv.getSteps("-99");
        assertEquals("-", steps[0]);
        assertEquals("99", steps[1]);

    }

    @Test
    public void testAccumulator() {
        List<String> data = new ArrayList<>();
        data.add("acc -99");
        HandheldVM hv = new HandheldVM(data);
        hv.executeBootCodeForPart1();
        assertEquals(-99,hv.getAccumulator());

    }

    @Test
    public void testAccumulatorWithTwoValues() {
        List<String> data = new ArrayList<>();
        data.add("acc +10");
        data.add("acc +5");
        HandheldVM hv = new HandheldVM(data);
        hv.executeBootCodeForPart1();
        assertEquals(15,hv.getAccumulator());

    }


    @Test
    public void testBootcodeWithOneJump() {
        String filepath = "src/main/java/Day8/Day8TestInput2.txt";
        List<String> data = ReadFile.readLinesFromFile(filepath);
        HandheldVM hv = new HandheldVM(data);
        hv.executeBootCodeForPart1();
        System.out.println(hv.getAccumulator());
    }

    @Test
    public void testBootCodeExecution(){
        String filepath = "src/main/java/Day8/Day8TestInput.txt";
        List<String> data = ReadFile.readLinesFromFile(filepath);
        HandheldVM hv = new HandheldVM(data);
        hv.executeBootCodeForPart1();
        System.out.println(hv.getAccumulator());
        assertEquals(5,hv.getAccumulator());
    }

    @Test
    public void testBootCodeExecutionWithRealData(){
        String filepath = "src/main/java/Day8/Day8Input.txt";
        List<String> data = ReadFile.readLinesFromFile(filepath);
        HandheldVM hv = new HandheldVM(data);
        hv.executeBootCodeForPart1();
        System.out.println(hv.getAccumulator());
        assertEquals(1446,hv.getAccumulator());
    }
}