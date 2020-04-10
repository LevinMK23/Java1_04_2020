import java.lang.Math;

public class Tasks {

    public static void main(String[] args) {
        this.task1();
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
    public static void print2DArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int calculateSubArraySum(int[] arr, int a, int b) {
        int sum = 0;

        for (int i = a; i < b; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static void task1() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Task1: original array:");

        printArray(arr);
        System.out.println("Refactored array:");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
        printArray(arr);
    }

    public static void task2() {
        int[] arr = new int[8];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        System.out.println("Task2: filled array:");
        printArray(arr);
    }

    public static void task3() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("Task3: original array");
        printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2: arr[i];
        }

        System.out.println("Refactored array:");
        printArray(arr);
    }

    public static void task4() {
        int[][] arr = new int[5][5];

        System.out.println("Task4: original array");
        print2DArray(arr);
        System.out.println("Task4: refactored array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        print2DArray(arr);
    }

    public static void task5() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int min = arr[0];
        int max = arr[0];

        System.out.println("Task5: original array");
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.printf("Task5: min = %d max = %d\n", min, max);
    }

    public static void task6() {
        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println("Task6: original array");
        printArray(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int leftSum = calculateSubArraySum(arr, 0, i + 1);
            int rightSum = calculateSubArraySum(arr, i + 1, arr.length);
            if (leftSum == rightSum) {
                System.out.printf("Task6: arrayMid = %d leftSum = %d rightSum = %d\n", i, leftSum, rightSum);
            }
        }
    }

    public static void task7(int[] arr, int n) {
        System.out.println("Task7: original array");
        printArray(arr);

        int shiftIndex = n % arr.length;
        System.out.printf("Task7: shift index = %d\n" , shiftIndex);

        if (shiftIndex > 0) {
            for (int t = 0; t < shiftIndex; t++) {
                int last = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];

                }
                arr[0] = last;
            }
        } else {
            for (int t = shiftIndex; t < 0; t++) {
                int first = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = first;
            }
        }

        System.out.println("Task7: refactored array");
        printArray(arr);
    }
}