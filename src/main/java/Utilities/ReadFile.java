package Utilities;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//^\s*$
// '\n\n'
public class ReadFile {
    public static List<String> readLinesFromFile(String filePath) {
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
    public static List<Integer> readLinesFromFileAsInt(String filePath) {
        List<Integer> dataFromFile = new ArrayList<>();
        try {
            File inputData = new File(filePath);
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();
                dataFromFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return dataFromFile;
    }

    public static List<Long> readLinesFromFileAsLong(String filePath) {
        List<Long> dataFromFile = new ArrayList<>();
        try {
            File inputData = new File(filePath);
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
                long data = myReader.nextLong();
                dataFromFile.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return dataFromFile;
    }
    //followed tutorial from https://www.tutorialspoint.com/Counting-number-of-paragraphs-in-text-file-using-java
    public static String[] getPassportInfoFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileStream = new FileInputStream(file);
        byte[] byteArray = new byte[(int)file.length()];
        fileStream.read(byteArray);
        String data = new String(byteArray);

        String[] paragraphs = data.toString().split("\r\n\r\n");

        return paragraphs;
    }

    public static String[] getCustomsInfoFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileStream = new FileInputStream(file);
        byte[] byteArray = new byte[(int)file.length()];
        fileStream.read(byteArray);
        String data = new String(byteArray);

       // String[] paragraphs = data.toString().split("(?m)^\\s*$");
        String[] paragraphs = data.toString().split("\r\n\r\n" );


        return paragraphs;
    }
}
