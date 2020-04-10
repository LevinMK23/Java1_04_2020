package lesson2;

public class Homework {
    public static void main(String[] args) {
        int[] arr1 = {0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1};
        System.out.println("Задание 1 ");
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else arr1[i] = 1;
            System.out.print(" " + arr1[i]); }
        System.out.println();

        int[] arr2= new int[8];
        System.out.println("Задание 2 ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
            System.out.print(" " + arr2[i]); }
        System.out.println();

        int arr3[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Задание 3 ");
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;}
            else arr3[i] = arr3[i];
            System.out.print(" " + arr3[i]);}
        System.out.println();

        int[][] arr4 = new int[11][11];
        System.out.println("Задание 4 ");
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                if (i == j){
                    arr4[i][j] = 1;}
                else if (i == arr4.length -(j+1)) {
                    arr4[i][j] = 1;}
                else arr4 [i][j] = 0;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Задание 5 ");
        int arr5[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 6 };
        int max = arr5[0]; int min = arr5[0], indexMax = 0, indexMin = 0;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
                indexMax = i;
            }
            if (arr5[i] < min) {
                min = arr5[i];
                indexMin = i;
            }
        }
        System.out.println("Максимальное значение равно " + max + " и находится в индексе " + indexMax );
        System.out.println("Минимальное значение равно " + min + " и находится в индексе " + indexMin );

        int[] arr6 = {5, 3, 9, 1, 15, 8, 5, 6, 4, 8, 1, 1};
        System.out.println("Задание 6 ");
        System.out.println("Результат = " + check(arr6));
    }
    private static boolean check(int[] a) {
        int sumLeft, sumRight;
        for (int i = 0; i < a.length + 1; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += a[j];
            }
            for (int j = i; j < a.length; j++) {
                sumRight += a[j];
            }
            if (sumRight == sumLeft) return true;
        }
        return false;
        }
    }
