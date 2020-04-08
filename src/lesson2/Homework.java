package lesson2;




import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4(9);
        task5();
        task5_v2();
        int[] arrForTask6 = {2, 2, 2, 1, 2, 2, 10, 2};
        System.out.println("\nВ массиве есть место где сумма частей равна? " + task6(arrForTask6));
        int[] arrForTask7 = {123, 213, 3, 400};
        task7(arrForTask7,-2);
    }


    private static void task1() {
        int [] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2);
        }
        System.out.print("Массив 1 задания, сгенерированный случайно до изменения:\n" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("\nМассив с изменёнными значениями:\n" + Arrays.toString(arr) + "\n");
    }



    private static void task2() {
        int[] array = new int[8];
        for (int i = 1; i < array.length; i++) {
            array[i] = i * 3;
        }
        System.out.println("Массив 2 задания: \n" + Arrays.toString(array) + "\n");
    }



    private static void task3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив 3 задания:\n" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println("Изменённый массив 3 задания:\n" + Arrays.toString(array) + "\n");
    }



    private static void task4(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array.length - i - 1) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        System.out.println("Массив 4 задания:");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }



    private static void task5() {
        int [] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("\nСлучайно созданный массив:\n" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Наименьший элемент: " + arr[0] + "\nНаибольший элемент: " + arr[arr.length-1]);
    }


    private static void task5_v2() {
        int [] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("\nСлучайно созданный массив(второй вариант):\n" + Arrays.toString(arr));
        int min = arr[0], max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Наименьший элемент: " + min + "\nНаибольший элемент: " + max);
    }




    private static boolean task6(int [] arr) {
        int s = 0, p1 = 0, p2 = 0;
        for (int a: arr) {
            s += a;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((s / 2) > p1) {
                p1 += arr[i];
            } else {
                p2 += arr[i];
            }
        }
        return p1 == p2;
    }




    private static void task7(int[] arr, int n) {
        System.out.println("\nМассив до смещения на n(" + n + ") элементов:\n" + Arrays.toString(arr));
        if (n > 0) {
            while (n > 0) {
                int lastValue = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    int value = arr[i];
                    arr[i] = lastValue;
                    lastValue = value;
                }
                n--;
            }
        } else {
            while (n < 0) {
                int lastValue = arr[arr.length-1];
                for (int i = arr.length-1; i >= 0; i--) {
                    int value = arr[i];
                    arr[i] = lastValue;
                    lastValue = value;
                }
                n++;
            }
        }
        System.out.println("Массив после смещения: \n" + Arrays.toString(arr));
    }
}

    

