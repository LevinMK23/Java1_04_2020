package HomeWork;

import java.sql.SQLOutput;
import java.util.Arrays;

public class lesson_2 {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 1, 1, 0, 0, 0, 0, 1, 0};
        System.out.println(Arrays.toString(modifyArray(numbers)));

        int[] array = new int[8];
        fillArray(array);

        int[] array_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArray(array_3);

        int[][] twoDimArray = new int[5][5];
        fillArrayWith_1(twoDimArray);

        int[] array_5 = {5, 7, 12, -5, 76, 0};
        finExtremums(array_5);

        int[] arrayBalance = {2, 2, 2, 6};
        System.out.println(checkBalance(arrayBalance));

        int[] arr_7 = {1, 2, 3, 4, 5, 6};
        moveArr(arr_7, -16);

    }

    //task_1
    //Задать целочисленный массив, состоящий из элементов 0 и 1.
    //Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static int[] modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    //task_2
    //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void fillArray(int[] arr) {
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    //task_3
    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    //task_4
    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    private static void fillArrayWith_1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length - i - 1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    //task_5
    // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static void finExtremums(int[] arr) {
        //если массив пустой,  выходим из метода
        if (arr.length == 0) return;
        int max = arr[0];
        int min = arr[0];
        for (int a : arr) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        System.out.println("Max: " + max + " Min: " + min);
    }

    //Task_6
    //** Написать метод, в который передается не пустой одномерный
    // целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма
    // левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    private static boolean checkBalance(int[] arr) {
        //если массив пустой,  выходим из метода
        if (arr.length == 0) return false;
        boolean balance = false;
        int summLeft = 0;
        int summRight = 0;
        for (int i = 1; i < arr.length; i++) {
            summLeft = summLeft + arr[i - 1];
            for (int j = i; j < arr.length; j++) {
                summRight = summRight + arr[j];
            }
            if (summLeft == summRight) {
                balance = true;
                break;
            }
            summRight = 0;
        }
        return balance;
    }

    //task_7
    //**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
    // задачи нельзя пользоваться вспомогательными массивами.
    private static void moveArr(int[] arr, int n) {
        if (n == 0) System.out.println("Массив не изменился");
        if (n > arr.length) n = n % arr.length;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tempLastElement = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                    int temp = arr[j];
                }
                arr[0] = tempLastElement;
            }
        }
        if (n < 0){
            for (int i = 0; i > n; i--) {
                int tempFirstElement = arr[0];
                for (int j = 0; j < arr.length-1; j++) {
                    arr[j] = arr[j + 1];
                    int temp = arr[j];
                }
                arr[arr.length-1] = tempFirstElement;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}




