package lesson2;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {

        System.out.println("Task6");
        System.out.println(task6(new int[]{1, 3, 6, 2, 3, 5}));
        System.out.println("Task7");
        task7(new int[]{1, 2, 3, 4, 5, 6}, -2);

    }

    public static boolean task6(int[] array) {

        StringBuilder resultString = new StringBuilder();

        int fullSum = 0;

        for (int i : array) fullSum += i;

        int leftSum = 0;
        for (int i : array) {
            leftSum += i;
            if (leftSum * 2 == fullSum) {
                int sum = 0;
                for (int el : array) {
                    sum += el;
                    resultString.append(el).append(' ');
                    if (sum == leftSum) {
                        resultString.append("|| ");
                    }
                }
                System.out.println(resultString);
                return true;
            }
        }
        return false;
    }

    public static void task7(int[] array, int n) {

        if (n < 0) {
            n = -n;
            n = n % array.length;
            n = array.length - n;
        }

        n = n % array.length;

        for (int i = 0; i < n; i++) {

            int current = array[0];

            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }

            array[array.length - 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }

}
