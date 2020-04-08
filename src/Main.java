import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.shuffle;

//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
//7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

public class Main {

    static void method1() {
        int[] array1 = new int[10];
        System.out.println("\nВ результате выполнения метода #1 - сгенерированный массив: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 2);
            System.out.printf("%3d", array1[i]);
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }
        System.out.println("\nБыл преобразован в массив: \n" + Arrays.toString(array1));
    }

    static void method2() {
        int[] array1 = new int[8];
        for (int i = 1; i < array1.length; i++) {
            array1[i] = array1[i - 1] + 3;
        }
        System.out.println("\nВ результат выполнения метода #2 - получился массив: \n" + Arrays.toString(array1));
    }

    static void method3() {
        int[] array1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nВ результате выполнения метода #3 - массив: \n" + Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < 6) array1[i] = array1[i] * 2;
        }
        System.out.println("Был преобразован в массив: \n" + Arrays.toString(array1));
    }

    static void method4() {
        int[][] array1 = new int[12][12];
        System.out.println("\nВ результат выполнения метода #4 - получился массив:");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0, jreverse = array1[i].length; j < array1[i].length; j++, jreverse--) {
                if (i == j || i == (jreverse - 1)) array1[i][j] = 1;
                System.out.print(array1[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static void method5() {
        //Захотел, чтобы в массиве были только уникальные значения. Это решение показалось самым симпатичным. Неужели нет возможности сразу генерировать в массиве уникальные значения?
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        shuffle(numbers);
        int[] array1 = new int[10];
        System.out.println("\nВ результате выполнения метода #5 - сгенерировался массив: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = numbers.get(i);
        }
        System.out.println(Arrays.toString(array1));
        int min = array1[0], max = array1[0], indexMin = 0, indexMax = 0;
        for (int i = 0; i < array1.length; i++) {
            if (max < array1[i]) {
                max = array1[i];
                indexMax = i;
            }
            if (min > array1[i]) {
                min = array1[i];
                indexMin = i;
            }
        }
        System.out.println("Максимальное элемент массива находится по индексу: " + indexMax + " и имеет значение: " + max);
        System.out.println("Минимальный элемент массива находится по индексу: " + indexMin + " и имеет значение: " + min);
    }

    static boolean method6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += leftSum;
            }
            for (int j = 0; j < array.length; j++) {
                rightSum += rightSum;

            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    static void method7(int[] array, int n) {
        System.out.println("\nИсходный сгенерированный массив для метода #7 - выглядит следующим образом: \n" + Arrays.toString(array) + "\nВведенный сдвиг элементов массива равен: " + n);
        if (n > 0) {
            while (n > 0) {
                int arrayLastElement = array[array.length - 1];
                for (int i = 0; i < array.length; i++) {
                    int arrayCurrentElement = array[i];
                    array[i] = arrayLastElement;
                    arrayLastElement = arrayCurrentElement;
                }
                n--;
            }
            System.out.println("Результат выполнения метода #7: \n" + Arrays.toString(array));
        }
        if (n < 0) {
            while (n < 0) {
                int arrayFirstElement = array[0];
                for (int i = array.length; i > 0; i--) {
                    int arrayCurrentElement = array[i-1];
                    array[i - 1] = arrayFirstElement;
                    arrayFirstElement = arrayCurrentElement;
                }
                n++;
            }
        }
        System.out.println("Результат выполнения метода #7: \n" + Arrays.toString(array));
    }

    //psvm public static void main
    public static void main(String[] args) {
        //sout
        method1();
        method2();
        method3();
        method4();
        method5();

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.println("\nРезультат выполнения метода  #6: " + method6(array));

        int n = -3;
        System.out.println(Arrays.toString(array));

        method7(array, n);
    }
}
