import java.util.Arrays;

public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        //sout
        //System.out.println("Hello world");

        int[] arrTask1 = {1,0,1,1,0};
        Task_1(arrTask1);

        int[] arrTask2 = new int[8];
        Task_2(arrTask2);

        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Task_3(arrTask3);

        int[][] arrTask4 = new int[10][10];
        Task_4(arrTask4);

        int[] arrTask5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -1};
        Task_5(arrTask5);

        int[] arrTask6 = {1, 2, 3, 2, 6, 2};
        boolean result6;
        result6 = Task_6(arrTask6);
        System.out.println(""+result6);

       int[] arrTask7 = {1, 2, 3, 4, 5, 6};
       Task_7(arrTask7,2);
       Task_7(arrTask7,-2);
    }

    static void Task_1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i]== 1) {
                arr[i] = 0;
            }
            else {arr[i] = 1;}

        }
        System.out.println(Arrays.toString(arr));

    }

    static void Task_2(int[] arr) {

       int value = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = value;
            value = value +3;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void Task_3(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 6) {
                arr[i] =  arr[i]*2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void Task_4(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void Task_5(int[] arr) {

        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < minValue) {
               minValue = arr[i];
            }

            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }

        }
        System.out.println(""+minValue);
        System.out.println(""+maxValue);
    }

    static boolean Task_6(int[] arr) {

        int valueBefore = 0;
        int valueAfter = 0;
        for (int i = 0; i < arr.length; i++) {
            valueAfter = valueAfter + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            valueBefore = valueBefore + arr[i];
            valueAfter  = valueAfter - arr[i];
            if (valueBefore == valueAfter) {
               return true;
            }

        }
        return false;
        //System.out.println(Arrays.toString(arr));
    }

    static void Task_7(int[] array, int totalOffset) {

        int[] arr = array.clone();

        int position = 0;
        int prevValue;
        int offset;

        if (totalOffset > 0) {
            offset = 1;
        }
        else {
            offset = -1;
            totalOffset = -totalOffset;
        }

       for (int j = 0; j < totalOffset; j++){

            for (int i = 0; i < arr.length; i++) {

                position = position + offset;
                if (position == arr.length) {
                    position = 0;
                }
                else if (position == -1) {
                    position = arr.length-1;
                }

                prevValue  = arr[position];

                arr[position] = arr[0];
                arr[0]        = prevValue;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
