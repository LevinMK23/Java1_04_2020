package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputBR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        System.out.println(
                Arrays.stream(br.readLine().split(" +"))
                .filter(arg -> {
                    boolean acc = true;
                    for (int i = 0; i < arg.length(); i++) {
                        acc &= Character.isDigit(arg.charAt(i));
                    }
                    return acc;})
                .map(Integer::parseInt).collect(Collectors.toList()));
    }
}
