package lesson7.files;

import java.io.*;
import java.util.Scanner;

public class FileTest {

    static void readAllFileWithoutBuffer() throws FileNotFoundException {
        File file = new File("src/lesson7/files/file.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            in.next();
        }
        in.close();
    }

    static void readAllFileWithBuffer() throws IOException {
        File file = new File("src/lesson7/files/file.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while (reader.readLine() != null);
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        readAllFileWithBuffer();
        long endTime = System.currentTimeMillis();
        System.out.println("Test no buffer, time: " + (endTime - startTime) + "ms.");
    }
}
