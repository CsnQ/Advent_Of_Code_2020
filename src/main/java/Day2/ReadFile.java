package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static List<String> readLinesFromFile (String filePath){
        List<String> dataFromFile = new ArrayList<>();
        try {
            File inputData = new File(filePath);
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataFromFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return dataFromFile;
    }
}
