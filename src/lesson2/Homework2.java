import java.util.Arrays;

public class Homework2 {

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
    }

    public static void Task1() {
        int[] array1 = {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1};
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }
        System.out.println("1. " + Arrays.toString(array1) + "\n");
    }

    public static void Task2() {
        int[] array2 = new int[8];
        int x = 0;
        for (int i = 0; i < array2.length; i++) {
            array2[i] = x;
            x += 3;
        }
        System.out.println("2. " + Arrays.toString(array2) + "\n");
    }

    public static void Task3() {
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println("3. " + Arrays.toString(array3) + "\n");
    }

    public static void Task4() {
        System.out.println("4. ");
        System.out.println("=========");
        int array4[][] = new int[5][5];
        int count1 = 0;
        int count2 = array4[array4.length - 1].length - 1;
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                array4[i][count1] = 1;
                array4[i][count2] = 1;
                System.out.print(array4[i][j] + " ");
            }
            count1++;
            count2--;
            System.out.println();
        }
        System.out.println("=========" + "\n");
    }

    public static void Task5() {
        System.out.println("5. ");
        int[] array5 = new int[10];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = (int) (Math.random() * 100);
        }

        int max = array5[0];
        int min = array5[0];

        for (int i = 0; i < array5.length; i++) {
            if (min > array5[i]) {
                min = array5[i];
            }
            if (max < array5[i]) {
                max = array5[i];
            }
        }
        System.out.println(Arrays.toString(array5));
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max + "\n");

    }
}
