package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class InputCases {

    public static void main(String[] args) throws IOException {
//        byte[] a = new byte[10];
//        System.in.read(a);
//        System.out.println(Arrays.toString(a));
        // 1. Scanner
        Scanner in = new Scanner(System.in);
        //in.next() // one word hhghg    ggg        gh
        //in.nextLine() // one line
        // int a = in.nextInt();
        // 2. BufferedReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String line = reader.readLine();
        System.out.println(line);
        String [] words = line.split(" +");
        // HTML regex
        if (line.matches("\\+7\\([0-9]{3,4}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}")) {
            System.out.println("OK");
            line = line.replaceAll("-", "");
            String [] params = line.split("[()]");
            System.out.println(line);
            System.out.println(Arrays.toString(params));
        }
        System.out.println(Arrays.toString(words));
        String s = "abc";
        // s.length();
        //s.charAt(0) -> 'a' s[0] not!!!!!!
//        s.contains("ab") -> true;
//        s.indexOf("ab") -> 0;
//        s.startsWith("ab") -> true;
//        s.endsWith("bc") -> true;
//        s.compareTo("bbc") < 0;
//        s.equals("abc") -> true;
//        s.substring(1) -> "bc";
//        s.toCharArray() -> [a, b, c]
    }
}
