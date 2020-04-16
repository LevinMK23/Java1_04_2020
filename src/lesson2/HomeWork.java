package lesson2;

import java.util.Arrays;

public class HomeWork {

    // O(N) N = input.length
    public static boolean checkBalanse(int[] input) {
        // 1 2 3 1 | 4 3 ctrl + alt + l
        StringBuilder resut = new StringBuilder();
        int fullSum = 0;
        for (int i : input) fullSum += i;
        if (fullSum % 2 == 1) {
            return false;
        }
        int leftSum = 0;
        for (int i : input) {
            leftSum += i;
            if (leftSum * 2 == fullSum) {
                int sum = 0;
                for (int el : input) {
                    sum += el;
                    resut.append(el).append(' ');
                    if (sum == leftSum) {
                        resut.append("| ");
                    }
                }
                System.out.println(resut);
                return true;
            }
        }
        return false;
    }

    public static void shift(int[] input, int n) {
        // 1 2 3 4 5 + 10 -> 2 3 4 5 1
        // 1 2 3 4 5 -1 -> 5 1 2 3 4
        // -1 = +4
        // +10 = 0
        // 10 % 5 = 0
        // 12 % 5 = +2
        if (n < 0) {
            n = -n;
            n = n % input.length;
            n = input.length - n;
        }
        n = n % input.length; // 4 % 5 = 4
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            int tmp = input[0];
            //1 2 3 4 5 -> 1, 2 3 4 5 1
            // 1 2 3 4 5
            // 2 3 4 5
            System.arraycopy(input, 1, input, 0, input.length - 1);
            input[input.length - 1] = tmp;
        }
        System.out.println(Arrays.toString(input));
    }

    public static void shiftON(int[] input, int n) {
        if (n < 0) {
            n = -n;
            n = n % input.length;
            n = input.length - n;
        }
        n = n % input.length;
        int [] tmp = new int[input.length];
        int start = n;
        for (int i = n; i < n + input.length; i++) {
            tmp[i - n] = input[i % input.length];
        }
        System.out.println(Arrays.toString(tmp));
    }

    public static void main(String[] args) {
        // checkBalanse(new int[]{1, 3, 2, 5, 3, 1, 4, 3});
        shiftON(new int[] {1, 2, 3, 4, 5}, 2);
    }
}
