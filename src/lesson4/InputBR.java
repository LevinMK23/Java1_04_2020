package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputBR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int value = Integer.parseInt(br.readLine());
        System.out.println(
                Arrays.stream(br.readLine().split(" +"))   //Arrays.stream(массив) - создание потока(стрима) из массива
                //.filter Отфильтровывает записи, возвращает только записи, соответствующие условию;
                // -> это лябда оператор, он разделяет лямбда-выражение на две части: левая часть содержит список параметров выражения,
                //а правая собственно представляет тело лямбда-выражения, где выполняются все действия.
                .filter(arg -> {
                    boolean acc = true;
                    for (int i = 0; i < arg.length(); i++) {
                        acc &= Character.isDigit(arg.charAt(i));
                    }
                    return acc;})
                .map(Integer::parseInt).collect(Collectors.toList()));  //map Преобразует каждый элемент стрима
    }
}
