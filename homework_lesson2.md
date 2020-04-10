import java.util.Arrays;

public class Main {

    // task 1
 public static void changeNumbers(int[] arr1){
     for (int i = 0; i < arr1.length ; i++) {
         if (arr1[i] ==1) {
             arr1[i] =0;
         } else {
             arr1[i] = 1;
         }
     }
     System.out.println(Arrays.toString(arr1));
 }

 //task 2
    public static void fillArray(int[] arr2){
        int j = 0;
        for (int i = 0; i < arr2.length ; i++) {
            arr2[i] = j;
            j +=3;
        }
        System.out.println(Arrays.toString(arr2));
    }

//task 3
    public static void changeArrayMembers(int[] arr3){
        for (int i = 0; i < arr3.length ; i++) {
            if(arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }

//task 4
    public static void fillDiagonal(int[][] arr4){
        for (int i = 0; i < arr4.length ; i++) {
            for(int j = 0, j2 = (arr4[i].length -1); j < arr4[i].length && j2 >=0; j++, j2--) {
                if(i == j || i == j2) {
                    arr4[i][j] = 1;
                }
            }
            }
        }


//task 5
    public static int[] genRandomArray(int length, int number){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random()*number);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void findMinMax(int[] arr5){
        int max = arr5[0];
        for (int i = 1; i < arr5.length ; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
        }
        }
        System.out.println("Максимальное значение в массиве: "  + max);
        int min = arr5[0];
        for (int i = 1; i < arr5.length ; i++) {
            if (arr5[i] < min){
                min = arr5[i];
            }
        }
        System.out.println("Минимальное значение в массиве: "  + min);
    }

//task 6
   public static boolean checkBalance (int[] arr6) {
     int sumright = 0;
     int sumleft = 0;
        for (int i = 0, j = (arr6.length -1); i < arr6.length && j >= 0; i++, j--) {
            sumright = sumright + arr6[j];
            sumleft = sumleft + arr6[i];
                boolean balance = (sumright == sumleft);
                if (balance) {
                    break;
                }
            }
        return true;
    }



    public static void main(String[] args) {

     int[] task1 = {1,0,0,1,0,1,1,0,1,0};
     changeNumbers(task1);

     int[] task2 = new int[8];
     fillArray(task2);

     int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
     changeArrayMembers(task3);

     int[][] task4 = new int[5][5];
     fillDiagonal(task4);

     int[] task5 = genRandomArray(7, 100);
     findMinMax(task5);

     int[] task6 = {1,1,1,2,1};
     checkBalance(task6);

        }

        }





