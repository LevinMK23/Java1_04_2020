package lesson2;

import java.util.Arrays;

public class HomeworkTwo {

    public static void main(String[] args) {
        //taskOne();
        //taskTwo();
        //taskThree();
        //taskFour();
        //taskFive();
        //taskSix();
        //taskSix(new int[]{1, 3, 2, 5, 3, 1, 4, 3});
        //taskSeven();
        //taskSeven(new int[] {1, 2, 3, 4, 5}, -1);
        taskSevenON(new int[] {1, 2, 3, 4, 5}, 2);
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void taskOne() {
        System.out.println("Task 1.");
        int[] a = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static void taskTwo() {
        System.out.println("\nTask 2.");
        int[] a = new int[8];
        for (int i = 0, j = 0; i < a.length; i++, j+=3) {
            a[i] = j;
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void taskThree() {
        System.out.println("\n\nTask 3.");
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
            System.out.print(a[i] + " ");
        }
    }


    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void taskFour() {
        System.out.println("\n\nTask 4.");
        int num = 3;
        int[][] a = new int[num][num];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0, j2 = a[i].length; j < a[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) {
                    a[i][j] = 1;
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\r\n");
        }
    }

    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void taskFive() {
        System.out.println("\n\nTask 5.");
        int[] a = {21, 3, 1, 5, 8, 14, 11, 4, 17};
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }


    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    // third version
    // O(N) N = input.length
    //          1 2 3 1 | 4 3
    // fullSum  1 3 6 7 | 11 14
    // leftSum  1 3 6 7 | (7*2=14)
    public static boolean taskSix(int [] input) {
        System.out.println("\n\nTask 6.");
        // 1 2 3 1 | 4 3
        // ctrl + alt + l
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
    /*
    public static boolean taskSix(int a[]) {
        System.out.println("\n\nTask 6.");
        int leftSum = 0;
        int rightSum = 0;
//      first veriosn
        for (int i:a) {
            rightSum += i;
        }
        for (int i = 0; i < a.length; i++) {
            if (leftSum == rightSum) {
                return true;
            }
            leftSum += a[i];
            rightSum -= a[i];
        }
//      second version
//        for (int i = 0; i < a.length + 1; i++) {
//            for (int j = 0; j < i; j++) {
//                leftSum += a[j];
//            }
//            for (int j = i; j < a.length; j++) {
//                rightSum += a[j];
//            }
//            if (leftSum == rightSum) {
//                return true;
//            }
//        }
        return false;
    }
    */

    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void taskSeven(int[] a, int n) {
        System.out.println("\n\nTask 7.");
        // 1 2 3 4 5 + 10 -> 2 3 4 5 1
        // 1 2 3 4 5 - 1 -> 5 1 2 3 4
        // -1 = +4
        // +10 = 0
        // 10 % 5 = 0
        // 12 % 5 = +2

        // 1 2 3 4 5
        // -1
        // 5 1 2 3 4
        // ...
        // - 1 = +4
        // \1 \2 \3 \4 5 1 2 3 4        -1 = 5 - 1 = 4
        // n = -1
        // if (n < 0)
        // n = -n // (n = 1)
        // n =5 - n
        // n % length (отбрасываем лишние циклы)
        if (n < 0) {
            n = -n;
            n = n % a.length;
            n = a.length -n;
        }
        n = n % a.length;//4 % 5 = 4
        //System.out.println(n);
        for (int i = 0; i < n; i++) {
            int tmp = a[0];
            //1 2 3 4 5 -> 1, 2 3 4 5 1
            // 1 2 3 4 5
            // doing this -> 2 3 4 5
            /*
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            */
            //optimizing fori by replacing with System.arraycopy()
            System.arraycopy(a, 1, a, 0, a.length - 1);
            a[a.length - 1] = tmp;
        }
        System.out.println(Arrays.toString(a));

        //second version
        /*
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\r\n");

        if (n > 0) {
            for (int j = 0; j < n; j++) {
                int b = a[a.length - 1];
                for (int x = a.length - 1; x > 0; x--) {
                    a[x] = a[x - 1];
                }
                a[0] = b;
                for (int i : a) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        } else if (n < 0) {
            for (int j = 0; j > n; j--) {
                int b = a[0];
                for (int x = 0; x < a.length - 1; x++) {
                    a[x] = a[x + 1];
                }
                a[a.length - 1] = b;
                for (int i : a) {
                    System.out.print(i + " ");
                }
                System.out.print("\r\n");
            }
        }
        */
    }

    public static void taskSevenON(int[] input, int n) {
        System.out.println("\n\nTask 7.");
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

}