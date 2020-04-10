
public class HomeWorkTwo{
    public  static void main(String [] args){

    }

    // Lesson 2. Task 1

    public static void array() {
        int[] arrFirst = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < 10; i++) {
            if (arrFirst[i] == 0) {
                arrFirst[i] = 1;
            } else {
                arrFirst[i] = 0;
            }
            System.out.println(arrFirst[i] + " ");
        }
    }

    // Lesson 2. Task 2

    public static void fillArray(){
        int [] array = new int [8];
        for (int i = 0; i < array.length ; i++) {
            i *= 3;
        }
        System.out.println(Array.toStrin(array));
    }


    // Lesson 2. Task 3

    public static void multiplyBy(){
        int [] array = new int []{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < array.length; i++){
            if (array[i] < 6){
                array[i] *= 2;
            }
            System.out.println(array);
        }
    }

    // Lesson 2. Task 5

    public static  void findIndex() {
        int[] arrFourth = new int[]{4, 8, 3, 6, 1, 2, 12, 16, 14, 19};

        int elMin = arrFourth[0];
        int elMax = arrFourth[0];

        for (int i = 0; i < arrFourth.length; i++) {
            if (arrFourth[i] <= elMin) {
                arrFourth[i] = elMin;
            } else {
                arrFourth[i] = elMax;
            }
        }

        System.out.println("Минимальный элемент: " + elMin);
        System.out.println("Максимальный элемент: " + elMax);
    }
}